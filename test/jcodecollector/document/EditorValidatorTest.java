package jcodecollector.document;

import javax.swing.event.DocumentEvent;
import javax.swing.text.JTextComponent;
import junit.framework.*;

/**
 * The class <code>EditorValidatorTest</code> contains tests for the class <code>{@link EditorValidator}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:27
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class EditorValidatorTest extends TestCase {
    /**
     * Run the EditorValidator(JTextComponent[],boolean[]) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testEditorValidator_1()
        throws Exception {
        JTextComponent[] components = new JTextComponent[] {};
        boolean[] optional = new boolean[] {};

        EditorValidator result = new EditorValidator(components, optional);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the EditorValidator(JTextComponent[],boolean[]) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testEditorValidator_2()
        throws Exception {
        JTextComponent[] components = new JTextComponent[] {};
        boolean[] optional = new boolean[] {};

        EditorValidator result = new EditorValidator(components, optional);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the void changedUpdate(DocumentEvent) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testChangedUpdate_1()
        throws Exception {
        EditorValidator fixture = new EditorValidator(new JTextComponent[] {}, new boolean[] {});
        DocumentEvent e = null;

        fixture.changedUpdate(e);

        // add additional test code here
    }

    /**
     * Run the void insertUpdate(DocumentEvent) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testInsertUpdate_1()
        throws Exception {
        EditorValidator fixture = new EditorValidator(new JTextComponent[] {}, new boolean[] {});
        DocumentEvent e = null;

        fixture.insertUpdate(e);

        // add additional test code here
    }

    /**
     * Run the void removeUpdate(DocumentEvent) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testRemoveUpdate_1()
        throws Exception {
        EditorValidator fixture = new EditorValidator(new JTextComponent[] {}, new boolean[] {});
        DocumentEvent e = null;

        fixture.removeUpdate(e);

        // add additional test code here
    }

    /**
     * Run the void start() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testStart_1()
        throws Exception {
        EditorValidator fixture = new EditorValidator(new JTextComponent[] {}, new boolean[] {});

        fixture.start();

        // add additional test code here
    }

    /**
     * Run the void stop() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testStop_1()
        throws Exception {
        EditorValidator fixture = new EditorValidator(new JTextComponent[] {}, new boolean[] {});

        fixture.stop();

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
     * @generatedBy CodePro at 12/05/13 15:27
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
     * @generatedBy CodePro at 12/05/13 15:27
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
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            // Run all of the tests
            junit.textui.TestRunner.run(EditorValidatorTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new EditorValidatorTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}