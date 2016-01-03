package ol;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.event.Event;

/**
 * Events emitted as map events are instances of this type. See {@link ol.Map}
 * for which events trigger a map event.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface MapEvent extends Event {

    /**
     * The map where the event occurred.
     *
     * @return {@link ol.Map}
     */
    @JsProperty
    Map getMap();
    
}
