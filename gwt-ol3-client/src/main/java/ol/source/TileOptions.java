package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.tilegrid.TileGrid;

/**
 * Abstract tile options.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileOptions extends SourceOptions {

    /**
     * Gets the {@link TileGrid}.
     *
     * @return tileGrid {@link TileGrid}
     */
    @JsProperty
    public native TileGrid getTileGrid();
    
    /**
     * Set the {@link TileGrid}.
     *
     * @param tileGrid {@link TileGrid}
     */
    @JsProperty
    public native void setTileGrid(TileGrid tileGrid);
    
}
