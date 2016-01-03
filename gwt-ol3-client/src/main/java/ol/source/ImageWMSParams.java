package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface ImageWMSParams {
    
    /**
     * 
     * @param layers comma seperated layernames
     */
    @JsProperty
    void setLayers(String layers);
    
}

