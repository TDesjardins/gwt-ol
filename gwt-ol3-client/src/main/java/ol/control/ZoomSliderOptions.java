package ol.control;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Zoom slider control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ZoomSliderOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-zoomslider".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * Animation duration in milliseconds. Default is 200.
     * @param duration
     *            animation duration
     */
    @JsProperty
    public native void setDuration(int duration);

    /**
     * Maximum resolution.
     * @param maxResolution
     *            max resolution
     */
    @JsProperty
    public native void setMaxResolution(double maxResolution);

    /**
     * Minimum resolution.
     * @param minResolution
     *            min resolution
     */
    @JsProperty
    public native void setMinResolution(double minResolution);

}
