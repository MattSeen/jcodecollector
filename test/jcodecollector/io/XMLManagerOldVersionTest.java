package jcodecollector.io;

import java.io.File;
import java.util.ArrayList;
import org.jdom2.input.JDOMParseException;
import jcodecollector.common.bean.Snippet;
import junit.framework.*;

/**
 * The class <code>XMLManagerOldVersionTest</code> contains tests for the class <code>{@link XMLManagerOldVersion}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:27
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class XMLManagerOldVersionTest extends TestCase {
    /**
     * Run the boolean createPackage(File,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testCreatePackage_1()
        throws Exception {
        File file = new File("");
        String name = "";

        boolean result = XMLManagerOldVersion.createPackage(file, name);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.ExceptionInInitializerError
        //       at jcodecollector.io.XMLManagerOldVersion.createPackage(XMLManagerOldVersion.java:43)
        assertTrue(result);
    }

    /**
     * Run the boolean createPackage(File,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testCreatePackage_2()
        throws Exception {
        File file = new File("");
        String name = "";

        boolean result = XMLManagerOldVersion.createPackage(file, name);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.NoClassDefFoundError: Could not initialize class jcodecollector.data.DBMS
        //       at jcodecollector.io.XMLManagerOldVersion.createPackage(XMLManagerOldVersion.java:43)
        assertTrue(result);
    }

    /**
     * Run the boolean createPackage(File,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testCreatePackage_3()
        throws Exception {
        File file = new File("");
        String name = "";

        boolean result = XMLManagerOldVersion.createPackage(file, name);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.NoClassDefFoundError: Could not initialize class jcodecollector.data.DBMS
        //       at jcodecollector.io.XMLManagerOldVersion.createPackage(XMLManagerOldVersion.java:43)
        assertTrue(result);
    }

    /**
     * Run the void importFromXML(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testImportFromXML_1()
        throws Exception {
        try {
            File file = new File("");

            XMLManagerOldVersion.importFromXML(file);

            // add additional test code here
            fail("The exception org.jdom2.input.JDOMParseException should have been thrown.");
        } catch (org.jdom2.input.JDOMParseException exception) {
            // The test succeeded by throwing the expected exception
        }
    }

    /**
     * Run the void importFromXML(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testImportFromXML_2()
        throws Exception {
        try {
            File file = new File("");

            XMLManagerOldVersion.importFromXML(file);

            // add additional test code here
            fail("The exception org.jdom2.input.JDOMParseException should have been thrown.");
        } catch (org.jdom2.input.JDOMParseException exception) {
            // The test succeeded by throwing the expected exception
        }
    }

    /**
     * Run the void importFromXML(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testImportFromXML_3()
        throws Exception {
        try {
            File file = new File("");

            XMLManagerOldVersion.importFromXML(file);

            // add additional test code here
            fail("The exception org.jdom2.input.JDOMParseException should have been thrown.");
        } catch (org.jdom2.input.JDOMParseException exception) {
            // The test succeeded by throwing the expected exception
        }
    }

    /**
     * Run the void importFromXML(File) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:27
     */
    public void testImportFromXML_4()
        throws Exception {
        try {
            File file = new File("");

            XMLManagerOldVersion.importFromXML(file);

            // add additional test code here
            fail("The exception org.jdom2.input.JDOMParseException should have been thrown.");
        } catch (org.jdom2.input.JDOMParseException exception) {
            // The test succeeded by throwing the expected exception
        }
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

        ArrayList<Snippet> result = XMLManagerOldVersion.readPackage(file);

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

        ArrayList<Snippet> result = XMLManagerOldVersion.readPackage(file);

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

        ArrayList<Snippet> result = XMLManagerOldVersion.readPackage(file);

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

        ArrayList<Snippet> result = XMLManagerOldVersion.readPackage(file);

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

        ArrayList<Snippet> result = XMLManagerOldVersion.readPackage(file);

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
            junit.textui.TestRunner.run(XMLManagerOldVersionTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new XMLManagerOldVersionTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}