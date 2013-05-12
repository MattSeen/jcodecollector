package jcodecollector.common.bean;

import junit.framework.*;

/**
 * The class <code>SnippetTest</code> contains tests for the class <code>{@link Snippet}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:26
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class SnippetTest extends TestCase {
    /**
     * Run the Snippet() constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSnippet_1()
        throws Exception {

        Snippet result = new Snippet();

        // add additional test code here
        assertNotNull(result);
        assertEquals(",", result.toString());
        assertEquals("", result.getName());
        assertEquals(-1, result.getID());
        assertEquals(false, result.isLocked());
        assertEquals("", result.getComment());
        assertEquals("", result.getCode());
        assertEquals("", result.getCategory());
        assertEquals("", result.getSyntax());
        assertEquals("", result.getTagsAsString());
    }

    /**
     * Run the Snippet(String,String,String[],String,String,String) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSnippet_2()
        throws Exception {
        String category = "";
        String name = "";
        String[] tags = new String[] {};
        String code = "";
        String comment = "";
        String syntax = "";

        Snippet result = new Snippet(category, name, tags, code, comment, syntax);

        // add additional test code here
        assertNotNull(result);
        assertEquals(",", result.toString());
        assertEquals("", result.getName());
        assertEquals(-1, result.getID());
        assertEquals(false, result.isLocked());
        assertEquals("", result.getComment());
        assertEquals("", result.getCode());
        assertEquals("", result.getCategory());
        assertEquals("", result.getSyntax());
        assertEquals("", result.getTagsAsString());
    }

    /**
     * Run the Snippet(int,String,String,String[],String,String,String,boolean) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSnippet_3()
        throws Exception {
        int id = 1;
        String category = "";
        String name = "";
        String[] tags = new String[] {};
        String code = "";
        String comment = "";
        String syntax = null;
        boolean locked = true;

        Snippet result = new Snippet(id, category, name, tags, code, comment, syntax, locked);

        // add additional test code here
        assertNotNull(result);
        assertEquals(",", result.toString());
        assertEquals("", result.getName());
        assertEquals(1, result.getID());
        assertEquals(true, result.isLocked());
        assertEquals("", result.getComment());
        assertEquals("", result.getCode());
        assertEquals("", result.getCategory());
        assertEquals("", result.getSyntax());
        assertEquals("", result.getTagsAsString());
    }

    /**
     * Run the Snippet(int,String,String,String[],String,String,String,boolean) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSnippet_4()
        throws Exception {
        int id = 1;
        String category = "";
        String name = "";
        String[] tags = new String[] {};
        String code = "";
        String comment = "";
        String syntax = "";
        boolean locked = true;

        Snippet result = new Snippet(id, category, name, tags, code, comment, syntax, locked);

        // add additional test code here
        assertNotNull(result);
        assertEquals(",", result.toString());
        assertEquals("", result.getName());
        assertEquals(1, result.getID());
        assertEquals(true, result.isLocked());
        assertEquals("", result.getComment());
        assertEquals("", result.getCode());
        assertEquals("", result.getCategory());
        assertEquals("", result.getSyntax());
        assertEquals("", result.getTagsAsString());
    }

    /**
     * Run the void addTag(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testAddTag_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        String newTag = "";

        fixture.addTag(newTag);

        // add additional test code here
    }

    /**
     * Run the Object clone() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testClone_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        Object result = fixture.clone();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the String getCategory() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetCategory_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.getCategory();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getCode() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetCode_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.getCode();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getComment() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetComment_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.getComment();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the int getID() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetID_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        int result = fixture.getID();

        // add additional test code here
        assertEquals(1, result);
    }

    /**
     * Run the String getName() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetName_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.getName();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getSyntax() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetSyntax_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.getSyntax();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String[] getTags() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetTags_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String[] result = fixture.getTags();

        // add additional test code here
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("", result[0]);
    }

    /**
     * Run the String getTagsAsString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetTagsAsString_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.getTagsAsString();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getTagsAsString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetTagsAsString_2()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);

        String result = fixture.getTagsAsString();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getTagsAsString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetTagsAsString_3()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.getTagsAsString();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getTagsAsString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetTagsAsString_4()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        fixture.addTag("");

        String result = fixture.getTagsAsString();

        // add additional test code here
        assertEquals(", , ", result);
    }

    /**
     * Run the String getTagsAsString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetTagsAsString_5()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.getTagsAsString();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the boolean isLocked() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testIsLocked_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        boolean result = fixture.isLocked();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isLocked() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testIsLocked_2()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", false);
        fixture.addTag("");

        boolean result = fixture.isLocked();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the void setCategory(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetCategory_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        String category = "";

        fixture.setCategory(category);

        // add additional test code here
    }

    /**
     * Run the void setCode(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetCode_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        String code = "";

        fixture.setCode(code);

        // add additional test code here
    }

    /**
     * Run the void setComment(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetComment_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        String comment = "";

        fixture.setComment(comment);

        // add additional test code here
    }

    /**
     * Run the void setId(int) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetId_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        int id = 1;

        fixture.setId(id);

        // add additional test code here
    }

    /**
     * Run the void setLocked(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetLocked_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        boolean locked = true;

        fixture.setLocked(locked);

        // add additional test code here
    }

    /**
     * Run the void setName(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetName_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        String name = "";

        fixture.setName(name);

        // add additional test code here
    }

    /**
     * Run the void setSyntax(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetSyntax_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        String syntax = "";

        fixture.setSyntax(syntax);

        // add additional test code here
    }

    /**
     * Run the void setTags(String[]) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetTags_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");
        String[] tags = new String[] {};

        fixture.setTags(tags);

        // add additional test code here
    }

    /**
     * Run the String toString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testToString_1()
        throws Exception {
        Snippet fixture = new Snippet(1, "", "", new String[] {}, "", "", "", true);
        fixture.addTag("");

        String result = fixture.toString();

        // add additional test code here
        assertEquals(",", result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *         if the initialization fails for some reason
     *
     * @see TestCase#setUp()
     *
     * @generatedBy CodePro at 12/05/13 15:26
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
     * @generatedBy CodePro at 12/05/13 15:26
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
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            // Run all of the tests
            junit.textui.TestRunner.run(SnippetTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new SnippetTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}