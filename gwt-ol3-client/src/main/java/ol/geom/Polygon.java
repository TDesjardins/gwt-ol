package ol.geom;

import jsinterop.annotations.JsType;

/**
 * Polygon geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class Polygon extends SimpleGeometryMultiCoordinates {

    /**
     * Append the passed linear ring to this polygon.
     *
     * @param linearRing
     *            Linear ring.
     */
    public native void appendLinearRing(LinearRing linearRing);

    /**
     * Return the area of the polygon on projected plane.
     *
     * @return {number} Area (on projected plane).
     */
    public native double getArea();

    /**
     * Return the Nth linear ring of the polygon geometry. Return `null` if the
     * given index is out of range. The exterior linear ring is available at
     * index `0` and the interior rings at index `1` and beyond.
     *
     * @param index
     *            Index.
     * @return {ol.geom.LinearRing} Linear ring.
     */
    public native LinearRing getLinearRing(int index);

    /**
     * Return the number of rings of the polygon, this includes the exterior
     * ring and any interior rings.
     *
     * @return {number} Number of rings.
     */
    public native int getLinearRingCount();

    /**
     * Return the linear rings of the polygon.
     *
     * @return {Array.<ol.geom.LinearRing>} Linear rings.
     */
    public native LinearRing[] getLinearRings();

    /**
     * Return an interior point of the polygon.
     *
     * @return {ol.geom.Point} Point.
     */
    public native Point getInteriorPoint();

}
