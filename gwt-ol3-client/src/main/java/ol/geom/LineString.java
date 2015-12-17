package ol.geom;

import com.google.gwt.core.client.js.JsType;

import ol.Coordinate;

/**
 * Linestring geometry.
 *
 * @author sbaumhekel
 */
@JsType(prototype="ol.geom.LineString")
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
