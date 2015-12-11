package ol.event;

import ol.MapEvent;
import ol.source.TileEvent;

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
    void onTileLoadError(TileEvent evt);

}
