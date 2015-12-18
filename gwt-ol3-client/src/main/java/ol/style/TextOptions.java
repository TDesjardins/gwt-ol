package ol.style;

import com.google.gwt.core.client.js.*;

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
    TextOptions text(String text);

}
