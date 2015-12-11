package ol;

import com.google.gwt.core.client.js.JsType;

/**
 * An attribution for a layer source.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Attribution {

    /**
     * Gets the HTML markup for this attribution.
     * 
     * @return html
     */
    public String getHTML();

}
