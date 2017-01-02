package ol.control;

import com.google.gwt.core.client.JavaScriptObject;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.proj.Projection;

/**
 * Mouse position options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MousePositionOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-mouse-position".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * 
     * @param coordinateFormat Coordinate format function.
     */
    @JsProperty
    public native void setCoordinateFormat(JavaScriptObject coordinateFormat);
    
    /**
     * Projection.
     * @param projection
     *            {@link Projection}
     */
    @JsProperty
    public native void setProjection(Projection projection);

    /**
     * Markup for undefined coordinates. Default is "" (empty string).
     * @param undefinedHTML
     *            undefined HTML
     */
    @JsProperty
    public native void setUndefinedHTML(String undefinedHTML);

}
