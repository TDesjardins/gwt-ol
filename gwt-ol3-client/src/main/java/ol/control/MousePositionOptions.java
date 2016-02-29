package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

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
     * @return this instance
     */
    @JsProperty
    MousePositionOptions setClassName(String className);

    /**
     * Projection.
     * @param projection
     *            {@link Projection}
     * @return this instance
     */
    @JsProperty
    MousePositionOptions setProjection(Projection projection);

    /**
     * Markup for undefined coordinates. Default is "" (empty string).
     * @param undefinedHTML
     *            undefined HTML
     * @return this instance
     */
    @JsProperty
    MousePositionOptions setUndefinedHTML(String undefinedHTML);

}
