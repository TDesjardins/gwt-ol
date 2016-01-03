package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;
import ol.tilegrid.TileGrid;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface TileDebugOptions extends Options {

    /**
     * 
     * @param projection
     *            projection
     */
    @JsProperty
    void setProjection(String projection);

    /**
     * 
     * @param tileGrid
     *            tilegrid
     */
    @JsProperty
    void setTileGrid(TileGrid tileGrid);

    /**
     * 
     * @param wrapX
     */
    @JsProperty
    void setWrapX(boolean wrapX);

}
