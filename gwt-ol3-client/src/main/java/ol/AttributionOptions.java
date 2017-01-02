package ol;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link Attribution}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class AttributionOptions implements Options {

    /**
     * Set the HTML markup for this attribution. Required.
     * 
     * @param html html
     */
    @JsProperty
    public native void setHtml(String html);

}
