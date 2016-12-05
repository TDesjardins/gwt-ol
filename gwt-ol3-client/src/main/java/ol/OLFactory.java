package ol;

import com.google.gwt.core.client.JavaScriptObject;
import ol.color.Color;
import ol.control.Control;
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
import ol.format.GeoJSON;
import ol.format.GeoJSONOptions;
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
import ol.gwt.TypedObject;
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
import ol.source.ImageWMS;
import ol.source.ImageWMSOptions;
import ol.source.Osm;
import ol.source.Source;
import ol.source.Stamen;
import ol.source.StamenOptions;
import ol.source.TileDebug;
import ol.source.TileDebugOptions;
import ol.source.TileWMS;
import ol.source.TileWMSOptions;
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

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Factory to create GWT-OL3 instances from JavaScript based on OL3-Interfaces.
 * Can be also done with GIN. When GWT supports Java 8 (hopefully in GWT 3.0)
 * factory methods can directly created in the interfaces.
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
     * Creates an {@link Attribution}.
     *
     * @param attributionOptions
     *            {@link AttributionOptions}
     * @return {@link Attribution}
     */
    public static native Attribution createAttribution(AttributionOptions attributionOptions) /*-{
        return new $wnd.ol.Attribution(attributionOptions);
    }-*/;

    /**
     * Creates an {@link Attribution}.
     *
     * @param html HTML markup for this attribution. Required.
     * @return {@link Attribution}
     */
    public static Attribution createAttribution(String html) {
        AttributionOptions attributionOptions = OLFactory.<AttributionOptions> createOptions();
        attributionOptions.setHtml(html);
        return createAttribution(attributionOptions);
    }

    /**
     * Creates an {@link ol.control.Attribution}.
     *
     * @return {@link ol.control.Attribution}
     */
    public static native ol.control.Attribution createAttributionControl() /*-{
    	return new $wnd.ol.control.Attribution();
    }-*/;

    /**
     * Creates an {@link ol.control.Attribution}.
     * @param options
     *            options
     *
     * @return {@link ol.control.Attribution}
     */
    public static native ol.control.Attribution createAttributionControl(ol.control.AttributionOptions options) /*-{
        return new $wnd.ol.control.Attribution(options);
    }-*/;

    /**
     * Creates a {@link Circle}.
     *
     * @param center
     *            center
     * @param radius
     *            radius
     * @return {@link Circle}
     */
    public static native Circle createCircle(Coordinate center, double radius) /*-{
        return new $wnd.ol.geom.Circle(center, radius);
    }-*/;

    /**
     * Creates a {@link ol.style.Circle} style.
     *
     * @param circleOptions
     *            {@link CircleOptions}
     * @return {@link ol.style.Circle}
     */
    public static native ol.style.Circle createCircleStyle(CircleOptions circleOptions) /*-{
        return new $wnd.ol.style.Circle(circleOptions);
    }-*/;

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
    public static native <T> Collection<T> createCollection() /*-{
    	return new $wnd.ol.Collection();
    }-*/;

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
    public static native Color createColor(int red, int green, int blue, double alpha) /*-{
    	return [ red, green, blue, alpha ];
    }-*/;

    /**
     * Creates a {@link Color} from the given String.
     *
     * @param color
     *            color in rgb(r,g,b) or rgba(r,g,b,a) format, or in hex #rrggbb
     *            or #rgb format
     * @return {@link Color}
     */
    public static native Color createColor(String color) /*-{
        return $wnd.ol.color.fromString(color);
    }-*/;

    /**
     * Creates an instance.
     *
     * @param x
     *            X-coordinate (longitude)
     * @param y
     *            Y-coordinate (latitude)
     * @return {@link Coordinate}
     */
    public static native Coordinate createCoordinate(double x, double y) /*-{
    	return [ x, y ];
    }-*/;

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
    public static native Coordinate createCoordinate(double x, double y, double z) /*-{
    	return [ x, y, z ];
    }-*/;

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
    public static native Collection<Control> createDefaultControls(@Nullable Options options) /*-{
        return new $wnd.ol.control.defaults(options);
    }-*/;

    /** Interactions **/

    public static native DragAndDrop createDragAndDrop() /*-{
    	return new $wnd.ol.interaction.DragAndDrop();
    }-*/;

    /**
     * Creates a {@link Draw}.
     *
     * @param options
     *            {@link DrawOptions}
     *
     * @return {@link Draw}
     */
    public static native Draw createDraw(DrawOptions options) /*-{
    	return new $wnd.ol.interaction.Draw(options);
    }-*/;

    /**
     * Creates an {@link Extent}.
     *
     * @param minX
     * @param minY
     * @param maxX
     * @param maxY
     * @return {@link Extent}
     */
    public static native Extent createExtent(double minX, double minY, double maxX, double maxY) /*-{
    	return [ minX, minY, maxX, maxY ];
    }-*/;

    /**
     * Creates a {@link Feature}.
     *
     * @return {@link Feature}
     */
    public static native Feature createFeature() /*-{
    	return new $wnd.ol.Feature();
    }-*/;

    /**
     * Creates a {@link Feature}.
     *
     * @param options
     *            {@link FeatureOptions}
     *
     * @return {@link Feature}
     */
    public static native Feature createFeature(FeatureOptions options) /*-{
    	return new $wnd.ol.Feature(options);
    }-*/;

    /**
     * Creates a {@link Feature}.
     *
     * @param geom
     *            {@link Geometry}
     *
     * @return {@link Feature}
     */
    public static native Feature createFeature(Geometry geom) /*-{
    	return new $wnd.ol.Feature(geom);
    }-*/;

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
        Feature f = createFeature(geom);
        f.setStyle(style);
        return f;
    }

    /**
     * Creates a new {@link Fill} style.
     *
     * @param color
     *            fill color
     * @return {@link Fill}
     */
    public static Fill createFill(Color color) {
        FillOptions fillOptions = OLFactory.<FillOptions> createOptions();
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
    public static native Fill createFill(FillOptions fillOptions) /*-{
    	return new $wnd.ol.style.Fill(fillOptions);
    }-*/;

    /** Controls **/

    /**
     * Creates a {@link FullScreen} control.
     * @return {@link FullScreen}
     */
    public static native FullScreen createFullScreen() /*-{
    	return new $wnd.ol.control.FullScreen();
    }-*/;

    /**
     * Creates a {@link FullScreen} control.
     * @param options
     *            options
     * @return {@link FullScreen}
     */
    public static native FullScreen createFullScreen(FullScreenOptions options) /*-{
        return new $wnd.ol.control.FullScreen(options);
    }-*/;

    /**
     * Creates a {@link GeometryCollection}.
     * @param geoms An array of {@link ol.geom.Geometry} objects. (optional)
     *
     * @return {@link GeometryCollection}
     */
    public static native GeometryCollection createGeometryCollection(@Nullable Geometry[] geoms) /*-{
	return new $wnd.ol.geom.GeometryCollection(geoms);
    }-*/;

    /**
     * Creates a {@link GeoJSON}.
     *
     * @param options
     *            {@link GeoJSONOptions}
     *
     * @return {@link GeoJSON}
     */
    public static native GeoJSON createGeoJSON(GeoJSONOptions options) /*-{
    	return new $wnd.ol.format.GeoJSON(options);
    }-*/;

    /**
     * Creates a {@link GeoJSON}.
       *
     * @return {@link GeoJSON}
     */
    public static native GeoJSON createGeoJSON() /*-{
    	return new $wnd.ol.format.GeoJSON();
    }-*/;
    /**
     * Creates an {@link Graticule}.
     *
     * @return {@link Graticule}
     */
    public static native Graticule createGraticule() /*-{
    	return new $wnd.ol.Graticule();
    }-*/;

    /** Layers **/

    public static native Image createImageLayer(LayerOptions layerOptions) /*-{
    	return new $wnd.ol.layer.Image(layerOptions);
    }-*/;

    /** Sources **/

    /**
     * create a MapGuide image
     * @param imageMapGuideOptions
     * @return {@link ImageMapGuide}
     * **/
    public static native ImageMapGuide createImageMapGuideSource(ImageMapGuideOptions imageMapGuideOptions) /*-{
	    return new $wnd.ol.source.ImageMapGuide(imageMapGuideOptions);
	}-*/;

    public static native ImageStatic createImageStaticSource(ImageStaticOptions imageStaticOptions) /*-{
    	return new $wnd.ol.source.ImageStatic(imageStaticOptions);
    }-*/;

    public static native ImageWMS createImageWMSSource(ImageWMSOptions imageWMSOptions) /*-{
    	return new $wnd.ol.source.ImageWMS(imageWMSOptions);
    }-*/;

    public static native KeyboardPan createKeyboardPan() /*-{
    	return new $wnd.ol.interaction.KeyboardPan();
    }-*/;

    public static native KeyboardZoom createKeyboardZoom() /*-{
    	return new $wnd.ol.interaction.KeyboardZoom();
    }-*/;

    /**
     * Creates a {@link ol.layer.Group}.
     *
     * @param options
     *            {@link ol.layer.LayerGroupOptions}
     * @return {@link ol.layer.Group}
     */
    public static native ol.layer.Group createLayerGroup(LayerGroupOptions options) /*-{
        return new $wnd.ol.layer.Group(options);
    }-*/;

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
    public static native LinearRing createLinearRing(Coordinate[] coordinates) /*-{
    	return new $wnd.ol.geom.LinearRing(coordinates);
    }-*/;

    /**
     * Creates a {@link LinearRing}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link LinearRing}
     */
    public static native LinearRing createLinearRing(@Nullable Coordinate[] coordinates,
	    @Nullable String geometryLayout) /*-{
	    return new $wnd.ol.geom.LinearRing(coordinates, geometryLayout);
	}-*/;

    /**
     * Creates a {@link LineString}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link LineString}
     */
    public static native LineString createLineString(Coordinate[] coordinates) /*-{
    	return new $wnd.ol.geom.LineString(coordinates);
    }-*/;

    /**
     * Creates a {@link LineString}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link LineString}
     */
    public static native LineString createLineString(@Nullable Coordinate[] coordinates,
	    @Nullable String geometryLayout) /*-{
	    return new $wnd.ol.geom.LineString(coordinates, geometryLayout);
	}-*/;

    /**
     * Creates a {@link Map}.
     *
     * @param mapOptions
     *            {@link MapOptions}
     * @return {@link Map}
     */
    public static native Map createMap(MapOptions mapOptions) /*-{
    	return new $wnd.ol.Map(mapOptions);
    }-*/;

	/**
	 * 
	 * Creates a {@link ol.interaction.Modify}
	 *
	 * @param modifyOptions {@link ol.interaction.ModifyOptions}
	 * @return {@link ol.interaction.Modify}
	 */
	public static native Modify createModify(ModifyOptions modifyOptions) /*-{
		return new $wnd.ol.interaction.Modify(modifyOptions);
	}-*/;

    /**
     * Creates a {@link MousePosition} control.
     * @return {@link MousePosition}
     */
    public static native MousePosition createMousePosition() /*-{
    	return new $wnd.ol.control.MousePosition();
    }-*/;

    /**
     * Creates a {@link MousePosition} control.
     * @param options
     *            options
     * @return {@link MousePosition}
     */
    public static native MousePosition createMousePosition(MousePositionOptions options) /*-{
        return new $wnd.ol.control.MousePosition(options);
    }-*/;

    /**
     * Creates a {@link MultiLineString}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiLineString}
     */
    public static native MultiLineString createMultiLineString(Coordinate[] coordinates) /*-{
    	return new $wnd.ol.geom.MultiLineString(coordinates);
    }-*/;

    /**
     * Creates a {@link MultiLineString}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link MultiLineString}
     */
    public static native MultiLineString createMultiLineString(@Nullable Coordinate[] coordinates,
	    @Nullable String geometryLayout) /*-{
	    return new $wnd.ol.geom.MultiLineString(coordinates, geometryLayout);
	}-*/;

    /**
     * Creates a {@link MultiPoint}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiPoint}
     */
    public static native MultiPoint createMultiPoint(Coordinate[] coordinates) /*-{
    	return new $wnd.ol.geom.MultiPoint(coordinates);
    }-*/;

    /**
     * Creates a {@link MultiPoint}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link MultiPoint}
     */
    public static native MultiPoint createMultiPoint(@Nullable Coordinate[] coordinates,
	    @Nullable String geometryLayout) /*-{
	    return new $wnd.ol.geom.MultiPoint(coordinates, geometryLayout);
	}-*/;

    /**
     * Creates a {@link MultiPolygon}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiPolygon}
     */
    public static native MultiPolygon createMultiPolygon(Coordinate[] coordinates) /*-{
	    return new $wnd.ol.geom.MultiPolygon(coordinates);
    }-*/;

    /**
     * Creates a {@link MultiPolygon}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link MultiPolygon}
     */
    public static native MultiPolygon createMultiPolygon(@Nullable Coordinate[] coordinates,
	    @Nullable String geometryLayout) /*-{
	    return new $wnd.ol.geom.MultiPolygon(coordinates, geometryLayout);
	}-*/;

    /**
     * Create a typed object. Returns the same instance as the given object
     * while checking types to comply to one of the types of the TypedObject.
     *
     * @param object
     *            object
     * @return {@link TypedObject}
     */
    public static native <T, U> TypedObject<T, U> createObject1(T object) /*-{
    	return object;
    }-*/;

    /**
     * Create a typed object. Returns the same instance as the given object
     * while checking types to comply to one of the types of the TypedObject.
     *
     * @param object
     *            object
     * @return {@link TypedObject}
     */
    public static native <T, U> TypedObject<T, U> createObject2(U object) /*-{
    	return object;
    }-*/;

    /**
     * Create generic options.
     *
     * @return options instance
     */
    public static native <T extends Options> T createOptions() /*-{
    	return {};
    }-*/;

    public static native Osm createOsm(XyzOptions osmOptions) /*-{
    	return new $wnd.ol.source.OSM(osmOptions);
    }-*/;

    /**
     * Creates an {@link Overlay}.
     *
     * @param options
     *            {@link OverlayOptions}
     * @return {@link Overlay}
     */
    public static native Overlay createOverlay(OverlayOptions options) /*-{
        return new $wnd.ol.Overlay(options);
    }-*/;

    /**
     * Creates an {@link OverviewMap} control.
     * @return {@link OverviewMap}
     */
    public static native OverviewMap createOverviewMap() /*-{
        return new $wnd.ol.control.OverviewMap();
    }-*/;

    /**
     * Creates an {@link OverviewMap} control.
     * @param options
     *            options
     * @return {@link OverviewMap}
     */
    public static native OverviewMap createOverviewMap(OverviewMapOptions options) /*-{
        return new $wnd.ol.control.OverviewMap(options);
    }-*/;

    /**
     * Creates an instance.
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @return {@link Pixel}
     */
    public static native Pixel createPixel(int x, int y) /*-{
    	return [ x, y ];
    }-*/;

    /**
     * Creates an instance.
     *
     * @param coordinates
     *            coordinates
     * @return {@link Point}
     */
    public static native Point createPoint(Coordinate coordinates) /*-{
    	return new $wnd.ol.geom.Point(coordinates);
    }-*/;

    /**
     * Creates an instance.
     *
     * @param coordinates coordinates
     * @param geometryLayout geometry layout
     * @return {@link Point}
     */
    public static native Point createPoint(@Nullable Coordinate coordinates, @Nullable String geometryLayout) /*-{
    	return new $wnd.ol.geom.Point(coordinates, geometryLayout);
    }-*/;

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
	public static native Polygon createPolygon() /*-{
		return new $wnd.ol.geom.Polygon([]);
	}-*/;

    /**
     * Creates a {@link Polygon}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link Polygon}
     */
    public static native Polygon createPolygon(Coordinate[][] coordinates) /*-{
    	return new $wnd.ol.geom.Polygon(coordinates);
    }-*/;

    /**
     * Creates a {@link Polygon}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link Polygon}
     */
    public static native Polygon createPolygon(@Nullable Coordinate[][] coordinates, @Nullable String geometryLayout) /*-{
    	return new $wnd.ol.geom.Polygon(coordinates, geometryLayout);
    }-*/;

    /** Projection **/

    public static native Projection createProjection(ProjectionOptions projectionOptions) /*-{
    	return new $wnd.ol.proj.Projection(projectionOptions);
    }-*/;

    /**
     * Create a {@link Rotate} control.
     * @return {@link Rotate}
     */
    public static native Rotate createRotate() /*-{
    	return new $wnd.ol.control.Rotate();
    }-*/;

    /**
     * Create a {@link Rotate} control.
     * @param options
     *            options
     * @return {@link Rotate}
     */
    public static native Rotate createRotate(RotateOptions options) /*-{
        return new $wnd.ol.control.Rotate(options);
    }-*/;

    /**
     * Creates a {@link ScaleLine}.
     *
     * @return {@link ScaleLine}
     */
    public static native ScaleLine createScaleLine() /*-{
    	return new $wnd.ol.control.ScaleLine();
    }-*/;

    /**
     * Creates a {@link ScaleLine}.
     * @param options
     *            options
     *
     * @return {@link ScaleLine}
     */
    public static native ScaleLine createScaleLine(ScaleLineOptions options) /*-{
        return new $wnd.ol.control.ScaleLine(options);
    }-*/;

    /**
     * Creates a {@link Size}.
     *
     * @param width
     *            width
     * @param height
     *            height
     * @return {@link Size}
     */
    public static native Size createSize(int width, int height) /*-{
    	return [ width, height ];
    }-*/;

	/**
	 * Creates a {@link TileCoord}.
	 *
	 * @param z
	 *            z
	 * @param x
	 *            x
	 * @param y
	 *            y
	 * @return {@link TileCoord}
	 */
	public static native TileCoord createTileCoord(double x, double y, double z) /*-{
		return [ z, x, y ];
	}-*/;

    /**
     * Creates a {@link Sphere}.
     * @param radius
     *            Radius.
     *
     * @return {@link Sphere}
     */
    public static native Sphere createSphere(double radius) /*-{
        return new $wnd.ol.Sphere(radius);
    }-*/;

    /** Common **/

    public static native Stamen createStamenSource(StamenOptions stamenOptions) /*-{
    	return new $wnd.ol.source.Stamen(stamenOptions);
    }-*/;

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
        StrokeOptions strokeOptions = OLFactory.<StrokeOptions> createOptions();
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
    public static native Stroke createStroke(StrokeOptions strokeOptions) /*-{
    	return new $wnd.ol.style.Stroke(strokeOptions);
    }-*/;

    /**
     * Creates a new {@link Style} style.
     *
     * @param fill
     *            {@link Fill}
     * @return {@link Style}
     */
    public static Style createStyle(Fill fill) {
        StyleOptions styleOptions = OLFactory.<StyleOptions> createOptions();
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
        StyleOptions styleOptions = OLFactory.<StyleOptions> createOptions();
        styleOptions.setStroke(stroke);
        return createStyle(styleOptions);
    }

    /**
     * Creates a new {@link Style} style.
     * @param text {@link Text}
     * @return {@link Style}
     */
    public static Style createStyle(Text text){
        StyleOptions styleOptions = OLFactory.<StyleOptions> createOptions();
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
        StyleOptions styleOptions = OLFactory.<StyleOptions> createOptions();
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
    public static Style createStyle(Fill fill, Stroke stroke, Text text)
    {
        StyleOptions styleOptions = OLFactory.<StyleOptions> createOptions();
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
        StyleOptions styleOptions = OLFactory.<StyleOptions> createOptions();
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
    public static native Style createStyle(StyleOptions styleOptions) /*-{
    	return new $wnd.ol.style.Style(styleOptions);
    }-*/;

    public static native Text createText(TextOptions textOptions) /*-{
    	return new $wnd.ol.style.Text(textOptions);
    }-*/;

    public static native TextOptions createTextOptions() /*-{
    	return {};
    }-*/;

    public static native TileDebug createTileDebug(TileDebugOptions tileDebugOptions) /*-{
    	return new $wnd.ol.source.TileDebug(tileDebugOptions);
    }-*/;

	/**
	 * Creates a new Snap interaction
	 *
	 * @param snapOptions snap options
	 * @return {@link Snap}
	 */
	public static native Snap createSnap(SnapOptions snapOptions)/*-{
		return new $wnd.ol.interaction.Snap(snapOptions);
	}-*/;

    /**
     * Creates a tile grid.
     *
     * @param tileGridOptions
     *            {@link TileGridOptions}
     * @return {@link TileGrid}
     */
    public static native TileGrid createTileGrid(TileGridOptions tileGridOptions) /*-{
    	return new $wnd.ol.tilegrid.TileGrid(tileGridOptions);
    }-*/;

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
    public static native TileGrid createTileGridXYZ(TileGridOptions tileGridOptions) /*-{
    	return $wnd.ol.tilegrid.createXYZ(tileGridOptions);
    }-*/;

    public static native Tile createTileLayer(LayerOptions layerOptions) /*-{
    	return new $wnd.ol.layer.Tile(layerOptions);
    }-*/;

    /**
     * Creates a new {@link ol.layer.Vector} source.
     *
     * @param options
     *            {@link LayerOptions}
     * @return {@link ol.layer.Vector}
     */
    public static native ol.layer.Vector createVector(LayerOptions options) /*-{
    	return new $wnd.ol.layer.Vector(options);
    }-*/;

    /**
     * Creates a new {@link ol.source.Vector} source.
     *
     * @return {@link ol.source.Vector}
     */
    public static native ol.source.Vector createVectorSource() /*-{
    	return new $wnd.ol.source.Vector();
    }-*/;

    /**
     * Creates a new {@link ol.source.Vector} source.
     *
     * @param options
     *            {@link VectorOptions}
     * @return {@link ol.source.Vector}
     */
    public static native ol.source.Vector createVectorSource(VectorOptions options) /*-{
    	return new $wnd.ol.source.Vector(options);
    }-*/;

    /** View **/

    public static native View createView() /*-{
    	return new $wnd.ol.View();
    }-*/;

    public static native View createView(ViewOptions viewOptions) /*-{
    	return new $wnd.ol.View(viewOptions);
    }-*/;

    public static native Xyz createXyz(XyzOptions xyzOptions) /*-{
    	return new $wnd.ol.source.XYZ(xyzOptions);
    }-*/;

    /**
     * Creates a zoom control.
     *
     * @return {@link Zoom}
     */
    public static native Zoom createZoom() /*-{
    	return new $wnd.ol.control.Zoom();
    }-*/;

    /**
     * Creates a zoom control.
     * @param options
     *            options
     *
     * @return {@link Zoom}
     */
    public static native Zoom createZoom(ol.control.ZoomOptions options) /*-{
        return new $wnd.ol.control.Zoom(options);
    }-*/;

    /**
     * Creates a zoom silder control.
     * @return {@link ZoomSlider}
     */
    public static native ZoomSlider createZoomSlider() /*-{
    	return new $wnd.ol.control.ZoomSlider();
    }-*/;

    /**
     * Creates a zoom control.
     * @param options
     *            options
     *
     * @return {@link Zoom}
     */
    public static native ZoomSlider createZoomSlider(ol.control.ZoomSliderOptions options) /*-{
        return new $wnd.ol.control.ZoomSlider(options);
    }-*/;

    /**
     * Creates a {@link ZoomToExtent} control.
     * @return {@link ZoomToExtent}
     */
    public static native ZoomToExtent createZoomToExtent() /*-{
    	return new $wnd.ol.control.ZoomToExtent();
    }-*/;

    /**
     * Creates a {@link ZoomToExtent} control.
     * @param options
     *            options
     * @return {@link ZoomToExtent}
     */
    public static native ZoomToExtent createZoomToExtent(ZoomToExtentOptions options) /*-{
        return new $wnd.ol.control.ZoomToExtent(options);
    }-*/;


    /**
     * Creates a {@link Select} interaction.
     * @param options
     *          options
     * @return {@link Select}
     */
    public static native Select createSelect(SelectOptions options) /*-{
        return new $wnd.ol.interaction.Select(options);
    }-*/;

    /**
     * Creates a {@link ol.style.RegularShape} style.
     *
     * @param regularShapeOptions
     *            {@link RegularShapeOptions}
     * @return {@link ol.style.RegularShape}
     */
    public static native RegularShape createRegularShape(RegularShapeOptions regularShapeOptions) /*-{
        return new $wnd.ol.style.RegularShape(regularShapeOptions);
    }-*/;

    public static native TileWMS createTileWMSSource(TileWMSOptions tileWmsOptions) /*-{
        return new $wnd.ol.source.TileWMS(tileWmsOptions);
    }-*/;

    /**
     * Fetches a Projection object for the code specified.
     *
     * @param proj
     *            Either a code string which is a combination of authority and
     *            identifier such as "EPSG:4326", or an existing projection
     *            object, or undefined.
     * @return {@link ol.proj.Projection} Projection object, or null if not in list.
     * @deprecated Use {@link ol.proj.Projection#get(String)} instead.
     */
    @Deprecated
    public static Projection get(String proj) {
        return Projection.get(proj);
    }

    public static native JavaScriptObject createEventFunction(Executor t) /*-{
        return function (selectevent) {
            t.action(selectevent);
        };
    }-*/;

    public static JavaScriptObject createEventFunction(GenericFunction<JavaScriptObject, Void> genericFunction){
        Executor executor = new Executor(genericFunction);
        return createEventFunction(executor);
    }

	/**
	 * Registers a proj4 definition by its spatial reference id.
	 *
	 * @param srid
	 * @param proj4text
	 */
	public static final native void registerSpatialReference(int srid, String proj4text) /*-{
		$wnd.proj4.defs('EPSG:' + srid, proj4text);
	}-*/;
	
	/**
	 * Registers a proj4 definition by its spatial reference id.
	 *
	 * @param srid
	 * @param proj4text
	 */
	public static final native void registerSpatialReference(String srid, String proj4text) /*-{
		$wnd.proj4.defs(srid, proj4text);
	}-*/;

	/**
	 * Get the default map interactions.
	 *
	 * @param doubleClickToZoom
	 * @return default map interactions
	 */
	public static final native Collection<Interaction> getDefaultInteractions(boolean doubleClickToZoom)/*-{
		return $wnd.ol.interaction.defaults({
			doubleClickZoom : doubleClickToZoom
		});
	}-*/;
}
