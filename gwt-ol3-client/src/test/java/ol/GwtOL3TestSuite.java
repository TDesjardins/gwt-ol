package ol;

import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.TestSuite;
import ol.control.FullScreenTest;
import ol.control.MousePositionTest;
import ol.control.RotateTest;
import ol.control.ScaleLineTest;
import ol.control.ZoomSliderTest;
import ol.control.ZoomToExtentTest;
import ol.format.GeoJSONTest;
import ol.geom.CircleTest;
import ol.geom.GeometryCollectionTest;
import ol.geom.PointTest;
import ol.interaction.DragAndDropTest;
import ol.interaction.KeyboardPanTest;
import ol.interaction.KeyboardZoomTest;
import ol.interaction.ModifyTest;
import ol.layer.LayerGroupTest;
import ol.proj.ProjectionTest;

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
        suite.addTestSuite(FeatureTest.class);
        suite.addTestSuite(GraticuleTest.class);
        suite.addTestSuite(MapTest.class);
        suite.addTestSuite(OverlayTest.class);
        suite.addTestSuite(ViewTest.class);

        // controls
        suite.addTestSuite(ol.control.AttributionTest.class);
        suite.addTestSuite(FullScreenTest.class);
        suite.addTestSuite(MousePositionTest.class);
        suite.addTestSuite(RotateTest.class);
        suite.addTestSuite(ScaleLineTest.class);
        suite.addTestSuite(ZoomSliderTest.class);
        suite.addTestSuite(ZoomToExtentTest.class);
        
        // formats
        suite.addTestSuite(GeoJSONTest.class);

        // geometries
        suite.addTestSuite(CircleTest.class);
        suite.addTestSuite(GeometryCollectionTest.class);
        suite.addTestSuite(PointTest.class);

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

