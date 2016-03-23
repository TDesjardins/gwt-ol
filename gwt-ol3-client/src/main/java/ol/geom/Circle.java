package ol.geom;

import jsinterop.annotations.JsType;

import ol.Coordinate;

/**
 * Circle geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class Circle extends SimpleGeometry {
    
    /**
     * Return the center of the circle as {@link ol.Coordinate coordinate}.
     * 
     * @return {ol.Coordinate} Center.
     */
    public native Coordinate getCenter();

    /**
     * Return the radius of the circle.
     * 
     * @return {number} Radius.
     */
    public native double getRadius();

    /**
     * Set the center of the circle as {@link ol.Coordinate coordinate}.
     * 
     * @param center
     *            Center.
     */
    public native void setCenter(Coordinate center);

    /**
     * Set the center (as {@link ol.Coordinate coordinate}) and the radius (as
     * number) of the circle.
     * 
     * @param center
     *            Center.
     * @param radius
     *            Radius.
     */
    public native void setCenterAndRadius(Coordinate center, double radius);

    /**
     * Set the radius of the circle. The radius is in the units of the
     * projection.
     * 
     * @param radius
     *            Radius.
     */
    public native void setRadius(double radius);
    
}
