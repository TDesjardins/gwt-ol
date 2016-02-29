package ol.control;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.proj.Projection;

/**
 * Mouse position options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface MousePositionOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-mouse-position".
     * @param className
     *            class name
     */
    @JsProperty
    void setClassName(String className);

    /**
     * Projection.
     * @param projection
     *            {@link Projection}
     */
    @JsProperty
    void setProjection(Projection projection);

    /**
     * Markup for undefined coordinates. Default is "" (empty string).
     * @param undefinedHTML
     *            undefined HTML
     */
    @JsProperty
    void setUndefinedHTML(String undefinedHTML);

}
