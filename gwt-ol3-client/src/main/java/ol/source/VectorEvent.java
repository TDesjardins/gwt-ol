package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Feature;
import ol.event.Event;

/**
 * Events emitted by {@link ol.source.Vector} instances are instances of this
 * type.
 * 
 * @author sbaumhekel
 */
@JsType
public interface VectorEvent extends Event {
    /**
     * The feature being added or removed.
     *
     * @return {@link ol.Feature}
     */
    @JsProperty
    Feature getFeature();

}
