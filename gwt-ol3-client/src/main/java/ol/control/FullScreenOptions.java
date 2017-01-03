package ol.control;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * FullScreen options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FullScreenOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-full-screen".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * Full keyboard access.
     * @param keys
     *            keys
     */
    @JsProperty
    public native void setKeys(boolean keys);

    /**
     * Text label to use for the button. Default is \u2922 (NORTH EAST AND SOUTH
     * WEST ARROW). Instead of text, also a Node (e.g. a span element) can be
     * used.
     * @param label
     *            label
     */
    @JsProperty
    public native void setLabel(String label);

    /**
     * Text label to use for the button when full-screen is active. Default is
     * \u00d7 (a cross). Instead of text, also a Node (e.g. a span element) can
     * be used.
     * @param labelActive
     *            labelActive
     */
    @JsProperty
    public native void setLabelActive(String labelActive);

    /**
     * Text label to use for the button tip. Default is "Toggle full-screen".
     * @param tipLabel
     *            tip label
     */
    @JsProperty
    public native void setTipLabel(String tipLabel);

}
