/**
 *
 * @author mribeiro
 * @date 07/06/16 17:51
 *
 */
package ol.style;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

@JsType(isNative = true)
public interface RegularShapeOptions extends Options {


    /**
     * Fill style.
     *
     * @param fill {@link Fill}
     */
    @JsProperty
    void setFill(Fill fill);

    /**
     * Number of points for stars and regular polygons. In case of a polygon, the number of points is the number of sides. Required.
     *
     * @param number number of points
     */
    @JsProperty
    void setPoints(int number);

    /**
     * Radius of a regular polygon.
     *
     * @param radius radius
     */
    @JsProperty
    void setRadius(int radius);

    /**
     * Shape's angle in radians. A value of 0 will have one of the shape's point facing up. Default value is 0.
     *
     * @param angle in rad
     */
    @JsProperty
    void setAngle(double angle);

    /**
     * Stroke style.
     *
     * @param stroke {@link Stroke}
     */
    @JsProperty
    void setStroke(Stroke stroke);
}
