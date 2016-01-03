package ol.source;

import jsinterop.annotations.JsType;

import ol.tilegrid.TileGrid;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. Base class for sources providing images divided into a
 * tile grid.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface Tile extends Source {

    /**
     * Return the tile grid of the tile source.
     * 
     * @return {ol.tilegrid.TileGrid} Tile grid.
     */
    TileGrid getTileGrid();

}
