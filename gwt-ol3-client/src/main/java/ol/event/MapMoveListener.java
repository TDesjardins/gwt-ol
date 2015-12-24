package ol.event;

import ol.MapEvent;

/**
 * A listener for map movements.
 * @author sbaumhekel
 */
public interface MapMoveListener {

    /**
     * Fired on a move of the map position.
     * @param evt {@link MapEvent}
     */
    void onMapMove(MapEvent evt);

}
