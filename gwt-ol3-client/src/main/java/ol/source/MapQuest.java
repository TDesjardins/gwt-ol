package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface MapQuest extends Xyz {
    
    @JsProperty
    void setLayer(String layer);
    
}

