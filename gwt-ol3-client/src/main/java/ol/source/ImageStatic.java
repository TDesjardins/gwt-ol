package ol.source;

import com.google.gwt.core.client.js.JsType;

import ol.control.Attribution;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.source.ImageStatic")
public interface ImageStatic extends Image {
    
    void setAttributions (Attribution[] attributions);
            
}

