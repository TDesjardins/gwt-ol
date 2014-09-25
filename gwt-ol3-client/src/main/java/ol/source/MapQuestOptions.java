package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface MapQuestOptions {
    
    /**
     * 
     * @param layer osm, sat, hyb
     */
    @JsProperty
    void setLayer(String layer);
    
}

