package ol.event;

import ol.MapEvent;
import ol.source.Tile;

/**
 * A listener for tile loading errors.
 * 
 * @author sbaumhekel
 */
public interface TileLoadErrorListener {

    /**
     * Fired if tile loading results in an error.
     * 
     * @param evt
     *            {@link MapEvent}
     */
    void onTileLoadError(Tile.Event evt);

}
