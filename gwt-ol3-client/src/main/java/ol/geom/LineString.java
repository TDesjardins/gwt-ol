package ol.geom;

import jsinterop.annotations.JsType;

import ol.Coordinate;

/**
 * Linestring geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface LineString extends SimpleGeometryMultiCoordinates {
    /**
     * Append the passed coordinate to the coordinates of the linestring.
     *
     * @param coordinate
     *            Coordinate.
     */
    void appendCoordinate(Coordinate coordinate);

    /**
     * Return the length of the linestring on projected plane.
     *
     * @return {number} Length (on projected plane).
     * @api stable
     */
    double getLength();

}
