package ol.geom;

import jsinterop.annotations.JsType;

import ol.Coordinate;

/**
 * Circle geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface Circle extends SimpleGeometryMultiCoordinates {
    /**
     * Return the center of the circle as {@link ol.Coordinate coordinate}.
     * 
     * @return {ol.Coordinate} Center.
     */
    Coordinate getCenter();

    /**
     * Return the radius of the circle.
     * 
     * @return {number} Radius.
     */
    double getRadius();

    /**
     * Set the center of the circle as {@link ol.Coordinate coordinate}.
     * 
     * @param center
     *            Center.
     */
    void setCenter(Coordinate center);

    /**
     * Set the center (as {@link ol.Coordinate coordinate}) and the radius (as
     * number) of the circle.
     * 
     * @param center
     *            Center.
     * @param radius
     *            Radius.
     */
    void setCenterAndRadius(Coordinate center, double radius);

    /**
     * Set the radius of the circle. The radius is in the units of the
     * projection.
     * 
     * @param radius
     *            Radius.
     */
    void setRadius(double radius);
}
