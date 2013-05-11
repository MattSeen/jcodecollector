/*
 * Copyright 2006-2013 Alessandro Cocco.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jcodecollector.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import jcodecollector.common.bean.Snippet;

public class SearchResults {

    /** The map that contains the snippet ordered by category. */
    private TreeMap<String, TreeSet<String>> data          = null;

    private static SearchResults             searchResults = new SearchResults();

    public static SearchResults getInstance() {
        return searchResults;
    }

    private SearchResults() {
        this.data = new TreeMap<String, TreeSet<String>>();
    }

    public ArrayList<String> getSnippets(String category) {
        ArrayList<String> names = new ArrayList<String>();
        TreeSet<String> set = data.get(category);
        if (set != null) {
            names.addAll(data.get(category));
        }

        return names;
    }

    public ArrayList<String> getCategories() {
        return new ArrayList<String>(data.keySet());
    }

    /**
     * Asks the database to delete all the snippets of the class indicated found
     * with the latest search.
     * 
     * @param category
     *            The category of the snippet to delete.
     */
    public boolean removeCategory(String category) {
        if (!data.containsKey(category)) {
            return false;
        }

        ArrayList<String> array = getSnippets(category);
        boolean success = DBMS.getInstance().removeSnippets(array);

        if (success) {
            data.remove(category);
        }

        return success;
    }

    public boolean renameCategory(String oldName, String newName) {
        if (!data.containsKey(oldName)) {
            return false;
        }

        // I get snippets of the old category
        TreeSet<String> oldValue = data.get(oldName);

        // I remove the old category from the map
        data.remove(oldName);

        // if the new category is not 'this add with all
        // Snippet of the old category
        if (!data.containsKey(newName)) {
            data.put(newName, oldValue);
        } else {
            // otherwise add the old snippet
            TreeSet<String> newValue = data.get(newName);
            newValue.addAll(oldValue);
            data.put(newName, newValue);
        }

        // this is done I can ask the DBMS to upgrade
        return DBMS.getInstance().renameCategoryOf(new ArrayList<String>(data.get(newName)),
                newName);
    }

    public boolean removeSnippet(String name) {
        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            TreeSet<String> value = data.get(key);
            if (value.contains(name)) {
                value.remove(name);
                return DBMS.getInstance().removeSnippet(name);
            }
        }

        return false;
    }

    public boolean updateSnippet(Snippet oldSnippet, Snippet newSnippet) {
        data.get(oldSnippet.getCategory()).remove(oldSnippet.getName());

        if (data.containsKey(newSnippet.getCategory())) {
            data.get(newSnippet.getCategory()).add(newSnippet.getName());
        } else {
            TreeSet<String> value = new TreeSet<String>();
            value.add(newSnippet.getName());
            data.put(newSnippet.getCategory(), value);
        }

        return DBMS.getInstance().updateSnippet(oldSnippet, newSnippet);
    }

    public void setData(TreeMap<String, TreeSet<String>> data) {
        this.data = data;
    }

    public int size() {
        return data.size();
    }

    public int countCategories() {
        return data.keySet().size();
    }

    public int countSnippets() {
        int n = 0;

        for (String s : data.keySet()) {
            n += data.get(s).size();
        }

        return n;
    }

    public void clear() {
        data.clear();
    }

    public boolean setSyntax(String newSyntax, String category, String selected) {
        if (!data.containsKey(category)) {
            return false;
        }

        ArrayList<String> snippets = new ArrayList<String>(data.get(category));
        snippets.remove(selected);

        return DBMS.getInstance().setSyntaxToSnippets(newSyntax, snippets);
    }
}
