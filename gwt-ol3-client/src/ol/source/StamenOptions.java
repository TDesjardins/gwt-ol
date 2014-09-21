package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface StamenOptions {
    
    /**
     * 
     * @param layerName watercolor, toner
     */
    @JsProperty
    void setLayer(String layerName);
    
}

