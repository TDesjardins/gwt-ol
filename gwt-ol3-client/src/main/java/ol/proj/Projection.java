package ol.proj;

import com.google.gwt.core.client.js.JsType;

import ol.*;

/**
 * Projection definition class. One of these is created for each projection
 * supported in the application and stored in the {@link ol.proj} namespace. You
 * can use these in applications, but this is not required, as API params and
 * options use {@link ol.proj.ProjectionLike} which means the simple string code
 * will suffice.
 *
 * You can use {@link ol.proj.get} to retrieve the object for a particular
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
@JsType
public abstract class Projection {

    public static native void addProjection(Projection projection)
    /*-{
		$wnd.ol.proj.addProjection(projection);
    }-*/;

    /**
     * Fetches a Projection object for the code specified.
     *
     * @param projectionCode
     *            Either a code string which is a combination of authority and
     *            identifier such as "EPSG:4326", or an existing projection
     *            object, or undefined.
     * @return {ol.proj.Projection} Projection object, or null if not in list.
     */
    public static native Projection get(String projectionCode)
    /*-{
		return $wnd.ol.proj.get(projectionCode);
    }-*/;

    /**
     * Transforms a coordinate from source projection to destination projection.
     * This returns a new coordinate (and does not modify the original).
     *
     * See {@link ol.proj.transformExtent} for extent transformation. See the
     * transform method of {@link ol.geom.Geometry} and its subclasses for
     * geometry transforms.
     *
     * @param coordinate
     *            Coordinate.
     * @param source
     *            Source projection-like.
     * @param destination
     *            Destination projection-like.
     * @return {ol.Coordinate} Coordinate.
     */
    public static native Coordinate transform(Coordinate coordinate, String source, String destination)
    /*-{
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
    public static native Extent transformExtent(Extent extent, String source, String destination)
    /*-{
		return $wnd.ol.proj.transformExtent(extent, source, destination);
    }-*/;

    public abstract String getCode();

    public abstract Extent getExtent();

    public abstract double getMetersPerUnit();

    public abstract String getUnits();

    public abstract boolean isGlobal();

    public abstract void setExtent(Extent extent);

}
