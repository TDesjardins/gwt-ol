package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface Stamen extends Xyz {
    
    @JsProperty
    void setLayer(String layer);
    
}

