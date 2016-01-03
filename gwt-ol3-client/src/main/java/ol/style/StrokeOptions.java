package ol.style;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;
import ol.color.Color;

/**
 * Options for the style {@link Stroke}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface StrokeOptions extends Options {

    /**
     * Set the stroke color.
     *
     * @param color {@link Color}
     */
    @JsProperty
    public void setColor(Color color);

    /**
     * Set the stroke width.
     *
     * @param width width
     */
    @JsProperty
    public void setWidth(int width);

}
