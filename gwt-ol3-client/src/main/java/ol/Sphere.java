package ol;

import jsinterop.annotations.JsType;

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
@JsType(isNative = true)
public class Sphere {

    
    public Sphere(double radius) {}
    
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
    public native double geodesicArea(ol.Coordinate[] coordinates);

    /**
     * Returns the distance from c1 to c2 using the haversine formula.
     *
     * @param coordinate1
     *            Coordinate 1.
     * @param coordinate2
     *            Coordinate 2.
     * @return {number} Haversine distance.
     */
    public native double haversineDistance(ol.Coordinate coordinate1, ol.Coordinate coordinate2);
}
