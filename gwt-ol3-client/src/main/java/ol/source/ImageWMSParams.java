package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface ImageWMSParams {
    
    /**
     * 
     * @param layers comma seperated layernames
     */
    @JsProperty
    void setLayers(String layers);
    
}

