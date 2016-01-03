package ol.style;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;

/**
 * Options for the circle style.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface CircleOptions extends Options {

    /**
     * Fill style.
     * 
     * @param fill {@link Fill}
     */
    @JsProperty
    void setFill(Fill fill);

    /**
     * Circle radius. Required.
     * 
     * @param radius radius
     */
    @JsProperty
    void setRadius(double radius);

    /**
     * If true integral numbers of pixels are used as the X and Y pixel
     * coordinate when drawing the circle in the output canvas. If false
     * fractional numbers may be used. Using true allows for "sharp" rendering
     * (no blur), while using false allows for "accurate" rendering. Note that
     * accuracy is important if the circle's position is animated. Without it,
     * the circle may jitter noticeably. Default value is true.
     * 
     * @param snapToPixel snap to pixels?
     */
    @JsProperty
    void setSnapToPixel(boolean snapToPixel);

    /**
     * Stroke style.
     * 
     * @param stroke {@link Stroke}
     */
    @JsProperty
    void setStroke(Stroke stroke);

}
