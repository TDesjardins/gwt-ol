package ol;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link Attribution}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface AttributionOptions extends Options {

    /**
     * Set the HTML markup for this attribution. Required.
     * 
     * @param html html
     */
    @JsProperty
    public void setHtml(String html);

}
