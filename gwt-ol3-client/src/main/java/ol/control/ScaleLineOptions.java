package ol.control;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Scale line control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ScaleLineOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-scale-line".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * Minimum width in pixels. Default is 64.
     * @param minWidth
     *            minimum width
     */
    @JsProperty
    public native void setMinWidth(int minWidth);

    /**
     * Units. Default is metric.
     * @param units
     *            units
     */
    @JsProperty
    public native void setUnits(String units);

}
