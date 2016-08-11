package ol.geom;

import jsinterop.annotations.JsType;
import ol.Coordinate;

/**
 * Linestring geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class LineString extends SimpleGeometryCoordinates {
    
    public LineString(Coordinate[] coordinates) {}
    
    /**
     * Append the passed coordinate to the coordinates of the linestring.
     *
     * @param coordinate
     *            Coordinate.
     */
    public native void appendCoordinate(Coordinate coordinate);

    /**
     * Return the length of the linestring on projected plane.
     *
     * @return {number} Length (on projected plane).
     * @api stable
     */
    public native double getLength();

}
