package ol;

import com.google.gwt.core.client.js.JsType;

/**
 * Class to create objects that can be used with
 * {@link ol.geom.Polygon.circular}.
 *
 * For example to create a sphere whose radius is equal to the semi-major axis
 * of the WGS84 ellipsoid:
 *
 * ```js var wgs84Sphere= new ol.Sphere(6378137); ```
 * @author sbaumhekel
 *
 */
@JsType(prototype = "ol.Sphere")
public interface Sphere {

    /**
     * Radius equal to the semi-major axis of the normal ellipsoid (like
     * ol.sphere.NORMAL).
     */
    static final double EARTH_RADIUS_NORMAL = 6370997;

    /**
     * Radius equal to the semi-major axis of the WGS84 ellipsoid (like
     * ol.sphere.WGS84).
     */
    static final double EARTH_RADIUS_WGS84 = 6378137;

    /**
     * Returns the geodesic area for a list of coordinates.
     *
     * [Reference](http://trs-new.jpl.nasa.gov/dspace/handle/2014/40409) Robert.
     * G. Chamberlain and William H. Duquette, "Some Algorithms for Polygons on
     * a Sphere", JPL Publication 07-03, Jet Propulsion Laboratory, Pasadena,
     * CA, June 2007
     *
     * @param coordinates
     *            List of coordinates of a linear ring. If the ring is oriented
     *            clockwise, the area will be positive, otherwise it will be
     *            negative.
     * @return {number} Area.
     */
    double geodesicArea(ol.Coordinate[] coordinates);

    /**
     * Returns the distance from c1 to c2 using the haversine formula.
     *
     * @param c1
     *            Coordinate 1.
     * @param c2
     *            Coordinate 2.
     * @return {number} Haversine distance.
     */
    double haversineDistance(ol.Coordinate c1, ol.Coordinate c2);
}
