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
import ol.interaction.DoubleClickZoomTest;
import ol.interaction.DragAndDropTest;
import ol.interaction.DragBoxTest;
import ol.interaction.DragPanTest;
import ol.interaction.DragRotateAndZoomTest;
import ol.interaction.DragRotateTest;
import ol.interaction.DragZoomTest;
import ol.interaction.DrawTest;
import ol.interaction.ExtentTest;
import ol.interaction.KeyboardPanTest;
import ol.interaction.KeyboardZoomTest;
import ol.interaction.ModifyTest;
import ol.interaction.MouseWheelZoomTest;
import ol.interaction.PinchRotateTest;
import ol.interaction.PinchZoomTest;
import ol.interaction.SelectTest;
import ol.interaction.SnapTest;
import ol.interaction.TranslateTest;
import ol.layer.LayerGroupTest;
import ol.proj.ProjectionTest;
import ol.style.RegularShapeTest;

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
        suite.addTestSuite(SphereTest.class);
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
        suite.addTestSuite(DoubleClickZoomTest.class);
        suite.addTestSuite(DragAndDropTest.class);
        suite.addTestSuite(DragBoxTest.class);
        suite.addTestSuite(DragPanTest.class);
        suite.addTestSuite(DragRotateAndZoomTest.class);
        suite.addTestSuite(DragRotateTest.class);
        suite.addTestSuite(DragZoomTest.class);
        suite.addTestSuite(DrawTest.class);
        suite.addTestSuite(ExtentTest.class);
        suite.addTestSuite(KeyboardPanTest.class);
        suite.addTestSuite(KeyboardZoomTest.class);
        suite.addTestSuite(ModifyTest.class);
        suite.addTestSuite(MouseWheelZoomTest.class);
        suite.addTestSuite(PinchRotateTest.class);
        suite.addTestSuite(PinchZoomTest.class);
        suite.addTestSuite(SelectTest.class);
        suite.addTestSuite(SnapTest.class);
        suite.addTestSuite(TranslateTest.class);

        // layers
        suite.addTestSuite(LayerGroupTest.class);

        // projection
        suite.addTestSuite(ProjectionTest.class);

        // style
        suite.addTestSuite(RegularShapeTest.class);

        return suite;

    }

}

