package jcodecollector.io;

import java.io.File;
import java.util.ArrayList;
import jcodecollector.common.bean.Snippet;
import junit.framework.*;

/**
 * The class <code>PackageManagerTest</code> contains tests for the class <code>{@link PackageManager}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:27
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class PackageManagerTest extends TestCase {
    /**
     * Run the boolean exportSnippets(File,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testExportSnippets_1()
        throws Exception {
        File file = new File("");
        String category = null;

        boolean result = PackageManager.exportSnippets(file, category);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.ExceptionInInitializerError
        //       at jcodecollector.io.PackageManager.exportSnippets(PackageManager.java:44)
        assertTrue(result);
    }

    /**
     * Run the boolean exportSnippets(File,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testExportSnippets_2()
        throws Exception {
        File file = new File("");
        String category = "";

        boolean result = PackageManager.exportSnippets(file, category);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.NoClassDefFoundError: Could not initialize class jcodecollector.data.DBMS
        //       at jcodecollector.io.PackageManager.exportSnippets(PackageManager.java:46)
        assertTrue(result);
    }

    /**
     * Run the boolean exportSnippets(File,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testExportSnippets_3()
        throws Exception {
        File file = new File("");
        String category = null;

        boolean result = PackageManager.exportSnippets(file, category);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.NoClassDefFoundError: Could not initialize class jcodecollector.data.DBMS
        //       at jcodecollector.io.PackageManager.exportSnippets(PackageManager.java:44)
        assertTrue(result);
    }

    /**
     * Run the ArrayList<Snippet> readPackage(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testReadPackage_1()
        throws Exception {
        File file = new File("");

        ArrayList<Snippet> result = PackageManager.readPackage(file);

        // add additional test code here
        assertEquals(null, result);
    }

    /**
     * Run the ArrayList<Snippet> readPackage(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testReadPackage_2()
        throws Exception {
        File file = new File("");

        ArrayList<Snippet> result = PackageManager.readPackage(file);

        // add additional test code here
        assertEquals(null, result);
    }

    /**
     * Run the ArrayList<Snippet> readPackage(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testReadPackage_3()
        throws Exception {
        File file = new File("");

        ArrayList<Snippet> result = PackageManager.readPackage(file);

        // add additional test code here
        assertEquals(null, result);
    }

    /**
     * Run the ArrayList<Snippet> readPackage(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testReadPackage_4()
        throws Exception {
        File file = new File("");

        ArrayList<Snippet> result = PackageManager.readPackage(file);

        // add additional test code here
        assertEquals(null, result);
    }

    /**
     * Run the ArrayList<Snippet> readPackage(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testReadPackage_5()
        throws Exception {
        File file = new File("");

        ArrayList<Snippet> result = PackageManager.readPackage(file);

        // add additional test code here
        assertEquals(null, result);
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
            junit.textui.TestRunner.run(PackageManagerTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new PackageManagerTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}