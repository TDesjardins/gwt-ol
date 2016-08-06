package ol.interaction;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.event.Event;

/**
 * Events emitted by {@link Select} instances are instances of this type.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface SelectEvent extends Event {

    @JsProperty
    public String getType();
    
}

