package ol.source;

import jsinterop.annotations.JsType;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, name = "WMTS")
public class Wmts extends TileImage {
    
    public Wmts() {}
    
    public Wmts(WmtsOptions wmtsOptions) {}
    
}
