package ol.event;

import ol.MapBrowserEvent;

/**
 * A listener for double clicks.
 *
 * @author sbaumhekel
 */
public interface DoubleClickListener {

    /**
     * Fired on a double click.
     *
     * @param evt
     *            {@link MapBrowserEvent}
     */
    void onDoubleClick(MapBrowserEvent evt);

}
