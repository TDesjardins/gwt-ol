package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.source.Stamen")
public interface Stamen extends Xyz {
    
    @JsProperty
    void setLayer(String layer);
    
}

