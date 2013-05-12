package jcodecollector.data.settings;

import junit.framework.*;

/**
 * The class <code>ApplicationSettingsManagerTest</code> contains tests for the class <code>{@link ApplicationSettingsManager}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:21
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class ApplicationSettingsManagerTest extends TestCase {
    /**
     * Run the void readApplicationSettings() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testReadApplicationSettings_1()
        throws Exception {

        ApplicationSettingsManager.readApplicationSettings();

        // add additional test code here
    }

    /**
     * Run the void saveApplicationSettings() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSaveApplicationSettings_1()
        throws Exception {

        ApplicationSettingsManager.saveApplicationSettings();

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.SecurityException: Cannot write to files while generating test cases
        //       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
        //       at java.io.FileOutputStream.<init>(Unknown Source)
        //       at java.io.FileOutputStream.<init>(Unknown Source)
        //       at java.io.FileWriter.<init>(Unknown Source)
        //       at jcodecollector.data.settings.ApplicationSettingsManager.saveApplicationSettings(ApplicationSettingsManager.java:143)
        //       at jcodecollector.data.settings.ApplicationSettingsManager.saveApplicationSettings(ApplicationSettingsManager.java:35)
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
            junit.textui.TestRunner.run(ApplicationSettingsManagerTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new ApplicationSettingsManagerTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}