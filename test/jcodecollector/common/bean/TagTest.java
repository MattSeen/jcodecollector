package jcodecollector.common.bean;

import junit.framework.*;

/**
 * The class <code>TagTest</code> contains tests for the class <code>{@link Tag}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:26
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class TagTest extends TestCase {
    /**
     * Run the Tag(String,String) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testTag_1()
        throws Exception {
        String category = "";
        String name = "";

        Tag result = new Tag(category, name);

        // add additional test code here
        assertNotNull(result);
        assertEquals("", result.getName());
        assertEquals(false, result.isSelected());
        assertEquals("", result.getCategory());
    }

    /**
     * Run the Tag(String,String,boolean) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testTag_2()
        throws Exception {
        String category = "";
        String name = "";
        boolean selected = true;

        Tag result = new Tag(category, name, selected);

        // add additional test code here
        assertNotNull(result);
        assertEquals("", result.getName());
        assertEquals(true, result.isSelected());
        assertEquals("", result.getCategory());
    }

    /**
     * Run the int compareTo(Tag) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testCompareTo_1()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Tag o = new Tag("", "", true);

        int result = fixture.compareTo(o);

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the int compareTo(Tag) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testCompareTo_2()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Tag o = new Tag("", "", true);

        int result = fixture.compareTo(o);

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the int compareTo(Tag) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testCompareTo_3()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Tag o = new Tag("", "", true);

        int result = fixture.compareTo(o);

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testEquals_1()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Object obj = null;

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testEquals_2()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Object obj = new Object();

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testEquals_3()
        throws Exception {
        Tag fixture = new Tag((String) null, "", true);
        Object obj = new Tag((String) null, "", true);

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testEquals_4()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Object obj = new Tag("", "", true);

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testEquals_5()
        throws Exception {
        Tag fixture = new Tag("", (String) null, true);
        Object obj = new Tag("", (String) null, true);

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testEquals_6()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Object obj = new Tag("", "", true);

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testEquals_7()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Object obj = new Tag("", "", true);

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testEquals_8()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        Object obj = new Tag("", "", true);

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(true, result);
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
        Tag fixture = new Tag("", "", true);

        String result = fixture.getCategory();

        // add additional test code here
        assertEquals("", result);
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
        Tag fixture = new Tag("", "", true);

        String result = fixture.getName();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the boolean isSelected() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testIsSelected_1()
        throws Exception {
        Tag fixture = new Tag("", "", true);

        boolean result = fixture.isSelected();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSelected() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testIsSelected_2()
        throws Exception {
        Tag fixture = new Tag("", "", false);

        boolean result = fixture.isSelected();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the void setSelected(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetSelected_1()
        throws Exception {
        Tag fixture = new Tag("", "", true);
        boolean selected = true;

        fixture.setSelected(selected);

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
            junit.textui.TestRunner.run(TagTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new TagTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}