package ol.control;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import com.google.gwt.core.client.JavaScriptObject;

import ol.proj.Projection;

/**
 * Mouse position options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface MousePositionOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-mouse-position".
     * @param className
     *            class name
     */
    @JsProperty
    void setClassName(String className);

    /**
     * 
     * @param coordinateFormat Coordinate format function.
     * @return this instance
     */
    @JsProperty
    void setCoordinateFormat(JavaScriptObject coordinateFormat);
    
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
