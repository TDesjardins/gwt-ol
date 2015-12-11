package ol;

import javax.annotation.*;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;

import ol.event.*;
import ol.gwt.*;
import ol.layer.*;
import ol.source.*;

/**
 * Utility functions.
 *
 * @author sbaumhekel
 */
@ParametersAreNonnullByDefault
public final class OLUtil {

    // prevent instantiating this class
    @Deprecated
    private OLUtil() {
    }

    /**
     * Adds a click listener for the given map.
     *
     * @param map
     *            {@link Map}
     * @param singleClicksOnly
     *            wait fortrue single click with no dragging and no double
     *            click? Note that this event is delayed by 250 ms to ensure
     *            that it is not a double click.
     * @param listener
     *            {@link ClickListener}
     * @return {@link HandlerRegistration}
     */
    public static HandlerRegistration addClickListener(Map map, boolean singleClicksOnly,
	    final ClickListener listener) {
	String type;
	if (singleClicksOnly) {
	    type = "singleclick";
	} else {
	    type = "click";
	}
	return observe(map, type, new EventListener<MapBrowserEvent>() {

	    @Override
	    public void onEvent(MapBrowserEvent event) {
		listener.onClick(event);
	    }
	});
    }

    /**
     * Adds a click listener for the given map.
     *
     * @param map
     *            {@link Map}
     * @param listener
     *            {@link DoubleClickListener}
     * @return {@link HandlerRegistration}
     */
    public static HandlerRegistration addDoubleClickListener(Map map, final DoubleClickListener listener) {
	return observe(map, "dblclick", new EventListener<MapBrowserEvent>() {

	    @Override
	    public void onEvent(MapBrowserEvent event) {
		listener.onDoubleClick(event);
	    }
	});
    }

    /**
     * Adds a map move listener for the given map.
     *
     * @param map
     *            {@link Map}
     * @param listener
     *            {@link MapMoveListener}
     * @return {@link HandlerRegistration}
     */
    public static HandlerRegistration addMapMoveListener(Map map, final MapMoveListener listener) {
	return observe(map, "moveend", new EventListener<MapEvent>() {

	    @Override
	    public void onEvent(MapEvent event) {
		listener.onMapMove(event);
	    }
	});
    }

    /**
     * Adds a map zoom listener for the given map.
     *
     * @param map
     *            {@link Map}
     * @param listener
     *            {@link MapZoomListener}
     * @return {@link HandlerRegistration}
     */
    public static HandlerRegistration addMapZoomListener(final Map map, final MapZoomListener listener) {
	return observe(map.getView(), ObjectEvent.TYPE, new EventListener<ObjectEvent>() {

	    @Override
	    public void onEvent(ObjectEvent event) {
		if ("resolution".equals(event.getKey())) {
		    listener.onMapZoom(new MapEventWrapper(map, "zoom", event));
		}
	    }
	});
    }

    /**
     * Adds a listener for tile loading errors.
     * 
     * @param source
     *            source
     *
     * @param listener
     *            {@link TileLoadErrorListener}
     * @return {@link HandlerRegistration}
     */
    public static HandlerRegistration addTileLoadErrorListener(UrlTile source, final TileLoadErrorListener listener) {
	return observe(source, "tileloaderror", new EventListener<TileEvent>() {

	    @Override
	    public void onEvent(TileEvent event) {
		listener.onTileLoadError(event);
	    }
	});
    }

    /**
     * Creates a JavaScript function calling the given event listener.
     *
     * @param listener
     *            listener
     * @return JavaScript function
     */
    public static native <E extends Event> JavaScriptObject createEventListenerFunction(EventListener<E> listener)
    /*-{
		return function(evt) {
			listener.onEvent(evt);
		};
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
     * Gets a layer by the given name.
     *
     * @param map
     *            {@link Map}
     * @param name
     *            name of the layer
     * @return {@link Layer} on success, else null
     */
    @Nullable
    public static Base getLayerByName(Map map, String name) {
	CollectionWrapper<Base> layers = new CollectionWrapper<Base>(map.getLayers());
	for (Base l : layers) {
	    if (name.equals(getName(l))) {
		return l;
	    }
	}
	return null;
    }

    /**
     * Gets the name of the given {@link Layer}.
     *
     * @param layer
     *            {@link Layer}
     * @return name on success, else null
     */
    @Nullable
    public static String getName(Base layer) {
	return layer.get("name");
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
	JavaScriptObject handler = OLUtil.createEventListenerFunction(listener);
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
	JavaScriptObject handler = OLUtil.createEventListenerFunction(listener);
	JavaScriptObject key = o.once(eventType, handler);
	return new OLHandlerRegistration(o, key);
    }

    /**
     * Sets the name of the given {@link Layer}.
     *
     * @param layer
     *            {@link Layer}
     * @param name
     *            name
     */
    public static void setName(Base layer, String name) {
	layer.set("name", name);
    }

}
