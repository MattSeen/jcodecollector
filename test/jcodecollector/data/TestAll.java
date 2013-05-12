package jcodecollector.data;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 12/05/13 15:21
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class TestAll {

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 12/05/13 15:21
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
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public static Test suite() {
        TestSuite suite;
    
        suite = new TestSuite("Tests in package jcodecollector.data");
        suite.addTestSuite(SearchResultsTest.class);
        suite.addTestSuite(SearchFilterTest.class);
        suite.addTestSuite(DBMSTest.class);
        suite.addTestSuite(ControllerTest.class);
        suite.addTest(jcodecollector.data.settings.TestAll.suite());
        return suite;
    }
}
