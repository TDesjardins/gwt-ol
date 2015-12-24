package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.source.MapQuest")
public interface MapQuest extends Xyz {
    
    @JsProperty
    void setLayer(String layer);
    
}

