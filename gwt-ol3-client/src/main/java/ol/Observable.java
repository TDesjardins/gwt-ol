package ol;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.js.JsType;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface Observable {

    /**
     * Increases the revision counter and dispatches a 'change' event.
     */
    void changed();

    /**
     * Listen for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     * @return Unique key for the listener.
     */
    JavaScriptObject on(String type, JavaScriptObject listener);

    /**
     * Listen once for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     * @return {goog.events.Key} Unique key for the listener.
     */
    JavaScriptObject once(String type, JavaScriptObject listener);

    /**
     * Unlisten for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     * @api stable
     */
    void un(String type, JavaScriptObject listener);

    /**
     * Removes an event listener using the key returned by on() or once(). Note
     * that using the ol.Observable.unByKey static function is to be preferred.
     *
     * @param key
     *            The key returned by on() or once().
     */
    void unByKey(JavaScriptObject key);
}
