package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class MapQuest extends Xyz {
    
    @JsProperty
    public native void setLayer(String layer);
    
}

