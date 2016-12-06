package ol.event;

import jsinterop.annotations.JsFunction;

/**
 * A listener for events of the given type.
 *
 * @author sbaumhekel
 * @author Tino Desjardins
 *
 * @param <E>
 *            event type
 */
@JsFunction
public interface EventListener<E extends Event> {

    /**
     * Is called when an event is received.
     *
     * @param event
     *            event
     */
    void onEvent(E event);

}
