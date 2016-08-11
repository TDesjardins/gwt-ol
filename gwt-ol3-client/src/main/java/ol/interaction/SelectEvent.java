package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.event.Event;

/**
 * Events emitted by {@link Select} instances are instances of this type.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface SelectEvent extends Event {

    @JsProperty
    public String getType();
    
}

