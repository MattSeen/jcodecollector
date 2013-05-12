package jcodecollector.data;

import junit.framework.*;

/**
 * The class <code>SearchFilterTest</code> contains tests for the class <code>{@link SearchFilter}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:21
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class SearchFilterTest extends TestCase {
    /**
     * Run the int countSearchTypeEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testCountSearchTypeEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        int result = fixture.countSearchTypeEnabled();

        // add additional test code here
        assertEquals(4, result);
    }

    /**
     * Run the int countSearchTypeEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testCountSearchTypeEnabled_2()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        int result = fixture.countSearchTypeEnabled();

        // add additional test code here
        assertEquals(4, result);
    }

    /**
     * Run the SearchFilter getInstance() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetInstance_1()
        throws Exception {

        SearchFilter result = SearchFilter.getInstance();

        // add additional test code here
        assertNotNull(result);
        assertEquals(false, result.isSearchCaseSensitive());
        assertEquals(true, result.isSearchInCodeEnabled());
        assertEquals(true, result.isSearchInNameEnabled());
        assertEquals(true, result.isSearchInTagsEnabled());
        assertEquals(true, result.isSearchInCommentEnabled());
        assertEquals(4, result.countSearchTypeEnabled());
    }

    /**
     * Run the boolean isSearchCaseSensitive() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchCaseSensitive_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchCaseSensitive();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchCaseSensitive() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchCaseSensitive_2()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchCaseSensitive();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInCodeEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInCodeEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchInCodeEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInCodeEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInCodeEnabled_2()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchInCodeEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInCommentEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInCommentEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchInCommentEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInCommentEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInCommentEnabled_2()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchInCommentEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInNameEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInNameEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchInNameEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInNameEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInNameEnabled_2()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchInNameEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInTagsEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInTagsEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchInTagsEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInTagsEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInTagsEnabled_2()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();

        boolean result = fixture.isSearchInTagsEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the void setSearchCaseSensitive(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchCaseSensitive_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();
        boolean searchCaseSensitive = true;

        fixture.setSearchCaseSensitive(searchCaseSensitive);

        // add additional test code here
    }

    /**
     * Run the void setSearchInCodeEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchInCodeEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();
        boolean searchInCodeEnabled = true;

        fixture.setSearchInCodeEnabled(searchInCodeEnabled);

        // add additional test code here
    }

    /**
     * Run the void setSearchInCommentEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchInCommentEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();
        boolean searchInCommentEnabled = true;

        fixture.setSearchInCommentEnabled(searchInCommentEnabled);

        // add additional test code here
    }

    /**
     * Run the void setSearchInNameEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchInNameEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();
        boolean searchInNameEnabled = true;

        fixture.setSearchInNameEnabled(searchInNameEnabled);

        // add additional test code here
    }

    /**
     * Run the void setSearchInTagsEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchInTagsEnabled_1()
        throws Exception {
        SearchFilter fixture = SearchFilter.getInstance();
        boolean searchInTagsEnabled = true;

        fixture.setSearchInTagsEnabled(searchInTagsEnabled);

        // add additional test code here
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
            junit.textui.TestRunner.run(SearchFilterTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new SearchFilterTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}