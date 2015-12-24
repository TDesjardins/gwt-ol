package ol.event;

import com.google.gwt.core.client.js.JsType;

/**
 * A listener for events of the given type.
 * 
 * @author sbaumhekel
 *
 * @param <E>
 *            event type
 */
@JsType
public interface EventListener<E extends Event> {

    /**
     * Is called when an event is received.
     * 
     * @param event
     *            event
     */
    void onEvent(E event);

}
