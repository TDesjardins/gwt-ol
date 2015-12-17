package ol;

import com.google.gwt.core.client.js.JsType;

/**
 * An attribution for a layer source.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.Attribution")
public interface Attribution {

    /**
     * Gets the HTML markup for this attribution.
     * 
     * @return html
     */
    public String getHTML();

}
