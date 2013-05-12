package jcodecollector.document;

import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import junit.framework.*;

/**
 * The class <code>LimitedPlainDocumentTest</code> contains tests for the class <code>{@link LimitedPlainDocument}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:26
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class LimitedPlainDocumentTest extends TestCase {
    /**
     * Run the LimitedPlainDocument(int) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public void testLimitedPlainDocument_1()
        throws Exception {
        int maxSize = 1;

        LimitedPlainDocument result = new LimitedPlainDocument(maxSize);

        // add additional test code here
        assertNotNull(result);
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
        LimitedPlainDocument fixture = new LimitedPlainDocument(1);
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
        LimitedPlainDocument fixture = new LimitedPlainDocument(1);
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
        LimitedPlainDocument fixture = new LimitedPlainDocument(1);
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
        LimitedPlainDocument fixture = new LimitedPlainDocument(1);
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
            junit.textui.TestRunner.run(LimitedPlainDocumentTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new LimitedPlainDocumentTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}