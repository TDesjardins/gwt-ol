package ol.style;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;

/**
 * Options for {@link Text}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface TextOptions extends Options {

    @JsProperty
    void setText(String text);

}
