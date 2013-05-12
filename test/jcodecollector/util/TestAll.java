package jcodecollector.util;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 12/05/13 15:26
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class TestAll {

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    /**
     * Create a test suite that can run all of the test cases in this package
     * and all subpackages.
     *
     * @return the test suite that was created
     *
     * @generatedBy CodePro at 12/05/13 15:26
     */
    public static Test suite() {
        TestSuite suite;
    
        suite = new TestSuite("Tests in package jcodecollector.util");
        suite.addTestSuite(OSTest.class);
        suite.addTestSuite(ApplicationConstantsTest.class);
        suite.addTestSuite(UtilityTest.class);
        return suite;
    }
}
