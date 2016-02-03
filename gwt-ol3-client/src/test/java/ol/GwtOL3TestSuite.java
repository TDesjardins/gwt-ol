package ol;

import com.google.gwt.junit.tools.GWTTestSuite;

import ol.control.FullScreenTest;
import ol.control.MousePositionTest;
import ol.control.RotateTest;
import ol.control.ScaleLineTest;
import ol.control.ZoomSliderTest;
import ol.control.ZoomToExtentTest;
import ol.geom.GeometryCollectionTest;
import ol.interaction.DragAndDropTest;
import ol.interaction.KeyboardPanTest;
import ol.interaction.KeyboardZoomTest;
import ol.interaction.ModifyTest;
import ol.layer.LayerGroupTest;
import ol.proj.ProjectionTest;
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
        suite.addTestSuite(CollectionTest.class);
        suite.addTestSuite(GraticuleTest.class);
        suite.addTestSuite(MapTest.class);
        suite.addTestSuite(ViewTest.class);
        
        // controls
        suite.addTestSuite(ol.control.AttributionTest.class);
        suite.addTestSuite(FullScreenTest.class);
        suite.addTestSuite(MousePositionTest.class);
        suite.addTestSuite(RotateTest.class);
        suite.addTestSuite(ScaleLineTest.class);
        suite.addTestSuite(ZoomSliderTest.class);
        suite.addTestSuite(ZoomToExtentTest.class);
        
        // geometries
        suite.addTestSuite(GeometryCollectionTest.class);
        
        // interactions
        suite.addTestSuite(DragAndDropTest.class);
        suite.addTestSuite(KeyboardPanTest.class);
        suite.addTestSuite(KeyboardZoomTest.class);
        suite.addTestSuite(ModifyTest.class);
        
        // layers
        suite.addTestSuite(LayerGroupTest.class);
        
        // projection
        suite.addTestSuite(ProjectionTest.class);
        
        return suite;
        
    }

}

