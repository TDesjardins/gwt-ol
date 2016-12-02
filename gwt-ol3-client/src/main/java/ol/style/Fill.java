package ol.style;

import jsinterop.annotations.JsType;
import ol.color.Color;

/**
 * Set fill style for vector features.
 * 
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface Fill {

    /**
     * Set the color.
     *
     * @param color
     *          color.
     */
    void setColor(Color color);

    /**
     * Get the fill color
     * @return
     */
    Color getColor();
}
