package ol.style;

import jsinterop.annotations.JsType;
import ol.color.Color;

/**
 * stroke style
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface Stroke {

    /**
     * Set the color.
     *
     * @param color
     *          color.
     */
    void setColor(Color color);

}
