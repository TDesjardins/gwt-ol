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
package ol.proj;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.Extent;

/**
 * Projection definition class. One of these is created for each projection
 * supported in the application and stored in the {@link ol.proj} namespace. You
 * can use these in applications, but this is not required, as API params and
 * options use {@link ol.proj.ProjectionLike} which means the simple string code
 * will suffice.
 *
 * You can use {@link ol.proj.Projection#get(String)} to retrieve the object for a particular
 * projection.
 *
 * The library includes definitions for `EPSG:4326` and `EPSG:3857`, together
 * with the following aliases: * `EPSG:4326`: CRS:84,
 * urn:ogc:def:crs:EPSG:6.6:4326, urn:ogc:def:crs:OGC:1.3:CRS84,
 * urn:ogc:def:crs:OGC:2:84, http://www.opengis.net/gml/srs/epsg.xml#4326,
 * urn:x-ogc:def:crs:EPSG:4326 * `EPSG:3857`: EPSG:102100, EPSG:102113,
 * EPSG:900913, urn:ogc:def:crs:EPSG:6.18:3:3857,
 * http://www.opengis.net/gml/srs/epsg.xml#3857
 *
 * If you use proj4js, aliases can be added using `proj4.defs()`; see
 * [documentation](https://github.com/proj4js/proj4js).
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Projection {

    @JsOverlay
    private static final String PACKAGE_PROJECTION = "ol.proj";

    public Projection(ProjectionOptions projectionOptions) {}
    
    /**
     * Get the code for this projection, e.g. 'EPSG:4326'.
     * 
     * @return {string} Code.
     */
    public native String getCode();

    /**
     * Get the validity extent for this projection.
     * 
     * @return {ol.Extent} Extent.
     */
    public native Extent getExtent();

    /**
     * Get the amount of meters per unit of this projection. If the projection
     * is not configured with `metersPerUnit` or a units identifier, the return
     * is `undefined`.
     * 
     * @return {number|undefined} Meters.
     */
    public native double getMetersPerUnit();

    /**
     * Get the resolution of the point in degrees or distance units. For
     * projections with degrees as the unit this will simply return the provided
     * resolution. The default for other projections is to estimate the point
     * resolution by transforming the 'point' pixel to EPSG:4326, measuring its
     * width and height on the normal sphere, and taking the average of the
     * width and height. An alternative implementation may be given when
     * constructing a projection. For many local projections, such a custom
     * function will return the resolution unchanged.
     * 
     * @param resolution
     *            Resolution in projection units.
     * @param point
     *            Point.
     * @return {number} Point resolution in projection units.
     */
    public native double getPointResolution(double resolution, ol.Coordinate point);

    /**
     * Get the units of this projection.
     * 
     * @return {ol.proj.Units} Units.
     */
    public native String getUnits();

    /**
     * Get the world extent for this projection.
     * 
     * @return {ol.Extent} Extent.
     */
    public native Extent getWorldExtent();

    /**
     * Is this projection a global projection which spans the whole world?
     * 
     * @return {boolean} Whether the projection is global.
     */
    public native boolean isGlobal();

    /**
     * Set if the projection is a global projection which spans the whole world
     * 
     * @param global
     *            Whether the projection is global.
     */
    public native void setGlobal(boolean global);

    /**
     * Set the validity extent for this projection.
     * 
     * @param extent
     *            Extent.
     */
    public native void setExtent(Extent extent);

    /**
     * Set the world extent for this projection.
     * 
     * @param worldExtent
     *            World extent [minlon, minlat, maxlon, maxlat].
     */
    public native void setWorldExtent(Extent worldExtent);

    /**
     * Registers transformation functions that don't alter coordinates. Those allow
     * to transform between projections with equal meaning.
     *
     * @param projections Projections.
     */
    @JsMethod(name = "addEquivalentProjections", namespace = PACKAGE_PROJECTION)
    public static native void addEquivalentProjections(Projection[] projections);
    
    /**
     * Add a Projection object to the list of supported projections that can be
     * looked up by their code.
     *
     * @param projection
     *            Projection instance.
     */
    @JsMethod(name = "addProjection", namespace = PACKAGE_PROJECTION)
    public static native void addProjection(Projection projection);
    
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
    @JsMethod(name = "equivalent", namespace = PACKAGE_PROJECTION)
    public static native boolean equivalent(ol.proj.Projection projection1, ol.proj.Projection projection2);
    
    
	/**
	 * 
	 * Transforms a coordinate from longitude/latitude to a different projection.
	 *
	 * @param coordinate
	 * @return transformed coordinate
	 */
	@JsMethod(name = "fromLonLat", namespace = PACKAGE_PROJECTION)
	public static native Coordinate fromLonLat(Coordinate coordinate);
	
	/**
     * 
     * Fetches a Projection object for the code specified.
     *
     * @param projectionCode combination of authority and identifier such as "EPSG:4326"
     * @return projection
     */
    @JsMethod(name = "get", namespace = PACKAGE_PROJECTION)
    public static native Projection get(String projectionCode);

	/**
	 * 
	 * Transforms a coordinate from source projection to destination projection.
	 * This returns a new coordinate (and does not modify the original).
	 *
	 * @param coordinate
	 * @param source
	 * @param target
	 * @return transformed coordinate
	 */
	@JsMethod(name = "transform", namespace = PACKAGE_PROJECTION)
	public static native Coordinate transform(Coordinate coordinate, String source, String target);
	
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
	@JsMethod(name = "transform", namespace = PACKAGE_PROJECTION)
    public static native Coordinate transform(Coordinate coordinate, Projection source, Projection destination);
	
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
	@JsMethod(name = "transformExtent", namespace = PACKAGE_PROJECTION)
    public static native Extent transformExtent(Extent extent, Projection source, Projection destination);

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
	@JsMethod(name = "transformExtent", namespace = PACKAGE_PROJECTION)
    public static native Extent transformExtent(Extent extent, String source, String destination);

}
