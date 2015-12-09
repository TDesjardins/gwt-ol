package ol.style;

import com.google.gwt.core.client.js.*;

import ol.color.Color;

/**
 * Options for the style {@link Stroke}.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface StrokeOptions {

    /**
     * Set the stroke color.
     *
     * @param color
     *            {@link Color}
     * @return this instance
     */
    @JsProperty
    public StrokeOptions color(Color color);

    /**
     * Set the stroke width.
     *
     * @param width
     *            width
     * @return this instance
     */
    @JsProperty
    public StrokeOptions width(int width);

}
