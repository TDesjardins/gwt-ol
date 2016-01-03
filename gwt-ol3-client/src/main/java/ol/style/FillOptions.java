package ol.style;

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
@JsType(isNative = true)
public interface FillOptions extends Options {

    /**
     * Set the fill color.
     * 
     * @param color {@link Color}
     */
    @JsProperty
    void setColor(Color color);

}
