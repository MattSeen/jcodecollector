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
package jcodecollector;

import java.util.ArrayList;

import jcodecollector.common.bean.Snippet;
import jcodecollector.data.Controller;
import jcodecollector.data.DBMS;
import jcodecollector.listener.iCategoryListener;
import jcodecollector.listener.iCountListener;
import jcodecollector.listener.iMenuListener;
import jcodecollector.listener.iSearchListener;
import jcodecollector.listener.iSnippetListener;
import jcodecollector.listener.iWindowListener;

/**
 * Warning... using singleton pattern
 * 
 * @author MattSeen
 * 
 */
public class State implements iSnippetListener, iCategoryListener, iCountListener, iMenuListener,
        iWindowListener, iSearchListener {

    private ArrayList<iSnippetListener>  snippetListeners;
    private ArrayList<iCategoryListener> categoryListeners;
    private ArrayList<iCountListener>    countListeners;
    private ArrayList<iMenuListener>     menuListeners;
    private ArrayList<iWindowListener>   windowListeners;
    private ArrayList<iSearchListener>   searchListeners;

    private String                       nameOfSelectedCategory;
    private String                       nameOfSelectedSnippet;
    private boolean                      snippetSaved;
    private boolean                      snippetValidated;
    private boolean                      snippetLocked;
    private Snippet                      previousSnippet;
    private boolean                      searchActive;

    /** The only permitted instance of this class. */
    private static State                 state = new State();

    private State() {
        snippetListeners = new ArrayList<iSnippetListener>();
        categoryListeners = new ArrayList<iCategoryListener>();
        countListeners = new ArrayList<iCountListener>();
        menuListeners = new ArrayList<iMenuListener>();
        windowListeners = new ArrayList<iWindowListener>();
        searchListeners = new ArrayList<iSearchListener>();
    }

    public static State getInstance() {
        return state;
    }

    public void addSnippetListener(iSnippetListener listener) {
        snippetListeners.add(listener);
    }

    public boolean removeSnippetListener(iSnippetListener listener) {
        return snippetListeners.remove(listener);
    }

    public void addCategoryListener(iCategoryListener listener) {
        categoryListeners.add(listener);
    }

    public boolean removeCategoryListener(iCategoryListener listener) {
        return categoryListeners.remove(listener);
    }

    public void addCountListener(iCountListener listener) {
        countListeners.add(listener);
    }

    public boolean removeCountListener(iCountListener listener) {
        return countListeners.remove(listener);
    }

    public void addMenuListener(iMenuListener listener) {
        menuListeners.add(listener);
    }

    public boolean removeMenuListener(iMenuListener listener) {
        return menuListeners.remove(listener);
    }

    public void addWindowListener(iWindowListener listener) {
        windowListeners.add(listener);
    }

    public boolean removeWindowListener(iWindowListener listener) {
        return windowListeners.remove(listener);
    }

    public void addSearchListener(iSearchListener listener) {
        searchListeners.add(listener);
    }

    public boolean removeSearchListener(iSearchListener listener) {
        return searchListeners.remove(listener);
    }

    /**
     * @see jcodecollector.listener.iCategoryListener#categoriesUpdated(java.
     *      lang.String)
     */
    public void categoriesUpdated(String selected) {
        for (iCategoryListener listener : categoryListeners) {
            listener.categoriesUpdated(selected);
        }
    }

    /**
     * @see jcodecollector.listener.iCategoryListener#categoryRemoved(java.lang
     *      .String)
     */
    public void categoryRemoved(String name) {
        for (iCategoryListener listener : categoryListeners) {
            listener.categoryRemoved(name);
        }
    }

    /**
     * @see jcodecollector.listener.iCategoryListener#categoryRenamed(java.lang
     *      .String, java.lang.String)
     */
    public void categoryRenamed(String oldName, String newName) {
        for (iCategoryListener listener : categoryListeners) {
            listener.categoryRenamed(oldName, newName);
        }
    }

    /** @see jcodecollector.listener.iSnippetListener#snippetRemoved(Snippet) */
    public void snippetRemoved(Snippet snippet) {
        for (iSnippetListener listener : snippetListeners) {
            listener.snippetRemoved(snippet);
        }
    }

    /**
     * @see jcodecollector.listener.iSnippetListener#snippetRenamed(java.lang.String,
     *      java.lang.String)
     */
    public void snippetRenamed(String oldName, String newName) {
        for (iSnippetListener listener : snippetListeners) {
            listener.snippetRenamed(oldName, newName);
        }
    }

    /** @see iSnippetListener#snippetEdited(Snippet) */
    public void snippetEdited(Snippet snippet) {
        for (iSnippetListener listener : snippetListeners) {
            listener.snippetEdited(snippet);
        }
    }

    /** @see iSnippetListener#syntaxRenamed(String, String) */
    public void syntaxRenamed(String newName, String category) {
        for (iSnippetListener listener : snippetListeners) {
            listener.syntaxRenamed(newName, category);
        }
    }

    /**
     * Count how many categories and many snippets are present in the database
     * or as Search result.
     */
    public void countUpdate() {
        int categories;
        int snippets;

        if (searchActive) {
            categories = Controller.getInstance().countCategories();
            snippets = Controller.getInstance().countSnippets();
        } else {
            categories = DBMS.getInstance().countCategories();
            snippets = DBMS.getInstance().countSnippets();
        }

        countUpdate(categories, snippets);
    }

    /** @see iCountListener#countUpdate(int, int) */
    public void countUpdate(int categories, int snippets) {
        for (iCountListener listener : countListeners) {
            listener.countUpdate(categories, snippets);
        }
    }

    public void updateSnippetStatus(boolean validated, boolean saved, boolean locked) {
        this.snippetValidated = validated;
        this.snippetSaved = saved;
        this.snippetLocked = locked;

        for (iSnippetListener listener : snippetListeners) {
            listener.updateSnippetStatus(validated, saved, locked);
        }
    }

    public void updateMenu(boolean enabled, boolean resetExportSubMenu) {
        for (iMenuListener listener : menuListeners) {
            listener.updateMenu(enabled, resetExportSubMenu);
        }
    }

    /** @see iWindowListener#updateWindowStatus(boolean) */
    public void updateWindowStatus(boolean documentModified) {
        for (iWindowListener listener : windowListeners) {
            listener.updateWindowStatus(documentModified);
        }
    }

    /** @see iWindowListener#updateLineNumbers(boolean) */
    public void updateLineNumbers(boolean enabled) {
        for (iWindowListener listener : windowListeners) {
            listener.updateLineNumbers(enabled);
        }
    }

    public void setNameOfSelectedCategory(String selectedCategory) {
        this.nameOfSelectedCategory = selectedCategory;
    }

    public void setNameOfSelectedSnippet(String selectedSnippet) {
        this.nameOfSelectedSnippet = selectedSnippet;
    }

    public String getNameOfSelectedCategory() {
        return this.nameOfSelectedCategory;
    }

    public String getNameOfSelectedSnippet() {
        return this.nameOfSelectedSnippet;
    }

    public void setSnippetLocked(boolean snippetLocked) {
        this.snippetLocked = snippetLocked;
    }

    public boolean isSnippetValidated() {
        return snippetValidated;
    }

    public boolean isSnippetSaved() {
        return snippetSaved;
    }

    public boolean isSnippetLocked() {
        return snippetLocked;
    }

    public void setPreviousSnippet(Snippet previousSnippet) {
        this.previousSnippet = previousSnippet;
    }

    public Snippet getPreviousSnippet() {
        return previousSnippet;
    }

    /** @see iSearchListener#updateSearch(boolean) */
    public void updateSearch(boolean active) {
        searchActive = active;

        for (iSearchListener listener : searchListeners) {
            listener.updateSearch(!active);
        }
    }

    public boolean isSearchActive() {
        return searchActive;
    }

    public void startSearch() {
        searchActive = true;
    }

    public void stopSearch() {
        searchActive = false;
    }

    public boolean isDatabaseEmpty() {
        return DBMS.getInstance().countCategories() == 0;
    }

}
