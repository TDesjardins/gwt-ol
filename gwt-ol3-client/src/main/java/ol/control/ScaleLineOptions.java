package ol.control;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Scale line control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface ScaleLineOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-scale-line".
     * @param className
     *            class name
     */
    @JsProperty
    void setClassName(String className);

    /**
     * Minimum width in pixels. Default is 64.
     * @param minWidth
     *            minimum width
     */
    @JsProperty
    void setMinWidth(int minWidth);

    /**
     * Units. Default is metric.
     * @param units
     *            units
     */
    @JsProperty
    void setUnits(String units);

}
