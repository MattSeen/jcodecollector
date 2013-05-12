package jcodecollector.document;

import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import junit.framework.*;

/**
 * The class <code>LimitedSyntaxDocumentTest</code> contains tests for the class <code>{@link LimitedSyntaxDocument}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:26
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class LimitedSyntaxDocumentTest extends TestCase {
    /**
     * Run the LimitedSyntaxDocument(int) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testLimitedSyntaxDocument_1()
        throws Exception {
        int maxSize = 1;

        LimitedSyntaxDocument result = new LimitedSyntaxDocument(maxSize);

        // add additional test code here
        assertNotNull(result);
        assertEquals(false, result.getCurlyBracesDenoteCodeBlocks());
        assertEquals(false, result.getCompleteMarkupCloseTags());
        assertEquals(false, result.getLanguageIsMarkup());
        assertEquals(null, result.getLineCommentStartAndEnd());
        assertEquals(false, result.isWhitespaceVisible());
        assertEquals(0, result.getLength());
        assertEquals(null, result.getDocumentFilter());
        assertEquals(-1, result.getAsynchronousLoadPriority());
    }

    /**
     * Run the LimitedSyntaxDocument(String,int) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testLimitedSyntaxDocument_2()
        throws Exception {
        String syntax = "";
        int maxSize = 1;

        LimitedSyntaxDocument result = new LimitedSyntaxDocument(syntax, maxSize);

        // add additional test code here
        assertNotNull(result);
        assertEquals(false, result.getCurlyBracesDenoteCodeBlocks());
        assertEquals(false, result.getCompleteMarkupCloseTags());
        assertEquals(false, result.getLanguageIsMarkup());
        assertEquals(null, result.getLineCommentStartAndEnd());
        assertEquals(false, result.isWhitespaceVisible());
        assertEquals(0, result.getLength());
        assertEquals(null, result.getDocumentFilter());
        assertEquals(-1, result.getAsynchronousLoadPriority());
    }

    /**
     * Run the void insertString(int,String,AttributeSet) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testInsertString_1()
        throws Exception {
        LimitedSyntaxDocument fixture = new LimitedSyntaxDocument("", 1);
        int offs = 1;
        String str = null;
        AttributeSet a = SimpleAttributeSet.EMPTY;

        fixture.insertString(offs, str, a);

        // add additional test code here
    }

    /**
     * Run the void insertString(int,String,AttributeSet) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testInsertString_2()
        throws Exception {
        LimitedSyntaxDocument fixture = new LimitedSyntaxDocument("", 1);
        int offs = 1;
        String str = "";
        AttributeSet a = SimpleAttributeSet.EMPTY;

        fixture.insertString(offs, str, a);

        // add additional test code here
    }

    /**
     * Run the void insertString(int,String,AttributeSet) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testInsertString_3()
        throws Exception {
        LimitedSyntaxDocument fixture = new LimitedSyntaxDocument("", 1);
        int offs = 1;
        String str = "";
        AttributeSet a = SimpleAttributeSet.EMPTY;

        fixture.insertString(offs, str, a);

        // add additional test code here
    }

    /**
     * Run the void insertString(int,String,AttributeSet) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testInsertString_4()
        throws Exception {
        LimitedSyntaxDocument fixture = new LimitedSyntaxDocument("", 1);
        int offs = 1;
        String str = "";
        AttributeSet a = SimpleAttributeSet.EMPTY;

        fixture.insertString(offs, str, a);

        // add additional test code here
    }

    /**
     * Run the void insertString(int,String,AttributeSet) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testInsertString_5()
        throws Exception {
        LimitedSyntaxDocument fixture = new LimitedSyntaxDocument("", 1);
        int offs = 1;
        String str = "";
        AttributeSet a = SimpleAttributeSet.EMPTY;

        fixture.insertString(offs, str, a);

        // add additional test code here
    }

    /**
     * Run the void insertString(int,String,AttributeSet) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testInsertString_6()
        throws Exception {
        LimitedSyntaxDocument fixture = new LimitedSyntaxDocument("", 1);
        int offs = 1;
        String str = "";
        AttributeSet a = SimpleAttributeSet.EMPTY;

        fixture.insertString(offs, str, a);

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
            junit.textui.TestRunner.run(LimitedSyntaxDocumentTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new LimitedSyntaxDocumentTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}