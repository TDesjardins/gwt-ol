/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import elemental2.core.JsArray;
import jsinterop.base.Js;
import ol.event.EventListener;
import ol.event.OLHandlerRegistration;
import ol.events.Event;
import ol.geom.Polygon;
import ol.geom.SimpleGeometryCoordinates;
import ol.gwt.CollectionWrapper;
import ol.layer.Base;
import ol.layer.Layer;
import ol.proj.Projection;
import ol.source.Source;
import ol.source.Xyz;
import ol.source.XyzOptions;
import ol.sphere.Sphere;
import ol.sphere.SphereMetricOptions;
import ol.style.Style;
import ol.tilegrid.TileGrid;
import ol.tilegrid.XyzTileGridOptions;

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
     * Adds a {@link Style} to the given array of {@link Style}s.
     *
     * @param styles
     *            array of {@link Style}s (will be changed)
     * @param style
     *            {@link Style}
     * @return the changed array
     *
     * @deprecated Use {@link OLUtil#pushItem(T[], T)} instead
     */
    @Deprecated
    public static ol.style.Style[] addStyle(Style[] styles, Style style) {
        return pushItem(styles, style);
    };

    /**
     * Adds an item to the array.
     *
     * @param array array (will be changed)
     * @param item item to add
     * @return array including the item
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] pushItem(T[] array, T item) {
        JsArray<T> jsArray = Js.cast(array);
        jsArray.push(item);
        return array;
    }

    /**
     * Combines two arrays of {@link Style}s.
     *
     * @param array1
     *            first array of {@link Style}s
     * @param array2
     *            second array of {@link Style}s
     * @return the combined array
     *
     * @deprecated Use {@link OLUtil#concatArrays(T[], T[])} instead
     */
    @Deprecated
    public static ol.style.Style[] addStyles(Style[] array1, Style[] array2) {
        return concatArrays(array1, array2);
    };

    /**
     * Combines two arrays.
     *
     * @param array1 first array
     * @param array2 second array
     * @return combined array
     */
    public static <T> T[] concatArrays(T[] array1, T[] array2) {
        JsArray<T> jsArray = Js.cast(array1);
        return jsArray.concat(array2);
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
     *
     * @deprecated Use {@link ol.geom.Polygon#circular(Sphere, Coordinate, double, int)} instead.
     */
    @Deprecated
    public static Polygon circular(Sphere sphere, ol.Coordinate center, double radius, int opt_n) {
        return Polygon.circular(sphere, center, radius, opt_n);
    };

    /**
     * Combines two {@link Style}s into an array of {@link Style}s.
     *
     * @param s1
     *            {@link Style} 1
     * @param s2
     *            {@link Style} 2
     * @return array of {@link Style}s
     */
    public static Style[] combineStyles(Style s1, Style s2) {
        return new Style[] {s1, s2};
    };


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
     * Creates a sphere options with radius equal to the semi-major axis of the WGS84
     * ellipsoid.
     * @return {@link SphereMetricOptions}
     */
    public static SphereMetricOptions createSphereOptionsWGS84() {
        SphereMetricOptions sphereMetricOptions = new SphereMetricOptions();
        sphereMetricOptions.setRadius(EARTH_RADIUS_WGS84);
        return sphereMetricOptions;
    }

    /**
     * Creates a sphere options with radius equal to the semi-major axis of the normal
     * ellipsoid.
     * @return {@link SphereMetricOptions}
     */
    public static SphereMetricOptions createSphereOptionsNormal() {
        SphereMetricOptions sphereMetricOptions = new SphereMetricOptions();
        sphereMetricOptions.setRadius(EARTH_RADIUS_NORMAL);
        return sphereMetricOptions;
    }

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
        for(Base layer : layers) {
            if(name.equals(getName(layer))) {
                return layer;
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
     * Gets a {@link TileGrid} from the given object, if the property is set
     *
     * @param source
     *            {@link ol.source.Source}
     * @return {@link TileGrid} on success, else null
     */
    private static native TileGrid getTileGrid(ol.source.Source source) /*-{
		return source.tileGrid || null;
    }-*/;

    /**
     *
     * @param extent
     * @return width of extent
     *
     * @deprecated Use {@link ol.Extent#getWidth()} instead.
     */
    @Deprecated
    public static double getWidth(Extent extent) {
        return extent.getWidth();
    };

    /**
    *
    * @param extent
    * @return top left coordinate of the extent
    *
    * @deprecated Use {@link ol.Extent#getTopLeft()} instead.
    */
    @Deprecated
    public static Coordinate getTopLeft(Extent extent) {
        return extent.getTopLeft();
    };

    /**
     * Gets the current zoom level of the given {@link View}.
     * @param view
     *            {@link View}
     * @return Zoom on success, else {@link Double#NaN}
     */
    private static native double getZoom(View view) /*-{
	return view.getZoom() || NaN;
    }-*/;

    /**
     * Gets the current zoomlevel of the given {@link Map}.
     * @param map
     *            {@link Map}
     * @return zoomlevel on success, else {@link Double#NaN}
     */
    public static double getZoomLevel(Map map) {
        View v = map.getView();
        // try to get zoom
        double z = getZoom(v);
        if(!Double.isNaN(z)) {
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
                                    // calculate the delta of the resolution
                                    // compared to the current and the previous
                                    // zoomlevel
                                    double delta = (resolution - zoomResolution) / (dPreviousResolution - resolution);
                                    // adjust the integer zoomlevel to the delta
                                    return i + delta;
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
        return Double.NaN;
    }

    /**
     * Returns the geodesic area in square meters of the given geometry using
     * the haversine formula.
     *
     * @param geom
     *            geometry.
     * @return geodesic area
     */
    public static double geodesicArea(Polygon geom) {

        return Sphere.getArea(geom, createSphereOptionsNormal());
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
            double distance = 0;
            for(int i = 0; i <= coordinates.length - 2; i++) {
                Coordinate coordinate1 = coordinates[i];
                Coordinate coordinate2 = coordinates[i + 1];
                distance += Sphere.getDistance(coordinate1, coordinate2, createSphereOptionsNormal());
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
        XyzTileGridOptions tileGridOptions = OLFactory.createOptions();
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
        EventsKey key = o.on(eventType, listener);
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
        EventsKey key = o.once(eventType, listener);
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
        map.setTarget(target.getElement());
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
     * @param feature
     *            {@link ol.Feature}
     * @param style
     *            Style for this feature.
     *
     * @deprecated Use {@link ol.Feature#setStyles(Style[])} instead.
     */
    @Deprecated
    public static void setStyle(ol.Feature feature, @Nullable Style[] style) {
        feature.setStyles(style);
    };

    /**
     * Set the style for features. This can be a single style object, an array
     * of styles, or a function that takes a feature and resolution and returns
     * an array of styles. If it is `undefined` the default style is used. If it
     * is `null` the layer has no style (a `null` style), so only features that
     * have their own styles will be rendered in the layer. See {@link ol.style}
     * for information on the default style.
     *
     * @param vectorLayer
     *            Layer
     * @param style
     *            Layer style.
     *
     * @deprecated Use {@link ol.layer.Vector#setStyles(Style[])} instead.
     */
    @Deprecated
    public static void setStyle(ol.layer.Vector vectorLayer, @Nullable Style[] style) {
        vectorLayer.setStyles(style);
    };

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

}
