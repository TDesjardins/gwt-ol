package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;
import ol.tilegrid.TileGrid;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileDebugOptions implements Options {

    /**
     * 
     * @param projection
     *            projection
     */
    @JsProperty
    public native void setProjection(String projection);

    /**
     * 
     * @param tileGrid
     *            tilegrid
     */
    @JsProperty
    public native void setTileGrid(TileGrid tileGrid);

    /**
     * 
     * @param wrapX
     */
    @JsProperty
    public native void setWrapX(boolean wrapX);

}
