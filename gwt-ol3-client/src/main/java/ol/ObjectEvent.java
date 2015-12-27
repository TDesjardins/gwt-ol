package ol;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.js.*;

import ol.event.Event;

/**
 * Events emitted by {@link ol.Object} instances are instances of this type.
 *
 * @author sbaumhekel
 */
@JsType
public interface ObjectEvent extends Event {

    /**
     * Type of this event.
     */
    public static final String TYPE = "propertychange";

    /**
     * The name of the property whose value is changing.
     *
     * @return key
     */
    @JsProperty
    String getKey();

    /**
     * The old value. To get the new value use e.target.get(e.key) where e is
     * the event object.
     *
     * @return old value
     */
    @JsProperty
    JavaScriptObject getOldValue();

}
