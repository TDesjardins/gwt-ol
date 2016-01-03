package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Feature;
import ol.event.Event;

/**
 * Events emitted by {@link ol.source.Vector} instances are instances of this
 * type.
 * 
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface VectorEvent extends Event {
    /**
     * The feature being added or removed.
     *
     * @return {@link ol.Feature}
     */
    @JsProperty
    Feature getFeature();

}
