package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Options;

/**
 * Options for {@link Text}.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface TextOptions extends Options {

    @JsProperty
    void setText(String text);

}
