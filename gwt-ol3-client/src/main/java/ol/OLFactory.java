package ol;

import javax.annotation.Nullable;

import com.google.gwt.core.client.JsArray;

import ol.color.Color;
import ol.control.*;
import ol.geom.*;
import ol.interaction.*;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.*;
import ol.source.*;
import ol.style.*;

/**
 * Factory to create GWT-OL3 instances from JavaScript based on OL3-Interfaces.
 * Can be also done with GIN. When GWT supports Java 8 (hopefully in GWT 3.0)
 * factory methods can directly created in the interfaces.
 *
 * @author Tino Desjardins
 */
public class OLFactory {

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
     * Constructs an instance.
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
     * Constructs an instance.
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
     * Constructs an instance.
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

    /** Interactions **/

    public static native DragAndDrop createDragAndDrop()
    /*-{
		return new $wnd.ol.interaction.DragAndDrop();
    }-*/;

    /**
     * Creates an extent.
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
    public static native FillOptions createFillOptions()
    /*-{
		return {};
    }-*/;

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

    public static native LayerOptions createLayerOptions()
    /*-{
		return {};
    }-*/;

    /**
     * Constructs an instance.
     *
     * @param coordinates
     *            coordinates
     * @param geometryLayout
     *            geometry layout
     * @return {@link LineString}
     */
    public static native LineString createLineString(@Nullable JsArray<Coordinate> coordinates,
	    @Nullable String geometryLayout)
	    /*-{
		return $wnd.ol.geom.LineString(coordinates, geometryLayout);
    }-*/;

    /** Map **/

    public static native Map createMap(MapOptions mapOptions)
    /*-{
		return new $wnd.ol.Map(mapOptions);
    }-*/;

    /**
     * Creates a new {@link MapEvent}.
     *
     * @param type
     *            type
     * @param map
     *            {@link Map}
     * @return {@link MapEvent}
     */
    public static native MapEvent createMapEvent(String type, Map map)
    /*-{
		return new $wnd.ol.MapEvent(type, map);
    }-*/;

    public static native MapOptions createMapOptions()
    /*-{
		return {};
    }-*/;

    public static native MapQuestOptions createMapQuestOptions()
    /*-{
		return {};
    }-*/;

    public static native MapQuest createMapQuestSource(MapQuestOptions mapQuestOptions)
    /*-{
		return new $wnd.ol.source.MapQuest(mapQuestOptions);
    }-*/;

    public static native MousePosition createMousePosition()
    /*-{
		return new $wnd.ol.control.MousePosition();
    }-*/;

    /**
     * Creates a common object for options.
     *
     * @return common options object
     */
    public static native <T> T createOptions()
    /*-{
		return {};
    }-*/;

    /**
     * Creates a common object for params.
     *
     * @return common params object
     */
    public static native <T> T createParams()
    /*-{
		return {};
    }-*/;

    /**
     * Constructs an instance.
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

    /** Common **/

    /**
     * Constructs an instance.
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
     * Constructs an instance.
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
     * Constructs an instance.
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
     * Creates a size
     *
     * @param width
     * @param height
     * @return size
     */
    public static native int[] createSize(int width, int height)
    /*-{
		return [ width, height ];
    }-*/;

    public static native StamenOptions createStamenOptions()
    /*-{
		return {};
    }-*/;

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
    public static native StrokeOptions createStrokeOptions()
    /*-{
		return {};
    }-*/;

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
    public static native StyleOptions createStyleOptions()
    /*-{
		return {};
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

    public static native ZoomSlider createZoomSlider()
    /*-{
		return new $wnd.ol.control.ZoomSlider();
    }-*/;

    public static native ZoomToExtent createZoomToExtent()
    /*-{
		return new $wnd.ol.control.ZoomToExtent();
    }-*/;
}
