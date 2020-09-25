/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import elemental2.core.JsObject;
import ol.color.Color;
import ol.control.Attribution;
import ol.control.Control;
import ol.control.DefaultControlsOptions;
import ol.control.FullScreen;
import ol.control.FullScreenOptions;
import ol.control.MousePosition;
import ol.control.MousePositionOptions;
import ol.control.OverviewMap;
import ol.control.OverviewMapOptions;
import ol.control.Rotate;
import ol.control.RotateOptions;
import ol.control.ScaleLine;
import ol.control.ScaleLineOptions;
import ol.control.Zoom;
import ol.control.ZoomSlider;
import ol.control.ZoomToExtent;
import ol.control.ZoomToExtentOptions;
import ol.format.GeoJson;
import ol.format.GeoJsonOptions;
import ol.geom.Circle;
import ol.geom.Geometry;
import ol.geom.GeometryCollection;
import ol.geom.LineString;
import ol.geom.LinearRing;
import ol.geom.MultiLineString;
import ol.geom.MultiPoint;
import ol.geom.MultiPolygon;
import ol.geom.Point;
import ol.geom.Polygon;
import ol.interaction.DefaultInteractionsOptions;
import ol.interaction.DragAndDrop;
import ol.interaction.Draw;
import ol.interaction.DrawOptions;
import ol.interaction.Interaction;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.interaction.Modify;
import ol.interaction.ModifyOptions;
import ol.interaction.Select;
import ol.interaction.SelectOptions;
import ol.interaction.Snap;
import ol.interaction.SnapOptions;
import ol.layer.Graticule;
import ol.layer.Image;
import ol.layer.ImageLayerOptions;
import ol.layer.LayerGroupOptions;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.TileLayerOptions;
import ol.layer.VectorLayerOptions;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.ImageMapGuide;
import ol.source.ImageMapGuideOptions;
import ol.source.ImageStatic;
import ol.source.ImageStaticOptions;
import ol.source.ImageWms;
import ol.source.ImageWmsOptions;
import ol.source.Osm;
import ol.source.RasterOptions;
import ol.source.Source;
import ol.source.Stamen;
import ol.source.StamenOptions;
import ol.source.TileDebug;
import ol.source.TileDebugOptions;
import ol.source.TileWms;
import ol.source.TileWmsOptions;
import ol.source.VectorOptions;
import ol.source.Xyz;
import ol.source.XyzOptions;
import ol.style.CircleOptions;
import ol.style.Fill;
import ol.style.FillOptions;
import ol.style.RegularShape;
import ol.style.RegularShapeOptions;
import ol.style.Stroke;
import ol.style.StrokeOptions;
import ol.style.Style;
import ol.style.StyleOptions;
import ol.style.Text;
import ol.style.TextOptions;
import ol.tilegrid.TileGrid;
import ol.tilegrid.TileGridOptions;
import ol.tilegrid.XyzTileGridOptions;

/**
 * Factory to create GWT-OL3 instances. Originally this factory was necessary
 * to create JavaScript instances via JSNI code. Now you can use constructors
 * of the specific JsTypes for this purpose.
 *
 * @author Tino Desjardins
 */
@ParametersAreNonnullByDefault
public final class OLFactory {

    // prevent instantiating this class
    @Deprecated
    private OLFactory() {
    }

    /**
     * Creates an {@link ol.control.Attribution}.
     *
     * @return {@link ol.control.Attribution}
     */
    public static Attribution createAttributionControl() {
        return new Attribution();
    };

    /**
     * Creates an {@link ol.control.Attribution}.
     * @param options
     *            options
     *
     * @return {@link ol.control.Attribution}
     */
    public static ol.control.Attribution createAttributionControl(ol.control.AttributionOptions options) {
        return new Attribution(options);
    };

    /**
     * Creates a {@link Circle}.
     *
     * @param center
     *            center
     * @param radius
     *            radius
     * @return {@link Circle}
     */
    public static Circle createCircle(Coordinate center, double radius) {
        return new Circle(center, radius);
    };

    /**
     * Creates a {@link ol.style.Circle} style.
     *
     * @param circleOptions
     *            {@link CircleOptions}
     * @return {@link ol.style.Circle}
     */
    public static ol.style.Circle createCircleStyle(CircleOptions circleOptions) {
        return new ol.style.Circle(circleOptions);
    };

    /**
     * Creates a {@link ol.style.Circle} style.
     *
     * @param fill
     *            {@link Fill}
     * @param stroke
     *            {@link Stroke}
     * @param radius
     *            radius of the circle
     * @return {@link ol.style.Circle}
     */
    public static ol.style.Circle createCircleStyle(Fill fill, Stroke stroke, double radius) {
        CircleOptions circleOptions = createOptions();
        circleOptions.setFill(fill);
        circleOptions.setStroke(stroke);
        circleOptions.setRadius(radius);
        return createCircleStyle(circleOptions);
    }

    /**
     * Creates a {@link Collection}.
     *
     * @return {@link Collection}
     */
    public static <T> Collection<T> createCollection() {
        return new Collection<T>();
    };

    /**
     * Creates a {@link Color} from the given values.
     *
     * @param red
     *            red (0-255)
     * @param green
     *            green (0-255)
     * @param blue
     *            blue (0-255)
     * @param alpha
     *            alpha (0-1), 1 is solid
     * @return {@link Color}
     */
    public static Color createColor(int red, int green, int blue, double alpha) {
        return new Color(red, green, blue, alpha);
    };

    /**
     * Creates a {@link Color} from the given String.
     *
     * @param colorString
     *            color in rgb(r,g,b) or rgba(r,g,b,a) format, or in hex #rrggbb
     *            or #rgb format
     * @return {@link Color}
     */
    public static Color createColor(String colorString) {
        return Color.getColorFromString(colorString);
    };

    /**
     * Creates an instance.
     *
     * @param x
     *            X-coordinate (longitude)
     * @param y
     *            Y-coordinate (latitude)
     * @return {@link Coordinate}
     */
    public static Coordinate createCoordinate(double x, double y) {
        return new Coordinate(x, y);
    };

    /**
     * Creates an instance.
     *
     * @param x
     *            X-coordinate (longitude)
     * @param y
     *            Y-coordinate (latitude)
     * @param z
     *            Z-coordinate
     * @return {@link Coordinate}
     */
    public static Coordinate createCoordinate(double x, double y, double z) {
        return new Coordinate(x, y, z);
    };

    /**
     * Creates an instance.
     *
     * @param coords
     *            coordinate array
     * @return {@link Coordinate}
     */
    public static Coordinate createCoordinate(double[] coords) {
        if(coords.length > 2) {
            return createCoordinate(coords[0], coords[1], coords[2]);
        } else {
            return createCoordinate(coords[0], coords[1]);
        }
    }

    /**
     * Create the default map controls: {@link ol.control.Zoom},
     * {@link ol.control.Rotate}, {@link ol.control.Attribution}
     *
     * @param options
     *            options
     * @return default map controls
     */
    public static Collection<Control> createDefaultControls(@Nullable DefaultControlsOptions options) {
        return Control.defaults(options);
    };

    /** Interactions **/

    /**
     *  Creates a {@link DragAndDrop}.
     * @return {@link DragAndDrop}
     */
    public static DragAndDrop createDragAndDrop() {
        return new DragAndDrop();
    };

    /**
     * Creates a {@link Draw}.
     *
     * @param options
     *            {@link DrawOptions}
     *
     * @return {@link Draw}
     */
    public static Draw createDraw(DrawOptions options) {
        return new Draw(options);
    };

    /**
     * Creates an {@link Extent}.
     *
     * @param minX x min
     * @param minY y min
     * @param maxX x max
     * @param maxY y max
     * @return {@link Extent}
     */
    public static Extent createExtent(double minX, double minY, double maxX, double maxY) {
        return new Extent(minX, minY, maxX, maxY);
    };

    /**
     * Creates a {@link Feature}.
     *
     * @return {@link Feature}
     */
    public static Feature createFeature() {
        return new Feature();
    };

    /**
     * Creates a {@link Feature}.
     *
     * @param options
     *            {@link FeatureOptions}
     *
     * @return {@link Feature}
     */
    public static Feature createFeature(FeatureOptions options) {
        return new Feature(options);
    };

    /**
     * Creates a {@link Feature}.
     *
     * @param geom
     *            {@link Geometry}
     *
     * @return {@link Feature}
     */
    public static Feature createFeature(Geometry geom) {
        return new ol.Feature(geom);
    };

    /**
     * Creates a {@link Feature}.
     *
     * @param geom
     *            {@link Geometry}
     * @param style
     *            {@link Style}
     *
     * @return {@link Feature}
     */
    public static Feature createFeature(Geometry geom, Style style) {
        Feature feature = createFeature(geom);
        feature.setStyle(style);
        return feature;
    }

    /**
     * Creates a new {@link Fill} style.
     *
     * @param color
     *            fill color
     * @return {@link Fill}
     */
    public static Fill createFill(Color color) {
        FillOptions fillOptions = createOptions();
        fillOptions.setColor(color);
        return createFill(fillOptions);
    }

    /**
     * Creates a new {@link Fill} style.
     *
     * @param fillOptions
     *            {@link FillOptions}
     * @return {@link Fill}
     */
    public static Fill createFill(FillOptions fillOptions) {
        return new Fill(fillOptions);
    };

    /** Controls **/

    /**
     * Creates a {@link FullScreen} control.
     * @return {@link FullScreen}
     */
    public static FullScreen createFullScreen() {
        return new FullScreen();
    };

    /**
     * Creates a {@link FullScreen} control.
     * @param options
     *            options
     * @return {@link FullScreen}
     */
    public static FullScreen createFullScreen(FullScreenOptions options) {
        return new FullScreen(options);
    };

    /**
     * Creates a {@link GeometryCollection}.
     * @param geoms An array of {@link ol.geom.Geometry} objects. (optional)
     *
     * @return {@link GeometryCollection}
     */
    public static GeometryCollection createGeometryCollection(@Nullable Geometry[] geoms) {
        return new GeometryCollection(geoms);
    };

    /**
     * Creates a {@link GeoJson}.
     *
     * @param options
     *            {@link GeoJsonOptions}
     *
     * @return {@link GeoJson}
     */
    public static GeoJson createGeoJSON(GeoJsonOptions options) {
        return new GeoJson(options);
    };

    /**
     * Creates a {@link GeoJson}.
       *
     * @return {@link GeoJson}
     */
    public static GeoJson createGeoJSON() {
        return new GeoJson();
    };

    /**
     * Creates an {@link Graticule}.
     *
     * @return {@link Graticule}
     */
    public static Graticule createGraticule() {
        return new Graticule();
    };

    /** Layers **/

    public static Image createImageLayer(LayerOptions layerOptions) {
        return new Image(layerOptions);
    };

    /** Sources **/

    /**
     * Creates a MapGuide image.
     *
     * @param imageMapGuideOptions
     * @return {@link ImageMapGuide}
     * **/
    public static ImageMapGuide createImageMapGuideSource(ImageMapGuideOptions imageMapGuideOptions) {
        return new ImageMapGuide(imageMapGuideOptions);
    };

    public static ImageStatic createImageStaticSource(ImageStaticOptions imageStaticOptions) {
        return new ImageStatic(imageStaticOptions);
    };

    public static ImageWms createImageWMSSource(ImageWmsOptions imageWMSOptions) {
        return new ImageWms(imageWMSOptions);
    };

    public static KeyboardPan createKeyboardPan() {
        return new KeyboardPan();
    };

    public static KeyboardZoom createKeyboardZoom() {
        return new KeyboardZoom();
    };

    /**
     * Creates a {@link ol.layer.Group}.
     *
     * @param options
     *            {@link ol.layer.LayerGroupOptions}
     * @return {@link ol.layer.Group}
     */
    public static ol.layer.Group createLayerGroup(LayerGroupOptions options) {
        return new ol.layer.Group(options);
    };

    /**
     * Creates {@link LayerOptions} using the given {@link Source}.
     *
     * @param source
     *            {@link Source}
     * @return {@link LayerOptions}
     */
    public static LayerOptions createLayerOptionsWithSource(Source source) {
        LayerOptions options = createOptions();
        options.setSource(source);
        return options;
    }

    /**
     * Creates {@link VectorLayerOptions} using the given
     * {@link ol.source.Vector}.
     *
     * @param source
     *            {@link ol.source.Vector}
     * @return {@link VectorLayerOptions}
     */
    public static VectorLayerOptions createLayerOptionsWithSource(ol.source.Vector source) {
        VectorLayerOptions options = createOptions();
        options.setSource(source);
        return options;
    }

    /**
     * Creates {@link TileLayerOptions} using the given {@link Tile}.
     *
     * @param source
     *            {@link Tile}
     * @return {@link TileLayerOptions}
     */
    public static TileLayerOptions createLayerOptionsWithSource(ol.source.Tile source) {
        TileLayerOptions options = createOptions();
        options.setSource(source);
        return options;
    }

    /**
     * Creates {@link ImageLayerOptions} using the given {@link Image}.
     *
     * @param source
     *            {@link Image}
     * @return {@link ImageLayerOptions}
     */
    public static ImageLayerOptions createLayerOptionsWithSource(ol.source.Image source) {
        ImageLayerOptions options = createOptions();
        options.setSource(source);
        return options;
    }

    /**
     * Creates a {@link LinearRing}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link LinearRing}
     */
    public static LinearRing createLinearRing(Coordinate[] coordinates) {
        return new LinearRing(coordinates);
    };

    /**
     * Creates a {@link LinearRing}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link LinearRing}
     */
    public static LinearRing createLinearRing(@Nullable Coordinate[] coordinates,
        @Nullable String geometryLayout) {
        return new LinearRing(coordinates, geometryLayout);
    };

    /**
     * Creates a {@link LineString}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link LineString}
     */
    public static LineString createLineString(Coordinate[] coordinates) {
        return new LineString(coordinates);
    };

    /**
     * Creates a {@link LineString}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link LineString}
     */
    public static LineString createLineString(@Nullable Coordinate[] coordinates,
        @Nullable String geometryLayout) {
        return new LineString(coordinates, geometryLayout);
    };

    /**
     * Creates a {@link Map}.
     *
     * @param mapOptions
     *            {@link MapOptions}
     * @return {@link Map}
     */
    public static Map createMap(MapOptions mapOptions) {
        return new Map(mapOptions);
    };

    /**
     *
     * Creates a {@link ol.interaction.Modify}
     *
     * @param modifyOptions {@link ol.interaction.ModifyOptions}
     * @return {@link ol.interaction.Modify}
     */
    public static Modify createModify(ModifyOptions modifyOptions) {
        return new Modify(modifyOptions);
    };

    /**
     * Creates a {@link MousePosition} control.
     * @return {@link MousePosition}
     */
    public static MousePosition createMousePosition() {
        return new MousePosition();
    };

    /**
     * Creates a {@link MousePosition} control.
     * @param options
     *            options
     * @return {@link MousePosition}
     */
    public static MousePosition createMousePosition(MousePositionOptions options) {
        return new MousePosition(options);
    };

    /**
     * Creates a {@link MultiLineString}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiLineString}
     */
    public static MultiLineString createMultiLineString(Coordinate[] coordinates) {
        return new MultiLineString(coordinates);
    };

    /**
     * Creates a {@link MultiLineString}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link MultiLineString}
     */
    public static MultiLineString createMultiLineString(@Nullable Coordinate[] coordinates,
        @Nullable String geometryLayout) {
        return new MultiLineString(coordinates, geometryLayout);
    };

    /**
     * Creates a {@link MultiPoint}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiPoint}
     */
    public static MultiPoint createMultiPoint(Coordinate[] coordinates) {
        return new MultiPoint(coordinates);
    };

    /**
     * Creates a {@link MultiPoint}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link MultiPoint}
     */
    public static MultiPoint createMultiPoint(@Nullable Coordinate[] coordinates,
        @Nullable String geometryLayout) {
        return new MultiPoint(coordinates, geometryLayout);
    };

    /**
     * Creates a {@link MultiPolygon}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiPolygon}
     */
    public static MultiPolygon createMultiPolygon(Coordinate[] coordinates) {
        return new MultiPolygon(coordinates);
    };

    /**
     * Creates a {@link MultiPolygon}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link MultiPolygon}
     */
    public static MultiPolygon createMultiPolygon(@Nullable Coordinate[] coordinates,
        @Nullable String geometryLayout) {
        return new MultiPolygon(coordinates, geometryLayout);
    };

    /**
     * Create generic options.
     *
     * @return options instance
     */
    @SuppressWarnings("unchecked")
    public static <T extends Options> T createOptions() {
        return (T)new JsObject();
    };

    public static Osm createOsm(XyzOptions osmOptions) {
        return new Osm(osmOptions);
    };

    /**
     * Creates an {@link Overlay}.
     *
     * @param options
     *            {@link OverlayOptions}
     * @return {@link Overlay}
     */
    public static Overlay createOverlay(OverlayOptions options) {
        return new Overlay(options);
    };

    /**
     * Creates an {@link OverviewMap} control.
     * @return {@link OverviewMap}
     */
    public static OverviewMap createOverviewMap() {
        return new OverviewMap();
    };

    /**
     * Creates an {@link OverviewMap} control.
     * @param options
     *            options
     * @return {@link OverviewMap}
     */
    public static OverviewMap createOverviewMap(OverviewMapOptions options) {
        return new OverviewMap(options);
    };

    /**
     * Creates an instance.
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @return {@link Pixel}
     */
    public static Pixel createPixel(int x, int y) {
        return new Pixel(x, y);
    };

    /**
     * Creates an instance.
     *
     * @param coordinates
     *            coordinates
     * @return {@link Point}
     */
    public static Point createPoint(Coordinate coordinates) {
        return new Point(coordinates);
    };

    /**
     * Creates an instance.
     *
     * @param coordinates coordinates
     * @param geometryLayout geometry layout
     * @return {@link Point}
     */
    public static Point createPoint(@Nullable Coordinate coordinates, @Nullable String geometryLayout) {
        return new Point(coordinates, geometryLayout);
    };

    /**
     * Creates an instance.
     *
     * @param x X-coordinate (longitude)
     * @param y Y-coordinate (latitude)
     * @return {@link Coordinate}
     */
    public static Point createPoint(double x, double y) {
        return createPoint(createCoordinate(x, y), OLUtil.getGeometryLayout(2));
    }

    /**
     * Creates an instance.
     *
     * @param x
     *            X-coordinate (longitude)
     * @param y
     *            Y-coordinate (latitude)
     * @param z
     *            Z-coordinate
     * @return {@link Coordinate}
     */
    public static Point createPoint(double x, double y, double z) {
        return createPoint(createCoordinate(x, y, z), OLUtil.getGeometryLayout(3));
    }

    /**
     * Creates a {@link Polygon}.
     *
     * @return {@link Polygon}
     */
    public static Polygon createPolygon() {
        return createPolygon(new Coordinate[0][0]);
    };

    /**
     * Creates a {@link Polygon}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link Polygon}
     */
    public static Polygon createPolygon(Coordinate[][] coordinates) {
        return new Polygon(coordinates);
    };

    /**
     * Creates a {@link Polygon}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link Polygon}
     */
    public static Polygon createPolygon(@Nullable Coordinate[][] coordinates, @Nullable String geometryLayout) {
        return new Polygon(coordinates, geometryLayout);
    };

    /** Projection **/

    public static Projection createProjection(ProjectionOptions projectionOptions) {
        return new Projection(projectionOptions);
    };

    /**
     * Creates {@link RasterOptions}.
     *
     * @return
     */
    public static RasterOptions createRasterOptions() {
        RasterOptions options = createOptions();
        options.disableWorkerSupport();
        return options;
    }

    /**
     * Creates {@link RasterOptions} with the given source.
     *
     * @param source
     * @return
     */
    public static RasterOptions createRasterOptionsWithSource(Source source) {
        RasterOptions options = createRasterOptions();
        options.setSource(source);
        return options;
    }

    /**
     * Create a {@link Rotate} control.
     * @return {@link Rotate}
     */
    public static Rotate createRotate() {
        return new Rotate();
    };

    /**
     * Create a {@link Rotate} control.
     * @param options
     *            options
     * @return {@link Rotate}
     */
    public static Rotate createRotate(RotateOptions options) {
        return new Rotate(options);
    };

    /**
     * Creates a {@link ScaleLine}.
     *
     * @return {@link ScaleLine}
     */
    public static ScaleLine createScaleLine() {
        return new ScaleLine();
    };

    /**
     * Creates a {@link ScaleLine}.
     * @param options
     *            options
     *
     * @return {@link ScaleLine}
     */
    public static ScaleLine createScaleLine(ScaleLineOptions options) {
        return new ScaleLine(options);
    };

    /**
     * Creates a {@link Size}.
     *
     * @param width
     *            width
     * @param height
     *            height
     * @return {@link Size}
     */
    public static Size createSize(int width, int height) {
        return new Size(width, height);
    };

    /**
     * Creates a {@link TileCoord}.
     *
     * @param x
     *            x
     * @param y
     *            y
     * @param z
     *            z
     * @return {@link TileCoord}
     */
    public static TileCoord createTileCoord(double x, double y, double z) {
        return new TileCoord(z, x, y);
    };

    /** Common **/

    public static Stamen createStamenSource(StamenOptions stamenOptions) {
        return new Stamen(stamenOptions);
    };

    /**
     * Creates a new {@link Stroke} style.
     *
     * @param color
     *            stroke color
     * @param width
     *            stroke width
     * @return {@link Stroke}
     */
    public static Stroke createStroke(Color color, int width) {
        StrokeOptions strokeOptions = createOptions();
        strokeOptions.setColor(color);
        strokeOptions.setWidth(width);
        return createStroke(strokeOptions);
    }

    /**
     * Creates a new {@link Stroke} style.
     *
     * @param strokeOptions
     *            {@link StrokeOptions}
     * @return {@link Stroke}
     */
    public static Stroke createStroke(StrokeOptions strokeOptions) {
        return new Stroke(strokeOptions);
    };

    /**
     * Creates a new {@link Style} style.
     *
     * @param fill
     *            {@link Fill}
     * @return {@link Style}
     */
    public static Style createStyle(Fill fill) {
        StyleOptions styleOptions = createOptions();
        styleOptions.setFill(fill);
        return createStyle(styleOptions);
    }

    /**
     * Creates a new {@link Style} style.
     *
     * @param stroke
     *            {@link Stroke}
     * @return {@link Style}
     */
    public static Style createStyle(Stroke stroke) {
        StyleOptions styleOptions = createOptions();
        styleOptions.setStroke(stroke);
        return createStyle(styleOptions);
    }

    /**
     * Creates a new {@link Style} style.
     * @param text {@link Text}
     * @return {@link Style}
     */
    public static Style createStyle(Text text) {
        StyleOptions styleOptions = createOptions();
        styleOptions.setText(text);
        return createStyle(styleOptions);
    }

   /**
     * Creates a new {@link Style} style.
     *
     * @param fill
     *            {@link Fill}
     * @param stroke
     *            {@link Stroke}
     * @return {@link Style}
     */
    public static Style createStyle(Fill fill, Stroke stroke) {
        StyleOptions styleOptions = createOptions();
        styleOptions.setFill(fill);
        styleOptions.setStroke(stroke);
        return createStyle(styleOptions);
    }

    /**
     * Creates a new {@link Style} style.
     * @param fill {@link Fill}
     * @param stroke {@link Stroke}
     * @param text {@link Text}
     * @return {@link Style}
     */
    public static Style createStyle(Fill fill, Stroke stroke, Text text) {
        StyleOptions styleOptions = createOptions();
        styleOptions.setFill(fill);
        styleOptions.setStroke(stroke);
        styleOptions.setText(text);
        return createStyle(styleOptions);
    }

    /**
     * Creates a new {@link Style} style.
     *
     * @param image
     *            {@link ol.style.Image}
     * @return {@link Style}
     */
    public static Style createStyle(ol.style.Image image) {
        StyleOptions styleOptions = createOptions();
        styleOptions.setImage(image);
        return createStyle(styleOptions);
    }

    /**
     * Creates a new {@link Style}.
     *
     * @param styleOptions
     *            {@link StyleOptions}
     * @return {@link Style}
     */
    public static Style createStyle(StyleOptions styleOptions) {
        return new Style(styleOptions);
    };

    public static Text createText(TextOptions textOptions) {
        return new Text(textOptions);
    };

    public static TextOptions createTextOptions() {
        return new TextOptions();
    };

    public static TileDebug createTileDebug(TileDebugOptions tileDebugOptions) {
        return new TileDebug(tileDebugOptions);
    };

    /**
     * Creates a new Snap interaction
     *
     * @param snapOptions snap options
     * @return {@link Snap}
     */
    public static Snap createSnap(SnapOptions snapOptions) {
        return new Snap(snapOptions);
    };

    /**
     * Creates a tile grid.
     *
     * @param tileGridOptions
     *            {@link TileGridOptions}
     * @return {@link TileGrid}
     */
    public static TileGrid createTileGrid(TileGridOptions tileGridOptions) {
        return new TileGrid(tileGridOptions);
    };

    /**
     * Creates a tile grid with a standard XYZ tiling scheme.
     *
     * Tile grid options: extent: Extent for the tile grid. The origin for an
     * XYZ tile grid is the top-left corner of the extent. The zero level of the
     * grid is defined by the resolution at which one tile fits in the provided
     * extent. If not provided, the extent of the EPSG:3857 projection is used.
     * maxZoom: Maximum zoom. The default is ol.DEFAULT_MAX_ZOOM. This
     * determines the number of levels in the grid set. For example, a maxZoom
     * of 21 means there are 22 levels in the grid set.
     *
     * @param tileGridOptions
     *            {@link TileGridOptions}
     * @return {@link TileGrid}
     */
    public static TileGrid createTileGridXYZ(XyzTileGridOptions tileGridOptions) {
        return TileGrid.createXyz(tileGridOptions);
    };

    public static Tile createTileLayer(LayerOptions layerOptions) {
        return new Tile(layerOptions);
    };

    /**
     * Creates a new {@link ol.layer.Vector} source.
     *
     * @param vectorLayerOptions
     *            {@link LayerOptions}
     * @return {@link ol.layer.Vector}
     */
    public static ol.layer.Vector createVector(VectorLayerOptions vectorLayerOptions) {
        return new ol.layer.Vector(vectorLayerOptions);
    };

    /**
     * Creates a new {@link ol.source.Vector} source.
     *
     * @return {@link ol.source.Vector}
     */
    public static ol.source.Vector createVectorSource() {
        return new ol.source.Vector();
    };

    /**
     * Creates a new {@link ol.source.Vector} source.
     *
     * @param options
     *            {@link VectorOptions}
     * @return {@link ol.source.Vector}
     */
    public static ol.source.Vector createVectorSource(VectorOptions options) {
        return new ol.source.Vector(options);
    };

    /** View **/

    public static View createView() {
        return new View();
    };

    public static View createView(ViewOptions viewOptions) {
        return new ol.View(viewOptions);
    };

    public static Xyz createXyz(XyzOptions xyzOptions) {
        return new Xyz(xyzOptions);
    };

    /**
     * Creates a zoom control.
     *
     * @return {@link Zoom}
     */
    public static Zoom createZoom() {
        return new Zoom();
    };

    /**
     * Creates a zoom control.
     * @param options
     *            options
     *
     * @return {@link Zoom}
     */
    public static Zoom createZoom(ol.control.ZoomOptions options) {
        return new Zoom(options);
    };

    /**
     * Creates a zoom silder control.
     * @return {@link ZoomSlider}
     */
    public static ZoomSlider createZoomSlider() {
        return new ZoomSlider();
    };

    /**
     * Creates a zoom control.
     * @param options
     *            options
     *
     * @return {@link Zoom}
     */
    public static ZoomSlider createZoomSlider(ol.control.ZoomSliderOptions options) {
        return new ZoomSlider(options);
    };

    /**
     * Creates a {@link ZoomToExtent} control.
     * @return {@link ZoomToExtent}
     */
    public static ZoomToExtent createZoomToExtent() {
        return new ZoomToExtent();
    };

    /**
     * Creates a {@link ZoomToExtent} control.
     * @param options
     *            options
     * @return {@link ZoomToExtent}
     */
    public static ZoomToExtent createZoomToExtent(ZoomToExtentOptions options) {
        return new ZoomToExtent(options);
    };


    /**
     * Creates a {@link Select} interaction.
     * @param options
     *          options
     * @return {@link Select}
     */
    public static Select createSelect(SelectOptions options) {
        return new Select(options);
    };

    /**
     * Creates a {@link ol.style.RegularShape} style.
     *
     * @param regularShapeOptions
     *            {@link RegularShapeOptions}
     * @return {@link ol.style.RegularShape}
     */
    public static RegularShape createRegularShape(RegularShapeOptions regularShapeOptions) {
        return new RegularShape(regularShapeOptions);
    };

    public static TileWms createTileWMSSource(TileWmsOptions tileWmsOptions) {
        return new TileWms(tileWmsOptions);
    };

    /**
     * Get the default map interactions.
     *
     * @param doubleClickToZoom
     * @return default map interactions
     */
    public static final Collection<Interaction> getDefaultInteractions(boolean doubleClickToZoom) {

        DefaultInteractionsOptions interactionsOptions = new DefaultInteractionsOptions();
        interactionsOptions.setDoubleClickZoom(doubleClickToZoom);

        return Interaction.defaults(interactionsOptions);

    };

}
