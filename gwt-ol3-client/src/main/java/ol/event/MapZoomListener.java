package ol.event;

import ol.MapEvent;

/**
 * A listener for map zooms.
 * @author sbaumhekel
 */
public interface MapZoomListener {

    /**
     * Fired on a zoom of the map.
     * @param evt {@link MapEvent}
     */
    void onMapZoom(MapEvent evt);

}
