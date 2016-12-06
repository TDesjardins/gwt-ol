package ol.control;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Zoom slider control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface ZoomSliderOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-zoomslider".
     * @param className
     *            class name
     */
    @JsProperty
    void setClassName(String className);

    /**
     * Animation duration in milliseconds. Default is 200.
     * @param duration
     *            animation duration
     */
    @JsProperty
    void setDuration(int duration);

    /**
     * Maximum resolution.
     * @param maxResolution
     *            max resolution
     */
    @JsProperty
    void setMaxResolution(double maxResolution);

    /**
     * Minimum resolution.
     * @param minResolution
     *            min resolution
     */
    @JsProperty
    void setMinResolution(double minResolution);

}
