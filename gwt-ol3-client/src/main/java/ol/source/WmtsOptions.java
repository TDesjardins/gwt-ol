package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * WMTS options.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface WmtsOptions extends TileImageOptions {
    
    
    /**
     * Sets the layername.
     *
     * @param layer layername
     */
    @JsProperty
    void setLayer(String layer);
    
    @JsProperty
    void setStyle(String style);
    
    @JsProperty
    void setFormat(String format);
    
    @JsProperty
    void setVersion(String version);
    
    @JsProperty
    void setMatrixSet(String matrixSet);
    
    /**
     * experimental
     * 
     * @param wrapX
     */
    @JsProperty
    void setWrapX(boolean wrapX);
    
}
