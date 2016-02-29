package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Scale line control options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface ScaleLineOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-scale-line".
     * @param className
     *            class name
     * @return this instance
     */
    @JsProperty
    ScaleLineOptions setClassName(String className);

    /**
     * Minimum width in pixels. Default is 64.
     * @param minWidth
     *            minimum width
     * @return this instance
     */
    @JsProperty
    ScaleLineOptions setMinWidth(int minWidth);

    /**
     * Units. Default is metric.
     * @param units
     *            units
     * @return this instance
     */
    @JsProperty
    ScaleLineOptions setUnits(String units);

}
