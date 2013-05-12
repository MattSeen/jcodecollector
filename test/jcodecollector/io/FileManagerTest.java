package jcodecollector.io;

import java.io.File;
import junit.framework.*;

/**
 * The class <code>FileManagerTest</code> contains tests for the class <code>{@link FileManager}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:27
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class FileManagerTest extends TestCase {
    /**
     * Run the boolean deleteDirectory(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testDeleteDirectory_1()
        throws Exception {
        File path = new File("");

        boolean result = FileManager.deleteDirectory(path);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.SecurityException: Cannot delete files while generating test cases
        //       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkDelete(CodeProJUnitSecurityManager.java:62)
        //       at java.io.File.delete(Unknown Source)
        //       at jcodecollector.io.FileManager.deleteDirectory(FileManager.java:38)
        assertTrue(result);
    }

    /**
     * Run the boolean deleteDirectory(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testDeleteDirectory_2()
        throws Exception {
        File path = new File("");

        boolean result = FileManager.deleteDirectory(path);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.SecurityException: Cannot delete files while generating test cases
        //       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkDelete(CodeProJUnitSecurityManager.java:62)
        //       at java.io.File.delete(Unknown Source)
        //       at jcodecollector.io.FileManager.deleteDirectory(FileManager.java:38)
        assertTrue(result);
    }

    /**
     * Run the boolean deleteDirectory(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testDeleteDirectory_3()
        throws Exception {
        File path = new File("");

        boolean result = FileManager.deleteDirectory(path);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.SecurityException: Cannot delete files while generating test cases
        //       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkDelete(CodeProJUnitSecurityManager.java:62)
        //       at java.io.File.delete(Unknown Source)
        //       at jcodecollector.io.FileManager.deleteDirectory(FileManager.java:38)
        assertTrue(result);
    }

    /**
     * Run the boolean deleteDirectory(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testDeleteDirectory_4()
        throws Exception {
        File path = new File("");

        boolean result = FileManager.deleteDirectory(path);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.SecurityException: Cannot delete files while generating test cases
        //       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkDelete(CodeProJUnitSecurityManager.java:62)
        //       at java.io.File.delete(Unknown Source)
        //       at jcodecollector.io.FileManager.deleteDirectory(FileManager.java:38)
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
            junit.textui.TestRunner.run(FileManagerTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new FileManagerTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}