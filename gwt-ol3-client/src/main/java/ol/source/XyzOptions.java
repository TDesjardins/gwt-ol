package ol.source;

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

}
