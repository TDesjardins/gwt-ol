package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface ImageWMSOptions {
    
    /**
     * 
     * @param imageWMSParams params for WMS-requests
     */
    @JsProperty
    void setParams(ImageWMSParams imageWMSParams);
    
    /**
     * 
     * @param ratio
     */
    @JsProperty
    void setRatio(float ratio); 
    
    /**
     * 
     * @param url WMS service URL
     */
    @JsProperty
    void setUrl(String url); 
    
}

