package ol.event;

import ol.MapBrowserEvent;

/**
 * A listener for clicks.
 * 
 * @author sbaumhekel
 */
public interface ClickListener {

    /**
     * Fired on a click.
     * 
     * @param evt
     *            {@link MapBrowserEvent}
     */
    void onClick(MapBrowserEvent evt);

}
