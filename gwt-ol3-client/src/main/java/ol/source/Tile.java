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
public class Tile extends Source {

    /**
     * Return the tile grid of the tile source.
     * 
     * @return {ol.tilegrid.TileGrid} Tile grid.
     */
    public native TileGrid getTileGrid();
    
    /**
     * Events emitted by {@link ol.source.Tile} instances are instances of this
     * type.
     * 
     * @author sbaumhekel
     *
     */
    @JsType(isNative = true)
    public interface Event extends ol.event.Event {

    }

}
