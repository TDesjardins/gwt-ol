package ol;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

import ol.event.ClickListener;
import ol.event.DoubleClickListener;
import ol.event.Event;
import ol.event.EventListener;
import ol.event.MapMoveListener;
import ol.event.MapZoomListener;
import ol.event.OLHandlerRegistration;
import ol.event.TileLoadErrorListener;
import ol.geom.Geometry;
import ol.gwt.CollectionWrapper;
import ol.layer.Base;
import ol.layer.Layer;
import ol.proj.Projection;
import ol.source.Source;
import ol.source.TileEvent;
import ol.source.UrlTile;
import ol.source.Xyz;
import ol.source.XyzOptions;
import ol.style.Style;
import ol.tilegrid.TileGrid;
import ol.tilegrid.TileGridOptions;

/**
 * Utility functions.
 *
 * @author sbaumhekel
 */
@ParametersAreNonnullByDefault
public final class OLUtil {

    private static final double EARTH_RADIUS = 6378137;

    // prevent instantiating this class
    @Deprecated
    private OLUtil() {
        throw new AssertionError();
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
        if(singleClicksOnly) {
            type = MapBrowserEvent.SINGLECLICK;
        } else {
            type = MapBrowserEvent.CLICK;
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
        return observe(map, MapBrowserEvent.DBLCLICK, new EventListener<MapBrowserEvent>() {

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
        // default is true to track all changes to the map position immediately
        return addMapMoveListener(map, listener, true);
    }

    /**
     * Adds a map move listener for the given map.
     *
     * @param map
     *            {@link Map}
     * @param listener
     *            {@link MapMoveListener}
     * @param immediate
     *            Fire events while the map is moving? If set to false only one
     *            event will be fired after the map has finished moving.
     * @return {@link HandlerRegistration}
     */
    public static HandlerRegistration addMapMoveListener(final Map map, final MapMoveListener listener,
            boolean immediate) {
        // listen to "moveend" events of map
        final HandlerRegistration handlerMap = observe(map, MapEvent.MOVEEND, new EventListener<MapEvent>() {
            @Override
            public void onEvent(MapEvent event) {
                listener.onMapMove(event);
            }
        });
        // fire events while the map is moving?
        if(immediate) {
            // try to set up an event handler for the change of the view center
            // as "moveend" will be only fired when the map stops moving
            View view = map.getView();
            if(view != null) {
                final HandlerRegistration handlerView = OLUtil.observe(view, "change:center",
                        new EventListener<ObjectEvent>() {
                            @Override
                            public void onEvent(ObjectEvent event) {
                                // create an artificial move event
                                Event e2 = createLinkedEvent(event, "move", (JavaScriptObject)map);
                                MapEvent me = initMapEvent(e2, map);
                                listener.onMapMove(me);
                            }
                        });
                // return a handler registration, which detaches both event
                // handlers
                return new HandlerRegistration() {
                    @Override
                    public void removeHandler() {
                        handlerMap.removeHandler();
                        handlerView.removeHandler();
                    }
                };
            }
        }
        // just return the map handler
        return handlerMap;
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
                if("resolution".equals(event.getKey())) {
                    Event e2 = createLinkedEvent(event, "zoom", (JavaScriptObject)map);
                    MapEvent me = initMapEvent(e2, map);
                    listener.onMapZoom(me);
                }
            }
        });
    }

    /**
     * Registers transformation functions that don't alter coordinates. Those allow
     * to transform between projections with equal meaning.
     *
     * @param projections Projections.
     */
    public static native void addEquivalentProjections(Projection[] projections) /*-{
		$wnd.ol.proj.addEquivalentProjections(projections);
    }-*/;
    
    /**
     * Add a Projection object to the list of supported projections that can be
     * looked up by their code.
     *
     * @param projection
     *            Projection instance.
     */
    public static native void addProjection(Projection projection) /*-{
		$wnd.ol.proj.addProjection(projection);
    }-*/;

    /**
     * Adds a {@link Style} to the given array of {@link Style}s.
     *
     * @param s
     *            array of {@link Style}s (will be changed)
     * @param s2
     *            {@link Style}
     * @return the changed array
     */
    public static native ol.style.Style[] addStyle(ol.style.Style[] s, ol.style.Style s2) /*-{
		s.push(s2);
		return s;
    }-*/;

    /**
     * Combines two arrays of {@link Style}s.
     *
     * @param s
     *            array of {@link Style}s 1
     * @param s2
     *            array of {@link Style}s 2
     * @return the combined array
     */
    public static native ol.style.Style[] addStyles(ol.style.Style[] s, ol.style.Style[] s2) /*-{
		return s.concat(s2);
    }-*/;

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
     * Combines two {@link Style}s into an array of {@link Style}s.
     *
     * @param s1
     *            {@link Style} 1
     * @param s2
     *            {@link Style} 2
     * @return array of {@link Style}s
     */
    public static native ol.style.Style[] combineStyles(ol.style.Style s1, ol.style.Style s2) /*-{
		return [ s1, s2 ];
    }-*/;

    /**
     * Creates a JavaScript function calling the given event listener.
     *
     * @param listener
     *            listener
     * @return JavaScript function
     */
    public static native <E extends Event> JavaScriptObject createEventListenerFunction(EventListener<E> listener) /*-{
		return function(evt) {
			listener.onEvent(evt);
		};
    }-*/;

    /**
     * Links to {@link Event}s by delegating the childs methods to the parents
     * methods.
     *
     * @param eParent
     *            parent {@link Event} (is not changed)
     * @param type
     *            type of the event
     * @param currentTarget
     *            current target of the child event
     * @return child {@link Event} (gets its methods linked to the parent event)
     */
    public static native Event createLinkedEvent(Event eParent, String type, JavaScriptObject currentTarget) /*-{
		var eChild = {};
		eChild.preventDefault = function() {
			eParent.preventDefault();
			eChild.defaultPrevented = eParent.defaultPrevented;
		};
		eChild.stopPropagation = function() {
			eParent.stopPropagation();
		};
		eChild.currentTarget = currentTarget;
		eChild.defaultPrevented = eParent.defaultPrevented;
		eChild.target = eParent.target;
		eChild.type = type;
		return eChild;
    }-*/;

    /**
     * Checks if two projections are the same, that is every coordinate in one
     * projection does represent the same geographic point as the same
     * coordinate in the other projection. (Taken from proj.js source of
     * 'ol.proj.equivalent' as it is not part of the official API but still
     * useful for identifying equal projections).
     *
     * @param projection1
     *            Projection 1.
     * @param projection2
     *            Projection 2.
     * @return {boolean} Equivalent.
     */
    public static native boolean equivalent(ol.proj.Projection projection1, ol.proj.Projection projection2) /*-{
      if (projection1 === projection2) {
        return true;
      }
      var equalUnits = projection1.getUnits() === projection2.getUnits();
      if (projection1.getCode() === projection2.getCode()) {
        return equalUnits;
      } else {
        var transformFn = ol.proj.getTransformFromProjections(
            projection1, projection2);
        return transformFn === ol.proj.cloneTransform && equalUnits;
      }
    }-*/;
    
    /**
     * Gets the geometry layout string for the given dimension.
     *
     * @param dim
     *            dimension (i.e. 2 or 3)
     * @return geometry layout string
     */
    public static String getGeometryLayout(int dim) {
        if(dim > 2) {
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
        if(measure) {
            if(dim > 2) {
                return "XYZM";
            }
            return "XYM";
        } else {
            if(dim > 2) {
                return "XYZ";
            }
            return "XY";
        }
    }

    /**
     * Determines the ground resolution (in meters per pixel) at a specified
     * latitude and level of detail.
     *
     * @param latitude
     *            latitude
     * @param zoomLevel
     *            zoomlevel
     * @return ground resolution
     */
    public static double getGroundResolutionInMeters(double latitude, int zoomLevel) {
        return Math.cos(latitude * Math.PI / 180) * 2 * Math.PI * EARTH_RADIUS / getMapSizeInPixels(zoomLevel);
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
        for(Base l : layers) {
            if(name.equals(getName(l))) {
                return l;
            }
        }
        return null;
    }

    /**
     * Determines the map width and height (in pixels) at a specified level of
     * detail.
     *
     * @param zoomLevel
     *            Level of detail, from 1 (lowest detail) to 23 (highest
     *            detail).
     * @return The map width and height in pixels.
     */
    public static double getMapSizeInPixels(int zoomLevel) {
        return ((double)(1 << zoomLevel)) * 256;
    }

    /**
     * Gets the maximum zoomlevel of the given layer.
     *
     * @param layer
     *            layer
     * @return zoomlevel on success, else -1
     */
    public static int getMaxZoomLevel(Base layer) {
        // get source if layer instance has it
        Source source = layer.get("source");
        if(source != null) {
            // try to get a tilegrid from the source
            TileGrid tg = getTileGrid((JavaScriptObject)source);
            if(tg != null) {
                return tg.getMaxZoom();
            }
        }
        return -1;
    }
    
    /**
     * Gets the minimum zoomlevel of the given layer.
     *
     * @param layer
     *            layer
     * @return zoomlevel on success, else -1
     */
    public static int getMinZoomLevel(Base layer) {
        // get source if layer instance has it
        Source source = layer.get("source");
        if(source != null) {
            // try to get a tilegrid from the source
            TileGrid tg = getTileGrid((JavaScriptObject)source);
            if(tg != null) {
                return tg.getMinZoom();
            }
        }
        return -1;
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
     * Fetches a Projection object for the code specified.
     *
     * @param projectionCode
     *            Either a code string which is a combination of authority and
     *            identifier such as "EPSG:4326", or an existing projection
     *            object, or undefined.
     * @return {ol.proj.Projection} Projection object, or null if not in list.
     */
    public static native Projection getProjection(String projectionCode) /*-{
		return $wnd.ol.proj.get(projectionCode);
    }-*/;

    /**
     * Gets a {@link TileGrid} from the given object, if the property is set
     *
     * @param o
     *            {@link JavaScriptObject}
     * @return {@link TileGrid} on success, else null
     */
    private static native TileGrid getTileGrid(JavaScriptObject o) /*-{
		return o.tileGrid || null;
    }-*/;

    /**
     * Gets the current zoom level of the given {@link View}.
     *
     * @param v
     *            {@link View}
     * @return Zoom on success, else -1
     */
    private static native int getZoom(View v) /*-{
		return v.getZoom() || -1;
    }-*/;

    /**
     * Gets the current zoomlevel of the given {@link Map}.
     *
     * @param map
     *            {@link Map}
     * @return zoomlevel on success, else -1
     */
    public static int getZoomLevel(Map map) {
        View v = map.getView();
        // try to get zoom
        int z = getZoom(v);
        if(z >= 0) {
            return z;
        }
        // zoom is undefined, so check resolution
        double zoomResolution = v.getResolution();
        // walk layers to find resolution
        CollectionWrapper<Base> layers = new CollectionWrapper<Base>(map.getLayers());
        for(Base l : layers) {
            // get source if layer instance has it
            Source source = l.get("source");
            if(source != null) {
                // try to get a tilegrid from the source
                TileGrid tg = getTileGrid((JavaScriptObject)source);
                if(tg != null) {
                    // check resolutions
                    double[] resolutions = tg.getResolutions();
                    if(resolutions != null) {
                        double dPreviousResolution = 0;
                        for(int i = 0; i < resolutions.length; i++) {
                            // resolutions are sorted in descending order, so
                            // compare with actual one
                            double resolution = resolutions[i];
                            if(resolution <= zoomResolution) {
                                if(i > 1) {
                                    // check to which zoomlevel resolution is
                                    // nearer and prefer the larger number by
                                    // (75%:25%=3)
                                    if((zoomResolution - resolution) / (dPreviousResolution - zoomResolution) < 3) {
                                        return i;
                                    } else {
                                        return i - 1;
                                    }
                                } else {
                                    return 0;
                                }
                            }
                            dPreviousResolution = resolution;
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Initializes a {@link MapEvent}, can be used for creating a new
     * {@link MapEvent} as it does not work with ol.js in release mode using the
     * OpenLayers API.
     *
     * @param e
     *            base {@link Event}
     * @param map
     *            {@link Map}
     * @return {@link MapEvent}
     */
    public static native MapEvent initMapEvent(Event e, Map map) /*-{
		e.map = map;
		e.framestate = null;
		return e;
    }-*/;

    /**
     * Limits the zoomlevels of the {@link Xyz} layer source created of the
     * given {@link XyzOptions}.
     *
     * @param options
     *            {@link XyzOptions}
     * @param minZoomLevel
     *            minimum zoomlevel (0-28)
     * @param maxZoomLevel
     *            maximum zoomlevel (0-28)
     */
    public static void limitZoomLevels(XyzOptions options, int minZoomLevel, int maxZoomLevel) {
        options.setTileGrid(OLFactory.createTileGridXYZ(
                OLFactory.<TileGridOptions> createOptions().setMinZoom(minZoomLevel).setMaxZoom(maxZoomLevel)));
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
     * Sets the container for the given {@link Map} to the given {@link Widget}.
     *
     * @param map
     *            {@link Map}
     * @param target
     *            {@link Widget}
     */
    public static void setMapTarget(Map map, Widget target) {
        map.setTarget(OLFactory.<Element, String> createObject1(target.getElement()));
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

    /**
     * Transforms a coordinate from source projection to destination projection.
     * This returns a new coordinate (and does not modify the original).
     *
     * See {@link #transformExtent(Extent, Projection, Projection)} for extent
     * transformation. See the transform method of {@link ol.geom.Geometry} and
     * its subclasses for geometry transforms.
     *
     * @param coordinate
     *            Coordinate.
     * @param source
     *            Source projection-like.
     * @param destination
     *            Destination projection-like.
     * @return {ol.Coordinate} Coordinate.
     */
    public static native Coordinate transform(Coordinate coordinate, Projection source, Projection destination) /*-{
		return $wnd.ol.proj.transform(coordinate, source, destination);
    }-*/;

    /**
     * Transform each coordinate of the geometry from one coordinate reference
     * system to another. The geometry is modified in place. For example, a line
     * will be transformed to a line and a circle to a circle. If you do not
     * want the geometry modified in place, first clone() it and then use this
     * function on the clone.
     *
     * @param geom {@link Geometry}
     *
     * @param source
     *            The current projection. Can be a string identifier or a
     *            {@link ol.proj.Projection} object.
     * @param destination
     *            The desired projection. Can be a string identifier or a
     *            {@link ol.proj.Projection} object.
     * @return {@link Geometry} This geometry. Note that original geometry is
     *         modified in place.
     */
    public static native Geometry transform(Geometry geom, Projection source, Projection destination) /*-{
		return geom.transform(source, destination);
    }-*/;
    
    /**
     * Transforms a coordinate from source projection to destination projection.
     * This returns a new coordinate (and does not modify the original).
     *
     * See {@link #transformExtent(Extent, Projection, Projection)} for extent
     * transformation. See the transform method of {@link ol.geom.Geometry} and
     * its subclasses for geometry transforms.
     *
     * @param coordinate
     *            Coordinate.
     * @param source
     *            Source projection-like.
     * @param destination
     *            Destination projection-like.
     * @return {ol.Coordinate} Coordinate.
     */
    public static native Coordinate transform(Coordinate coordinate, String source, String destination) /*-{
		return $wnd.ol.proj.transform(coordinate, source, destination);
    }-*/;

    /**
     * Transforms an extent from source projection to destination projection.
     * This returns a new extent (and does not modify the original).
     *
     * @param extent
     *            The extent to transform.
     * @param source
     *            Source projection-like.
     * @param destination
     *            Destination projection-like.
     * @return {ol.Extent} The transformed extent.
     */
    public static native Extent transformExtent(Extent extent, Projection source, Projection destination) /*-{
		return $wnd.ol.proj.transformExtent(extent, source, destination);
    }-*/;

    /**
     * Transforms an extent from source projection to destination projection.
     * This returns a new extent (and does not modify the original).
     *
     * @param extent
     *            The extent to transform.
     * @param source
     *            Source projection-like.
     * @param destination
     *            Destination projection-like.
     * @return {ol.Extent} The transformed extent.
     */
    public static native Extent transformExtent(Extent extent, String source, String destination) /*-{
		return $wnd.ol.proj.transformExtent(extent, source, destination);
    }-*/;

}
