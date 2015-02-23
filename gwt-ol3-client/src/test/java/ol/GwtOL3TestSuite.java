package ol;

import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.TestSuite;

/**
 * Testsuite for GwtOL3.
 * 
 * @author Tino Desjardins
 *
 */
public class GwtOL3TestSuite extends GWTTestSuite {

    public static TestSuite suite() {
        
        TestSuite suite = new TestSuite("Tests for GwtOL3-Wrapper");
        
        suite.addTestSuite(AttributionTest.class);
        suite.addTestSuite(ol.control.AttributionTest.class);
        suite.addTestSuite(MapTest.class);
        suite.addTestSuite(FeatureOverlayTest.class);
        suite.addTestSuite(ViewTest.class);
        
        return suite;
        
    }

}

