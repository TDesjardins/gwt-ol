package ol.style;

import jsinterop.annotations.JsType;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface Text {

    /**
     * Set the text.
     *
     * @param text
     */
    void setText(String text);
}
