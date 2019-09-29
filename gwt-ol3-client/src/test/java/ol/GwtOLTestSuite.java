/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol;

import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.TestSuite;
import ol.control.ControlTest;
import ol.control.FullScreenTest;
import ol.control.MousePositionTest;
import ol.control.OverviewMapTest;
import ol.control.RotateTest;
import ol.control.ScaleLineTest;
import ol.control.ZoomSliderTest;
import ol.control.ZoomToExtentTest;
import ol.events.condition.ConditionTest;
import ol.format.GeoJsonTest;
import ol.format.GpxTest;
import ol.format.KmlTest;
import ol.format.MvtTest;
import ol.format.OsmXmlTest;
import ol.format.WfsTest;
import ol.format.WktTest;
import ol.format.WmsGetFeatureInfoTest;
import ol.format.filter.FilterTest;
import ol.geom.CircleTest;
import ol.geom.GeometryCollectionTest;
import ol.geom.PointTest;
import ol.has.HasTest;
import ol.interaction.DoubleClickZoomTest;
import ol.interaction.DragAndDropTest;
import ol.interaction.DragBoxTest;
import ol.interaction.DragPanTest;
import ol.interaction.DragRotateAndZoomTest;
import ol.interaction.DragRotateTest;
import ol.interaction.DragZoomTest;
import ol.interaction.DrawTest;
import ol.interaction.ExtentTest;
import ol.interaction.InteractionTest;
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
import ol.source.BingMapsTest;
import ol.source.ClusterTest;
import ol.source.ImageArcGISRestTest;
import ol.source.ImageStaticTest;
import ol.source.RasterTest;
import ol.source.TileWmsTest;
import ol.source.VectorTileTest;
import ol.source.WmtsTest;
import ol.style.RegularShapeTest;
import ol.style.StrokeTest;
import ol.style.TextTest;
import ol.tilegrid.TileGridTest;
import ol.webgl.WebGLTest;

/**
 * Testsuite for GwtOL.
 *
 * @author Tino Desjardins
 *
 */
public class GwtOLTestSuite extends GWTTestSuite {

    public static TestSuite suite() {

        TestSuite suite = new TestSuite("Tests for GwtOL-Wrapper");

        suite.addTestSuite(ObjectTest.class);
        suite.addTestSuite(CollectionTest.class);
        suite.addTestSuite(CoordinateTest.class);
        suite.addTestSuite(ExtentTest.class);
        suite.addTestSuite(FeatureTest.class);
        suite.addTestSuite(GeolocationTest.class);
        suite.addTestSuite(GraticuleTest.class);
        suite.addTestSuite(MapTest.class);
        suite.addTestSuite(ObservableTest.class);
        suite.addTestSuite(OverlayTest.class);
        suite.addTestSuite(PixelTest.class);
        suite.addTestSuite(SizeTest.class);
        suite.addTestSuite(SphereTest.class);
        suite.addTestSuite(TileCoordTest.class);
        suite.addTestSuite(ViewTest.class);

        // color
        suite.addTestSuite(ol.color.ColorTest.class);

        // controls
        suite.addTestSuite(ol.control.AttributionTest.class);
        suite.addTestSuite(ControlTest.class);
        suite.addTestSuite(FullScreenTest.class);
        suite.addTestSuite(MousePositionTest.class);
        suite.addTestSuite(OverviewMapTest.class);
        suite.addTestSuite(RotateTest.class);
        suite.addTestSuite(ScaleLineTest.class);
        suite.addTestSuite(ZoomSliderTest.class);
        suite.addTestSuite(ZoomToExtentTest.class);

        // events
        suite.addTestSuite(ConditionTest.class);

        // formats
        suite.addTestSuite(FilterTest.class);
        suite.addTestSuite(GeoJsonTest.class);
        suite.addTestSuite(GpxTest.class);
        suite.addTestSuite(KmlTest.class);
        suite.addTestSuite(MvtTest.class);
        suite.addTestSuite(OsmXmlTest.class);
        suite.addTestSuite(WfsTest.class);
        suite.addTestSuite(WktTest.class);
        suite.addTestSuite(WmsGetFeatureInfoTest.class);

        // geometries
        suite.addTestSuite(CircleTest.class);
        suite.addTestSuite(GeometryCollectionTest.class);
        suite.addTestSuite(PointTest.class);

        // has
        suite.addTestSuite(HasTest.class);

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
        suite.addTestSuite(InteractionTest.class);
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
        suite.addTestSuite(ol.layer.ImageTest.class);
        suite.addTestSuite(LayerGroupTest.class);
        suite.addTestSuite(ol.layer.TileTest.class);
        suite.addTestSuite(ol.layer.VectorTest.class);
        suite.addTestSuite(ol.layer.VectorTileTest.class);

        // source
        suite.addTestSuite(BingMapsTest.class);
        suite.addTestSuite(ClusterTest.class);
        suite.addTestSuite(ImageArcGISRestTest.class);
        suite.addTestSuite(ImageStaticTest.class);
        suite.addTestSuite(RasterTest.class);
        suite.addTestSuite(TileWmsTest.class);
        suite.addTestSuite(VectorTileTest.class);
        suite.addTestSuite(WmtsTest.class);

        // projection
        suite.addTestSuite(ProjectionTest.class);

        // style
        suite.addTestSuite(ol.style.CircleTest.class);
        suite.addTestSuite(ol.style.FillTest.class);
        suite.addTestSuite(RegularShapeTest.class);
        suite.addTestSuite(StrokeTest.class);
        suite.addTestSuite(TextTest.class);

        // tilegrid
        suite.addTestSuite(TileGridTest.class);

        // utilities
        suite.addTestSuite(OLUtilTest.class);

        // WebGL
        suite.addTestSuite(WebGLTest.class);

        return suite;

    }

}

