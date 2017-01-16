package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageWMSParams {
    
    /**
     * 
     * @param layers comma seperated layernames
     */
    @JsProperty
    public native void setLayers(String layers);

    @JsProperty(name = "WIDTH")
    public native void setWidth(String width);

    @JsProperty(name = "HEIGHT")
    public native void setHeight(String height);
    
}

