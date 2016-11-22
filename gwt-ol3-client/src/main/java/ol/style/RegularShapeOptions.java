package ol.style;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * @author mribeiro
 * @date 07/06/16 17:51
 */
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

    /**
     * Rotation in radians (positive rotation clockwise). Default is 0
     *
     * @param rotation in rad
     */
    @JsProperty
    void setRotation(double rotation);

    /**
     * Inner radius of a star.
     *
     * @param radius1 radius
     */
    @JsProperty
    void setRadius1(int radius1);

    /**
     * Outer radius of a star.
     *
     * @param radius2 radius
     */
    @JsProperty
    void setRadius2(int radius2);

    /**
     * Whether to rotate the shape with the view. Default is false.
     * @param value
     */
    @JsProperty
    void setRotateWithView(boolean value);
}
