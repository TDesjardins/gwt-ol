package ol.tilegrid;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * {@link TileGrid} options.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface WmtsTileGridOptions extends TileGridOptions {
    
    @JsProperty
    void setMatrixIds(String[] matrixIds);

}
