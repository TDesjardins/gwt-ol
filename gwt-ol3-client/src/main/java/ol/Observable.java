package ol;

import com.google.gwt.core.client.JavaScriptObject;

import jsinterop.annotations.JsType;
import ol.event.Event;
import ol.event.EventListener;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. An event target providing convenient methods for
 * listener registration and unregistration. A generic `change` event is always
 * available through {@link ol.Observable#changed}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Observable {

    /**
     * Increases the revision counter and dispatches a 'change' event.
     */
    public native void changed();

    /**
     * Listen for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     * @return Unique key for the listener.
     */
    public native JavaScriptObject on(String type, EventListener<? extends Event> listener);

    /**
     * Listen once for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     * @return {goog.events.Key} Unique key for the listener.
     */
    public native JavaScriptObject once(String type, EventListener<? extends Event> listener);

    /**
     * Unlisten for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     * @api stable
     */
    public native void un(String type, EventListener<? extends Event> listener);

    /**
     * Removes an event listener using the key returned by on() or once(). Note
     * that using the ol.Observable.unByKey static function is to be preferred.
     *
     * @param key
     *            The key returned by on() or once().
     */
    public native void unByKey(JavaScriptObject key);
}
