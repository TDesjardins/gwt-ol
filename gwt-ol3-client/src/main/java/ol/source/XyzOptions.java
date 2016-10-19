package ol.source;

import com.google.gwt.core.client.JavaScriptObject;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * XYZ options.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface XyzOptions extends TileImageOptions {

    /**
     * Set the optional max zoom level. Default is 18.
     *
     * @param maxZoom max zoom
     */
    @JsProperty
    void setMaxZoom(int maxZoom);

    /**
     * Optional function to get tile URL given a tile coordinate and the
     * projection. Required if url or urls are not provided.
     */
    @JsProperty
    void setTileUrlFunction(JavaScriptObject tileUrlFunction);

}
