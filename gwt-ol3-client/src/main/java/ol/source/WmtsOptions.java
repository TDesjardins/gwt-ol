package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * WMTS options.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WmtsOptions extends TileImageOptions {
    
    
    /**
     * Sets the layername.
     *
     * @param layer layername
     */
    @JsProperty
    public native void setLayer(String layer);
    
    @JsProperty
    public native void setStyle(String style);
    
    @JsProperty
    public native void setFormat(String format);
    
    @JsProperty
    public native void setVersion(String version);
    
    @JsProperty
    public native void setMatrixSet(String matrixSet);
    
    /**
     * experimental
     * 
     * @param wrapX
     */
    @JsProperty
    public native void setWrapX(boolean wrapX);
    
}
