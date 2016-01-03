package ol.event;

import javax.annotation.Nullable;

import jsinterop.annotations.JsProperty;

import com.google.gwt.core.client.JavaScriptObject;

import jsinterop.annotations.JsType;

/**
 * A base class for event objects, so that they can support preventDefault and
 * stopPropagation. Resembles goog.events.Event.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface Event {

    /**
     * Whether the default action has been prevented.
     * 
     * @return true on success, else false
     */
    @JsProperty
    boolean getDefaultPrevented();

    /**
     * Object that had the listener attached.
     * 
     * @return {Object|undefined}
     */
    @Nullable
    @JsProperty
    JavaScriptObject getCurrentTarget();

    /**
     * Target of the event.
     * 
     * @return {Object|undefined}
     */
    @Nullable
    @JsProperty
    JavaScriptObject getTarget();

    /**
     * Event type.
     * 
     * @return type {string}
     */
    @JsProperty
    String getType();

    /**
     * Prevents the default action, for example a link redirecting to a url.
     */
    void preventDefault();

    /**
     * Stops event propagation.
     */
    void stopPropagation();
}
