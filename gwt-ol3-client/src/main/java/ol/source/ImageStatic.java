package ol.source;

import com.google.gwt.core.client.js.JsType;

import ol.control.Attribution;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface ImageStatic extends Image {
    
    void setAttributions (Attribution[] attributions);
            
}

