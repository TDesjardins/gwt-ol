package ol;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;

/**
 * Options for {@link Attribution}.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface AttributionOptions extends Options {

    /**
     * Set the HTML markup for this attribution. Required.
     * 
     * @param html
     *            html
     * @return this instance
     */
    @JsProperty
    public AttributionOptions setHtml(String html);

}
