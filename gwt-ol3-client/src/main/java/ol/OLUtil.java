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
import ol.event.TileLoadEndListener;
import ol.event.TileLoadErrorListener;
import ol.event.TileLoadStartListener;
import ol.geom.Geometry;
import ol.geom.Polygon;
import ol.geom.SimpleGeometryCoordinates;
import ol.gwt.CollectionWrapper;
import ol.layer.Base;
import ol.layer.Layer;
import ol.proj.Projection;
import ol.source.Source;
import ol.source.Tile;
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

    /**
     * Radius equal to the semi-major axis of the normal ellipsoid (like
     * ol.sphere.NORMAL).
     */
    public static final double EARTH_RADIUS_NORMAL = 6370997;

    /**
     * Radius equal to the semi-major axis of the WGS84 ellipsoid (like
     * ol.sphere.WGS84).
     */
    public static final double EARTH_RADIUS_WGS84 = 6378137;

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
    public static HandlerRegistration addMapMoveListener(final Map map, final MapMoveListener listener) {
        // listen to "moveend" events of map
        final HandlerRegistration handlerMap = observe(map, "moveend", new EventListener<MapEvent>() {
            @Override
            public void onEvent(MapEvent event) {
                listener.onMapMove(event);
            }
        });
        // fire events while the map is moving
        // try to set up an event handler for the change of the view center
        // as "moveend" will be only fired when the map stops moving
        View view = map.getView();
        if(view != null) {
            final HandlerRegistration handlerView = OLUtil.observe(view, "change:center",
                    new EventListener<ObjectEvent>() {
                        @Override
                        public void onEvent(ObjectEvent event) {
                            // create an artificial move event
                            Event e2 = createLinkedEvent(event, "move", map);
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
        return observe(map.getView(), "propertychange", new EventListener<ObjectEvent>() {

            @Override
            public void onEvent(ObjectEvent event) {
                if("resolution".equals(event.getKey())) {
                    Event e2 = createLinkedEvent(event, "zoom", map);
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
     * @deprecated Use {@link ol.proj.Projection#addEquivalentProjections(Projection[])} instead.
     */
    @Deprecated
    public static void addEquivalentProjections(Projection[] projections) {
		Projection.addEquivalentProjections(projections);
    };

    /**
     * Add a Projection object to the list of supported projections that can be
     * looked up by their code.
     *
     * @param projection
     *            Projection instance.
     * @deprecated Use {@link ol.proj.Projection#addProjection(Projection)} instead.
     */
    @Deprecated
    public static void addProjection(Projection projection) {
        Projection.addProjection(projection);
    };

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
        return observe(source, "tileloaderror", new EventListener<Tile.Event>() {

            @Override
            public void onEvent(Tile.Event event) {
                listener.onTileLoadError(event);
            }
        });
    }

	/**
	 * Adds a listener for tile start loading.
	 *
	 * @param source
	 *            source
	 *
	 * @param listener
	 *            {@link TileLoadStartListener}
	 * @return {@link HandlerRegistration}
	 */
	public static HandlerRegistration addTileLoadStartListener(UrlTile source, final TileLoadStartListener listener) {
		return observe(source, "tileloadstart", new EventListener<Tile.Event>() {

			@Override
			public void onEvent(Tile.Event event) {
				listener.onTileLoadStart(event);
			}
		});
	}

	/**
	 * Adds a listener for tile end loading.
	 *
	 * @param source
	 *            source
	 *
	 * @param listener
	 *            {@link TileLoadEndListener}
	 * @return {@link HandlerRegistration}
	 */
	public static HandlerRegistration addTileLoadEndListener(UrlTile source, final TileLoadEndListener listener) {
		return observe(source, "tileloadend", new EventListener<Tile.Event>() {

			@Override
			public void onEvent(Tile.Event event) {
				listener.onTileLoadEnd(event);
			}
		});
	}

    /**
     * Create an approximation of a circle on the surface of a sphere.
     * @param sphere
     *            The sphere.
     * @param center
     *            Center (`[lon, lat]` in degrees).
     * @param radius
     *            The great-circle distance from the center to the polygon
     *            vertices.
     * @param opt_n
     *            Optional number of vertices for the resulting polygon. Default
     *            is `32`.
     * @return {ol.geom.Polygon} The "circular" polygon.
     */
    public static native Polygon circular(Sphere sphere, ol.Coordinate center, double radius, int opt_n) /*-{
        return $wnd.ol.geom.Polygon.circular(sphere, center, radius, opt_n);
    }-*/;

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
     * @deprecated Use functional interfaces {@link jsinterop.annotations.JsFunction} instead.
     */
    @Deprecated
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
     * @param <T>
     *            type of the event
     * @param <U>
     *            type of the target
     */
    public static native <T extends Event, U> T createLinkedEvent(T eParent, String type, U currentTarget) /*-{
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
     * Creates a sphere with radius equal to the semi-major axis of the WGS84
     * ellipsoid.
     * @return {@link Sphere}
     */
    public static Sphere createSphereWGS84() {
        return OLFactory.createSphere(EARTH_RADIUS_WGS84);
    }

    /**
     * Creates a sphere with radius equal to the semi-major axis of the normal
     * ellipsoid.
     * @return {@link Sphere}
     */
    public static Sphere createSphereNormal() {
        return OLFactory.createSphere(EARTH_RADIUS_NORMAL);
    }

    /**
     * Checks if two projections are the same, that is every coordinate in one
     * projection does represent the same geographic point as the same
     * coordinate in the other projection.
     *
     * @param projection1
     *            Projection 1.
     * @param projection2
     *            Projection 2.
     * @return {boolean} Equivalent.
     */
    public static native boolean equivalent(ol.proj.Projection projection1, ol.proj.Projection projection2) /*-{
      return $wnd.ol.proj.equivalent(projection1, projection2);
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
        return Math.cos(latitude * Math.PI / 180) * 2 * Math.PI * EARTH_RADIUS_WGS84 / getMapSizeInPixels(zoomLevel);
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
     * @return {@link ol.proj.Projection} Projection object, or null if not in list.
     * @deprecated Use {@link ol.proj.Projection#get(String)} instead.
     */
    @Deprecated
    public static Projection getProjection(String projectionCode) {
        return Projection.get(projectionCode);
    }

    /**
     * Gets a {@link TileGrid} from the given object, if the property is set
     *
     * @param o
     *            {@link ol.source.Source}
     * @return {@link TileGrid} on success, else null
     */
    private static native TileGrid getTileGrid(ol.source.Source o) /*-{
		return o.tileGrid || null;
    }-*/;

    /**
     *
     * @param extent
     * @return width of extent
     */
    public static native double getWidth(Extent extent) /*-{
        return $wnd.ol.extent.getWidth(extent);
    }-*/;

    /**
    *
    * @param extent
    * @return top left coordinate of the extent
    */
   public static native Coordinate getTopLeft(Extent extent) /*-{
       return $wnd.ol.extent.getTopLeft(extent);
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
                TileGrid tg = getTileGrid(source);
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
     * Returns the geodesic area in square meters of the given geometry using
     * the haversine formula.
     *
     * @param geom
     *            geometry.
     * @return geodesic area on success, else {@link Double#NaN}
     */
    public static double geodesicArea(Polygon geom) {
        // get coordinates and check that there are at least 2
        Coordinate[][] coordinates = geom.getCoordinates();
        if((coordinates != null) && (coordinates.length > 0)) {
            // get area of outer ring
            double area = geodesicArea(coordinates[0]);
            // walk through inner rings
            for(int i = 1; i < coordinates.length; i++) {
                // if area is valid, subtract it from the outer ring's area
                double holeArea = geodesicArea(coordinates[i]);
                if(!Double.isNaN(holeArea)) {
                    area -= holeArea;
                }
            }
            return area;
        }
        return Double.NaN;
    }

    /**
     * Returns the geodesic area in square meters of the given geometry using
     * the haversine formula.
     *
     * @param coordinates
     *            coordinates.
     * @return geodesic area on success, else {@link Double#NaN}
     */
    private static double geodesicArea(Coordinate[] coordinates) {
        // check that there are at least 2
        if((coordinates != null) && (coordinates.length > 1)) {
            Sphere sphere = createSphereNormal();
            // only return positive area
            return Math.abs(sphere.geodesicArea(coordinates));
        }
        return Double.NaN;
    }

    /**
     * Returns the geodesic length in meters of the given geometry using the
     * haversine formula.
     *
     * @param geom
     *            geometry.
     * @return geodesic length on success, else {@link Double#NaN}
     */
    public static double geodesicLength(SimpleGeometryCoordinates geom) {
        // get coordinates and check that there are at least 2
        Coordinate[] coordinates = geom.getCoordinates();
        if((coordinates != null) && (coordinates.length > 1)) {
            // calculate the distance on every segment of the line and add it up
            Sphere sphere = createSphereNormal();
            double distance = 0;
            for(int i = 0; i <= coordinates.length - 2; i++) {
                Coordinate c1 = coordinates[i];
                Coordinate c2 = coordinates[i + 1];
                distance += sphere.haversineDistance(c1, c2);
            }
            return distance;
        }
        return Double.NaN;
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
        TileGridOptions tileGridOptions = OLFactory.<TileGridOptions> createOptions();
        tileGridOptions.setMinZoom(minZoomLevel);
        tileGridOptions.setMaxZoom(maxZoomLevel);
        options.setTileGrid(OLFactory.createTileGridXYZ(tileGridOptions));
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
        JavaScriptObject key = o.on(eventType, listener);
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
        JavaScriptObject key = o.once(eventType, listener);
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
     * Set the style for the feature. This can be a single style object, an
     * array of styles, or a function that takes a resolution and returns an
     * array of styles. If it is `null` the feature has no style (a `null`
     * style).
     *
     * @param f
     *            {@link ol.Feature}
     * @param style
     *            Style for this feature.
     */
    public static native void setStyle(ol.Feature f, @Nullable ol.style.Style[] style) /*-{
        f.setStyle(style);
    }-*/;

    /**
     * Set the style for features. This can be a single style object, an array
     * of styles, or a function that takes a feature and resolution and returns
     * an array of styles. If it is `undefined` the default style is used. If it
     * is `null` the layer has no style (a `null` style), so only features that
     * have their own styles will be rendered in the layer. See {@link ol.style}
     * for information on the default style.
     *
     * @param l
     *            Layer
     * @param style
     *            Layer style.
     */
    public static native void setStyle(ol.layer.Vector l, @Nullable ol.style.Style[] style) /*-{
        l.setStyle(style);
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
     * @deprecated Use {@link ol.proj.Projection#transform(Coordinate, Projection, Projection)} instead.
     */
    @Deprecated
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
     * @deprecated Use {@link ol.proj.Projection#transform(Coordinate, String, String)} instead.
     */
    @Deprecated
    public static Coordinate transform(Coordinate coordinate, String source, String destination) {
        return Projection.transform(coordinate, source, destination);
    }

    /**
     * Transforms coordinates from source projection to destination projection.
     * This returns new coordinates (and does not modify the original).
     *
     * @param coordinates
     *            coordinates to transform
     * @param source
     *            source projection
     * @param destination
     *            destination projection
     * @return transformed coordinates
     */
    public static Coordinate[] transform(Coordinate[] coordinates, String source, String destination) {

        Coordinate[] transformedCoordinates = new Coordinate[coordinates.length];

        for(int i = 0; i < coordinates.length; i++) {
            transformedCoordinates[i] = Projection.transform(coordinates[i], source, destination);
        }

        return transformedCoordinates;
    }

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
     * @deprecated Use {@link ol.proj.Projection#transformExtent(Extent, Projection, Projection)} instead.
     */
    @Deprecated
    public static Extent transformExtent(Extent extent, Projection source, Projection destination) {
		return Projection.transformExtent(extent, source, destination);
    };

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
     * @deprecated Use {@link ol.proj.Projection#transformExtent(Extent, String, String)} instead.
     */
    @Deprecated
    public static Extent transformExtent(Extent extent, String source, String destination) {
		return Projection.transformExtent(extent, source, destination);
    };

}
