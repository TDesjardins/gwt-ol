package ol.style;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;
import ol.color.Color;

/**
 * Options for the style {@link Fill}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FillOptions implements Options {

    /**
     * Set the fill color.
     * 
     * @param color {@link Color}
     */
    @JsProperty
    public native void setColor(Color color);

}
