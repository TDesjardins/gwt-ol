package ol.control;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Rotate control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RotateOptions extends ControlOptions {

    /**
     * Hide the control when rotation is 0. Default is true.
     * @param autoHide
     *            auto hide
     */
    @JsProperty
    public native void setAutoHide(boolean autoHide);

    /**
     * CSS class name. Default is "ol-rotate".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * Animation duration in milliseconds. Default is 250.
     * @param duration
     *            animation duration
     */
    @JsProperty
    public native void setDuration(int duration);

    /**
     * Text label to use for the rotate button. Default is (arrow up). Instead
     * of text, also a Node (e.g. a span element) can be used.
     * @param label
     *            label
     */
    @JsProperty
    public native void setLabel(String label);

    /**
     * Text label to use for the button tip. Default is "Reset rotation".
     * @param tipLabel
     *            tip label
     */
    @JsProperty
    public native void setTipLabel(String tipLabel);

}
