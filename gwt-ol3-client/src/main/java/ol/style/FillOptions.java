package ol.style;

import com.google.gwt.core.client.js.*;

import ol.color.Color;

/**
 * Options for the style {@link Fill}.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface FillOptions {

    /**
     * Set the fill color.
     * 
     * @param color
     *            {@link Color}
     * @return this instance
     */
    @JsProperty
    FillOptions color(Color color);

}
