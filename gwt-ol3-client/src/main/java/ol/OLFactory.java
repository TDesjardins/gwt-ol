package ol;

import javax.annotation.Nullable;

import ol.color.Color;
import ol.control.*;
import ol.geom.*;
import ol.geom.Circle;
import ol.interaction.*;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.*;
import ol.source.*;
import ol.style.*;
import ol.tilegrid.*;

/**
 * Factory to create GWT-OL3 instances from JavaScript based on OL3-Interfaces.
 * Can be also done with GIN. When GWT supports Java 8 (hopefully in GWT 3.0)
 * factory methods can directly created in the interfaces.
 *
 * @author Tino Desjardins
 */
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
    public static native Attribution createAttribution(AttributionOptions attributionOptions)
    /*-{
		return new $wnd.ol.Attribution(attributionOptions);
    }-*/;

    /**
     * Creates an {@link Attribution}.
     *
     * @param html
     *            HTML markup for this attribution. Required.
     * @return {@link Attribution}
     */
    public static Attribution createAttribution(String html) {
	return createAttribution(OLFactory.<AttributionOptions> createOptions().setHtml(html));
    }

    /**
     * Creates a {@link Circle}.
     *
     * @param center
     *            center
     * @param radius
     *            radius
     * @return {@link Circle}
     */
    public static native Circle createCircle(Coordinate center, double radius)
    /*-{
		return $wnd.ol.geom.Circle(center, radius);
    }-*/;

    /**
     * Creates a {@link Collection}.
     *
     * @return {@link Collection}
     */
    public static native <T> Collection<T> createCollection()
    /*-{
		return new $wnd.ol.Collection();
    }-*/;

    /**
     * Creates a {@link Color} from the given values.
     *
     * @param r
     *            red (0-255)
     * @param g
     *            green (0-255)
     * @param b
     *            blue (0-255)
     * @param alpha
     *            alpha (0-1)
     * @return {@link Color}
     */
    public static native Color createColor(int r, int g, int b, float alpha)
    /*-{
		return [ r, g, b, a ];
    }-*/;

    /**
     * Creates a {@link Color} from the given String.
     *
     * @param color
     *            color in rgb(r,g,b) or rgba(r,g,b,a) format, or in hex #rrggbb
     *            or #rgb format
     * @return {@link Color}
     */
    public static native Color createColor(String color)
    /*-{
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
    public static native Coordinate createCoordinate(double x, double y)
    /*-{
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
    public static native Coordinate createCoordinate(double x, double y, double z)
    /*-{
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
	if (coords.length > 2) {
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
    public static native Collection<Control> createDefaultControls(@Nullable Options options)
    /*-{
		return new $wnd.ol.control.defaults(options);
    }-*/;

    /** Interactions **/

    public static native DragAndDrop createDragAndDrop()
    /*-{
		return new $wnd.ol.interaction.DragAndDrop();
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
    public static native Extent createExtent(double minX, double minY, double maxX, double maxY)
    /*-{
		return [ minX, minY, maxX, maxY ];
    }-*/;

    /**
     * Creates a new {@link Fill} style.
     *
     * @param color
     *            fill color
     * @return {@link Fill}
     */
    public static Fill createFill(Color color) {
	return createFill(createFillOptions().color(color));
    }

    /**
     * Creates a new {@link Fill} style.
     *
     * @param fillOptions
     *            {@link FillOptions}
     * @return {@link Fill}
     */
    public static native Fill createFill(FillOptions fillOptions)
    /*-{
		return new $wnd.ol.style.Fill(fillOptions);
    }-*/;

    /**
     * Creates new {@link FillOptions}.
     *
     * @return {@link FillOptions}
     */
    public static FillOptions createFillOptions() {
	return createOptions();
    }

    /** Controls **/

    public static native FullScreen createFullScreen()
    /*-{
		return new $wnd.ol.control.FullScreen();
    }-*/;

    /** Layers **/

    public static native Image createImageLayer(LayerOptions layerOptions)
    /*-{
		return new $wnd.ol.layer.Image(layerOptions);
    }-*/;

    /** Sources **/

    public static native ImageStatic createImageStaticSource(ImageStaticOptions imageStaticOptions)
    /*-{
		return new $wnd.ol.source.ImageStatic(imageStaticOptions);
    }-*/;

    public static native ImageWMS createImageWMSSource(ImageWMSOptions imageWMSOptions)
    /*-{
		return new $wnd.ol.source.ImageWMS(imageWMSOptions);
    }-*/;

    public static native KeyboardPan createKeyboardPan()
    /*-{
		return new $wnd.ol.interaction.KeyboardPan();
    }-*/;

    public static native KeyboardZoom createKeyboardZoom()
    /*-{
		return new $wnd.ol.interaction.KeyboardZoom();
    }-*/;

    /**
     * Creates {@link LayerOptions}.
     *
     * @return {@link LayerOptions}
     */
    public static LayerOptions createLayerOptions() {
	return createOptions();
    }

    /**
     * Creates a {@link LinearRing}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link LinearRing}
     */
    public static native LinearRing createLinearRing(Coordinate[] coordinates)
    /*-{
		return $wnd.ol.geom.LinearRing(coordinates);
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
	    @Nullable String geometryLayout)
	    /*-{
		return $wnd.ol.geom.LinearRing(coordinates, geometryLayout);
    }-*/;

    /**
     * Creates a {@link LineString}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link LineString}
     */
    public static native LineString createLineString(Coordinate[] coordinates)
    /*-{
		return $wnd.ol.geom.LineString(coordinates);
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
	    @Nullable String geometryLayout)
	    /*-{
		return $wnd.ol.geom.LineString(coordinates, geometryLayout);
    }-*/;

    /**
     * Creates a {@link Map}.
     *
     * @param mapOptions
     *            {@link MapOptions}
     * @return {@link Map}
     */
    public static native Map createMap(MapOptions mapOptions)
    /*-{
		return new $wnd.ol.Map(mapOptions);
    }-*/;

    public static MapOptions createMapOptions() {
	return createOptions();
    }

    public static MapQuestOptions createMapQuestOptions() {
	return createOptions();
    }

    public static native MapQuest createMapQuestSource(MapQuestOptions mapQuestOptions)
    /*-{
		return new $wnd.ol.source.MapQuest(mapQuestOptions);
    }-*/;

    public static native MousePosition createMousePosition()
    /*-{
		return new $wnd.ol.control.MousePosition();
    }-*/;

    /**
     * Creates a {@link MultiLineString}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiLineString}
     */
    public static native MultiLineString createMultiLineString(Coordinate[] coordinates)
    /*-{
		return $wnd.ol.geom.MultiLineString(coordinates);
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
	    @Nullable String geometryLayout)
	    /*-{
		return $wnd.ol.geom.MultiLineString(coordinates, geometryLayout);
    }-*/;

    /**
     * Creates a {@link MultiPoint}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiPoint}
     */
    public static native MultiPoint createMultiPoint(Coordinate[] coordinates)
    /*-{
		return $wnd.ol.geom.MultiPoint(coordinates);
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
	    @Nullable String geometryLayout)
	    /*-{
		return $wnd.ol.geom.MultiPoint(coordinates, geometryLayout);
    }-*/;

    /**
     * Creates a {@link MultiPolygon}.
     *
     * @param coordinates
     *            coordinates
     * @return {@link MultiPolygon}
     */
    public static native MultiPolygon createMultiPolygon(Coordinate[] coordinates)
    /*-{
		return $wnd.ol.geom.MultiPolygon(coordinates);
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
	    @Nullable String geometryLayout)
	    /*-{
		return $wnd.ol.geom.MultiPolygon(coordinates, geometryLayout);
    }-*/;

    /**
     * Create generic options.
     *
     * @return options instance
     */
    public static native <T extends Options> T createOptions()
    /*-{
		return {};
    }-*/;

    public static native Osm createOsm(XyzOptions osmOptions)
    /*-{
		return new $wnd.ol.source.OSM(osmOptions);
    }-*/;

    /**
     * Creates an instance.
     *
     * @param x
     *            X-coordinate
     * @param y
     *            Y-coordinate
     * @return {@link Pixel}
     */
    public static native Pixel createPixel(int x, int y)
    /*-{
		return [ x, y ];
    }-*/;

    /**
     * Creates an instance.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link Point}
     */
    public static native Point createPoint(@Nullable Coordinate coordinates, @Nullable String geometryLayout)
    /*-{
		return $wnd.ol.geom.Point(coordinates, geometryLayout);
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
     * @param coordinates
     *            coordinates
     * @return {@link Polygon}
     */
    public static native Polygon createPolygon(Coordinate[] coordinates)
    /*-{
		return $wnd.ol.geom.Polygon(coordinates);
    }-*/;

    /** Common **/

    /**
     * Creates a {@link Polygon}.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link Polygon}
     */
    public static native Polygon createPolygon(@Nullable Coordinate[] coordinates, @Nullable String geometryLayout)
    /*-{
		return $wnd.ol.geom.Polygon(coordinates, geometryLayout);
    }-*/;

    /** Projection **/

    public static native Projection createProjection(ProjectionOptions projectionOptions)
    /*-{
		return new $wnd.ol.proj.Projection(projectionOptions);
    }-*/;

    public static native Rotate createRotate()
    /*-{
		return new $wnd.ol.control.Rotate();
    }-*/;

    /**
     * Creates a {@link ScaleLine}.
     *
     * @return {@link ScaleLine}
     */
    public static native ScaleLine createScaleLine()
    /*-{
		return new $wnd.ol.control.ScaleLine();
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
    public static native Size createSize(int width, int height)
    /*-{
		return [ width, height ];
    }-*/;

    public static StamenOptions createStamenOptions() {
	return createOptions();
    }

    public static native Stamen createStamenSource(StamenOptions stamenOptions)
    /*-{
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
	return createStroke(createStrokeOptions().color(color).width(width));
    }

    /**
     * Creates a new {@link Stroke} style.
     *
     * @param strokeOptions
     *            {@link StrokeOptions}
     * @return {@link Stroke}
     */
    public static native Stroke createStroke(StrokeOptions strokeOptions)
    /*-{
		return new $wnd.ol.style.Stroke(strokeOptions);
    }-*/;

    /**
     * Creates new {@link StrokeOptions}
     *
     * @return {@link StrokeOptions}
     */
    public static StrokeOptions createStrokeOptions() {
	return createOptions();
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
	return createStyle(createStyleOptions().fill(fill).stroke(stroke));
    }

    /**
     * Creates a new {@link Style}.
     *
     * @param styleOptions
     *            {@link StyleOptions}
     * @return {@link Style}
     */
    public static native Style createStyle(StyleOptions styleOptions)
    /*-{
		return new $wnd.ol.style.Style(styleOptions);
    }-*/;

    /**
     * Creates new {@link StyleOptions}
     *
     * @return {@link StyleOptions}
     */
    public static StyleOptions createStyleOptions() {
	return createOptions();
    }

    public static native TileDebug createTileDebug(TileDebugOptions tileDebugOptions)
    /*-{
		return new $wnd.ol.source.TileDebug(tileDebugOptions);
    }-*/;

    /**
     * Creates a tile grid.
     *
     * @param tileGridOptions
     *            {@link TileGridOptions}
     * @return {@link TileGrid}
     */
    public static native TileGrid createTileGrid(TileGridOptions tileGridOptions)
    /*-{
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
    public static native TileGrid createTileGridXYZ(TileGridOptions tileGridOptions)
    /*-{
		return $wnd.ol.tilegrid.createXYZ(tileGridOptions);
    }-*/;

    public static native Tile createTileLayer(LayerOptions layerOptions)
    /*-{
		return new $wnd.ol.layer.Tile(layerOptions);
    }-*/;

    /** View **/

    public static native View createView()
    /*-{
		return new $wnd.ol.View();
    }-*/;

    public static native View createView(ViewOptions viewOptions)
    /*-{
		return new $wnd.ol.View(viewOptions);
    }-*/;

    public static native Xyz createXyz(XyzOptions xyzOptions)
    /*-{
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

    public static native ZoomSlider createZoomSlider()
    /*-{
		return new $wnd.ol.control.ZoomSlider();
    }-*/;

    public static native ZoomToExtent createZoomToExtent()
    /*-{
		return new $wnd.ol.control.ZoomToExtent();
    }-*/;
}
