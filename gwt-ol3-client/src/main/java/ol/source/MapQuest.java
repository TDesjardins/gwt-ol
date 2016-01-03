package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface MapQuest extends Xyz {
    
    @JsProperty
    void setLayer(String layer);
    
}

