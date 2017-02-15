package ol.event;

import com.google.gwt.event.shared.HandlerRegistration;

import ol.EventsKey;
import ol.Observable;

/**
 * A {@link HandlerRegistration} for OpenLayers event handlers.
 * 
 * @author sbaumhekel
 */
public class OLHandlerRegistration implements HandlerRegistration {

    private EventsKey key;
    private Observable o;

    /**
     * Constructs an instance.
     * 
     * @param o
     *            {@link Observable}
     * @param key
     *            key
     */
    public OLHandlerRegistration(Observable o, EventsKey key) {
        this.o = o;
        this.key = key;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.google.web.bindery.event.shared.HandlerRegistration#removeHandler()
     */
    @Override
    public void removeHandler() {
        // unregister handler and remove all references
        if(o != null) {
            Observable.unByKey(key);
            o = null;
            key = null;
        }
    }

}
