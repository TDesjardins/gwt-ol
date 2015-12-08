package ol;

import javax.annotation.Nullable;

import com.google.gwt.core.client.*;
import com.google.gwt.event.shared.HandlerRegistration;

import ol.control.*;
import ol.event.*;
import ol.geom.*;
import ol.interaction.*;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.*;
import ol.source.*;

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
     * Creates a JavaScript function calling the given event listener.
     * 
     * @param listener
     *            listener
     * @return JavaScript function
     */
    public static native <E extends Event> JavaScriptObject createEventListenerFunction(EventListener<E> listener)
    /*-{
     return function(evt){
     listener.onEvent(evt);
     };
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

    /** Common **/

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
	return createPoint(createCoordinate(x, y), getGeometryLayout(2));
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
	return createPoint(createCoordinate(x, y, z), getGeometryLayout(3));
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

    /**
     * Gets the geometry layout string for the given dimension.
     *
     * @param dim
     *            dimension (i.e. 2 or 3)
     * @return geometry layout string
     */
    public static String getGeometryLayout(int dim) {
	if (dim > 2) {
	    return "XYZ";
	}
	return "XY";
    }

    /**
     * Gets the geometry layout string for the given dimension.
     *
     * @param dim
     *            dimension (i.e. 2 or 3)
     * @param measure
     *            include measure 'M' coordinate?
     * @return geometry layout string
     */
    public static String getGeometryLayout(int dim, boolean measure) {
	if (measure) {
	    if (dim > 2) {
		return "XYZM";
	    }
	    return "XYM";
	} else {
	    if (dim > 2) {
		return "XYZ";
	    }
	    return "XY";
	}
    }

    /**
     * Registers the given event listener to listen for the given event type on
     * the given {@link Observable}.
     *
     * @param o
     *            {@link Observable}
     * @param eventType
     *            event type
     * @param listener
     *            listener
     * @return {@link HandlerRegistration}
     */
    public static <E extends Event> HandlerRegistration observe(Observable o, String eventType,
	    EventListener<E> listener) {
	JavaScriptObject handler = createEventListenerFunction(listener);
	JavaScriptObject key = o.on(eventType, handler);
	return new OLHandlerRegistration(o, key);
    }

    /**
     * Registers the given event listener to listen once for the given event
     * type on the given {@link Observable}.
     *
     * @param o
     *            {@link Observable}
     * @param eventType
     *            event type
     * @param listener
     *            listener
     * @return {@link HandlerRegistration}
     */
    public static <E extends Event> HandlerRegistration observeOnce(Observable o, String eventType,
	    EventListener<E> listener) {
	JavaScriptObject handler = createEventListenerFunction(listener);
	JavaScriptObject key = o.once(eventType, handler);
	return new OLHandlerRegistration(o, key);
    }
}
