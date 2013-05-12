package jcodecollector.data;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import jcodecollector.common.bean.Snippet;
import junit.framework.*;

/**
 * The class <code>SearchResultsTest</code> contains tests for the class <code>{@link SearchResults}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:21
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class SearchResultsTest extends TestCase {
    /**
     * Run the void clear() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testClear_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());

        fixture.clear();

        // add additional test code here
    }

    /**
     * Run the int countCategories() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testCountCategories_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());

        int result = fixture.countCategories();

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the int countSnippets() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testCountSnippets_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());

        int result = fixture.countSnippets();

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the int countSnippets() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testCountSnippets_2()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());

        int result = fixture.countSnippets();

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the ArrayList<String> getCategories() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetCategories_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());

        ArrayList<String> result = fixture.getCategories();

        // add additional test code here
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    /**
     * Run the SearchResults getInstance() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetInstance_1()
        throws Exception {

        SearchResults result = SearchResults.getInstance();

        // add additional test code here
        assertNotNull(result);
        assertEquals(0, result.size());
        assertEquals(0, result.countCategories());
        assertEquals(0, result.countSnippets());
    }

    /**
     * Run the ArrayList<String> getSnippets(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetSnippets_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String category = "";

        ArrayList<String> result = fixture.getSnippets(category);

        // add additional test code here
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    /**
     * Run the ArrayList<String> getSnippets(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetSnippets_2()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String category = "";

        ArrayList<String> result = fixture.getSnippets(category);

        // add additional test code here
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    /**
     * Run the boolean removeCategory(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRemoveCategory_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String category = "";

        boolean result = fixture.removeCategory(category);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean removeCategory(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRemoveCategory_2()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String category = "";

        boolean result = fixture.removeCategory(category);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean removeCategory(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRemoveCategory_3()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String category = "";

        boolean result = fixture.removeCategory(category);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean removeSnippet(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRemoveSnippet_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String name = "";

        boolean result = fixture.removeSnippet(name);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean removeSnippet(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRemoveSnippet_2()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String name = "";

        boolean result = fixture.removeSnippet(name);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean removeSnippet(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRemoveSnippet_3()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String name = "";

        boolean result = fixture.removeSnippet(name);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean removeSnippet(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRemoveSnippet_4()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String name = "";

        boolean result = fixture.removeSnippet(name);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean renameCategory(String,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRenameCategory_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String oldName = "";
        String newName = "";

        boolean result = fixture.renameCategory(oldName, newName);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean renameCategory(String,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRenameCategory_2()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String oldName = "";
        String newName = "";

        boolean result = fixture.renameCategory(oldName, newName);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean renameCategory(String,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testRenameCategory_3()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String oldName = "";
        String newName = "";

        boolean result = fixture.renameCategory(oldName, newName);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the void setData(TreeMap<String,TreeSet<String>>) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetData_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        TreeMap<String, TreeSet<String>> data = new TreeMap();

        fixture.setData(data);

        // add additional test code here
    }

    /**
     * Run the boolean setSyntax(String,String,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSyntax_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String newSyntax = "";
        String category = "";
        String selected = "";

        boolean result = fixture.setSyntax(newSyntax, category, selected);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean setSyntax(String,String,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSyntax_2()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String newSyntax = "";
        String category = "";
        String selected = "";

        boolean result = fixture.setSyntax(newSyntax, category, selected);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean setSyntax(String,String,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSyntax_3()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        String newSyntax = "";
        String category = "";
        String selected = "";

        boolean result = fixture.setSyntax(newSyntax, category, selected);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the int size() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSize_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());

        int result = fixture.size();

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the boolean updateSnippet(Snippet,Snippet) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testUpdateSnippet_1()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        Snippet oldSnippet = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        Snippet newSnippet = new Snippet(1, "", "", new String[] {}, "", "", "", true);

        boolean result = fixture.updateSnippet(oldSnippet, newSnippet);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.NullPointerException
        //       at jcodecollector.data.SearchResults.updateSnippet(SearchResults.java:118)
        assertTrue(result);
    }

    /**
     * Run the boolean updateSnippet(Snippet,Snippet) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testUpdateSnippet_2()
        throws Exception {
        SearchResults fixture = SearchResults.getInstance();
        fixture.setData(new TreeMap());
        Snippet oldSnippet = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        Snippet newSnippet = new Snippet(1, "", "", new String[] {}, "", "", "", true);

        boolean result = fixture.updateSnippet(oldSnippet, newSnippet);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.NullPointerException
        //       at jcodecollector.data.SearchResults.updateSnippet(SearchResults.java:118)
        assertTrue(result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *         if the initialization fails for some reason
     *
     * @see TestCase#setUp()
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    protected void setUp()
        throws Exception {
        super.setUp();
        // add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *         if the clean-up fails for some reason
     *
     * @see TestCase#tearDown()
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    protected void tearDown()
        throws Exception {
        super.tearDown();
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            // Run all of the tests
            junit.textui.TestRunner.run(SearchResultsTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new SearchResultsTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}