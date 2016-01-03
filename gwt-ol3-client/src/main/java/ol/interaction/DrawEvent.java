package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Feature;
import ol.event.Event;

/**
 * Events emitted by {@link ol.interaction.Draw} instances are instances of this
 * type.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface DrawEvent extends Event {
    /**
     * Triggered upon feature draw end
     */
    static final String DRAWEND = "drawend";

    /**
     * Triggered upon feature draw start
     */
    static final String DRAWSTART = "drawstart";

    /**
     * The feature being drawn.
     *
     * @return {@link ol.Feature}
     */
    @JsProperty
    Feature getFeature();

}
