package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Options;
import ol.color.Color;

/**
 * Options for the style {@link Stroke}.
 *
 * @author Tino Desjardins
 *
 */
@JsType
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
