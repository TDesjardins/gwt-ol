package ol;

import jsinterop.annotations.JsType;

/**
 * An attribution for a layer source.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Attribution {
    
    public Attribution(AttributionOptions attributionOptions) {}
    
    /**
     * Gets the HTML markup for this attribution.
     * 
     * @return html
     */
    public native String getHTML();

}
