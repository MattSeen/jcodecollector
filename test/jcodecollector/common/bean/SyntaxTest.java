package jcodecollector.common.bean;

import java.util.ArrayList;
import java.util.Collection;
import junit.framework.*;

/**
 * The class <code>SyntaxTest</code> contains tests for the class <code>{@link Syntax}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:26
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class SyntaxTest extends TestCase {
    /**
     * Run the Syntax() constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSyntax_1()
        throws Exception {

        Syntax result = new Syntax();

        // add additional test code here
        assertNotNull(result);
        assertEquals("", result.getName());
        assertEquals("", result.getKeywordsAsString());
    }

    /**
     * Run the Syntax(String) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSyntax_2()
        throws Exception {
        String name = "";

        Syntax result = new Syntax(name);

        // add additional test code here
        assertNotNull(result);
        assertEquals("", result.getName());
        assertEquals("", result.getKeywordsAsString());
    }

    /**
     * Run the Syntax(String,Collection<String>) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSyntax_3()
        throws Exception {
        String name = "";
        Collection<String> keywords = new ArrayList<String>();

        Syntax result = new Syntax(name, keywords);

        // add additional test code here
        assertNotNull(result);
        assertEquals("", result.getName());
        assertEquals("", result.getKeywordsAsString());
    }

    /**
     * Run the Syntax(String,String[]) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSyntax_4()
        throws Exception {
        String name = "";
        String[] keywords = new String[] {};

        Syntax result = new Syntax(name, keywords);

        // add additional test code here
        assertNotNull(result);
        assertEquals("", result.getName());
        assertEquals("", result.getKeywordsAsString());
    }

    /**
     * Run the int compareTo(Syntax) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testCompareTo_1()
        throws Exception {
        Syntax fixture = new Syntax("", new String[] {});
        Syntax o = new Syntax("", new String[] {});

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
        Syntax fixture = new Syntax("", new String[] {});
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
        Syntax fixture = new Syntax("", new String[] {});
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
        Syntax fixture = new Syntax((String) null, new String[] {});
        Object obj = new Syntax((String) null, new String[] {});

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
        Syntax fixture = new Syntax("", new String[] {});
        Object obj = new Syntax("", new String[] {});

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
        Syntax fixture = new Syntax("", new String[] {});
        Object obj = new Syntax("", new String[] {});

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
        Syntax fixture = new Syntax("", new String[] {});
        Object obj = new Syntax("", new String[] {});

        boolean result = fixture.equals(obj);

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the String[] getKeywords() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetKeywords_1()
        throws Exception {
        Syntax fixture = new Syntax("", new String[] {});

        String[] result = fixture.getKeywords();

        // add additional test code here
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    /**
     * Run the String getKeywordsAsString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetKeywordsAsString_1()
        throws Exception {
        Syntax fixture = new Syntax("", new String[] {});

        String result = fixture.getKeywordsAsString();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getKeywordsAsString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testGetKeywordsAsString_2()
        throws Exception {
        Syntax fixture = new Syntax("", new String[] {});

        String result = fixture.getKeywordsAsString();

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
        Syntax fixture = new Syntax("", new String[] {});

        String result = fixture.getName();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the void setKeywords(String[]) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testSetKeywords_1()
        throws Exception {
        Syntax fixture = new Syntax("", new String[] {});
        String[] keywords = new String[] {};

        fixture.setKeywords(keywords);

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
        Syntax fixture = new Syntax("", new String[] {});
        String name = "";

        fixture.setName(name);

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
            junit.textui.TestRunner.run(SyntaxTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new SyntaxTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}