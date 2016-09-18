package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.tilegrid.TileGrid;

/**
 * Abstract tile options.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface TileOptions extends SourceOptions {

    /**
     * Gets the {@link TileGrid}.
     *
     * @return tileGrid {@link TileGrid}
     */
    @JsProperty
    TileGrid getTileGrid();
    
    /**
     * Set the {@link TileGrid}.
     *
     * @param tileGrid {@link TileGrid}
     */
    @JsProperty
    void setTileGrid(TileGrid tileGrid);
    
}
