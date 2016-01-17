package ol.geom;

import jsinterop.annotations.JsType;

/**
 * MultiPoint geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class MultiPoint extends SimpleGeometryMultiCoordinates {
    /**
     * Append the passed point to this multipoint.
     * 
     * @param point
     *            Point.
     */
    public native void appendPoint(Point point);

    /**
     * Return the point at the specified index.
     * 
     * @param index
     *            Index.
     * @return {ol.geom.Point} Point.
     */
    public native Point getPoint(int index);

    /**
     * Return the points of this multipoint.
     * 
     * @return {Array.<ol.geom.Point>} Points.
     */
    public native Point[] getPoints();
    
}
