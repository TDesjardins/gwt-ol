package ol.geom;

import com.google.gwt.core.client.js.JsType;

/**
 * Polygon geometry.
 *
 * @author sbaumhekel
 */
@JsType
public interface Polygon extends SimpleGeometryMultiCoordinates {

    /**
     * Append the passed linear ring to this polygon.
     * 
     * @param linearRing
     *            Linear ring.
     */
    void appendLinearRing(LinearRing linearRing);

    /**
     * Return the Nth linear ring of the polygon geometry. Return `null` if the
     * given index is out of range. The exterior linear ring is available at
     * index `0` and the interior rings at index `1` and beyond.
     *
     * @param index
     *            Index.
     * @return {ol.geom.LinearRing} Linear ring.
     */
    LinearRing getLinearRing(int index);

    /**
     * Return the number of rings of the polygon, this includes the exterior
     * ring and any interior rings.
     *
     * @return {number} Number of rings.
     */
    int getLinearRingCount();

    /**
     * Return the linear rings of the polygon.
     * 
     * @return {Array.<ol.geom.LinearRing>} Linear rings.
     */
    LinearRing[] getLinearRings();
}
