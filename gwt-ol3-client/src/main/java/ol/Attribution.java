package ol;

import jsinterop.annotations.JsType;

/**
 * An attribution for a layer source.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface Attribution {

    /**
     * Gets the HTML markup for this attribution.
     * 
     * @return html
     */
    public String getHTML();

}
