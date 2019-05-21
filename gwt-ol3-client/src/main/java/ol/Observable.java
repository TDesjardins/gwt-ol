/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol;

import org.gwtproject.event.shared.HandlerRegistration;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import ol.event.EventListener;
import ol.events.Event;
import ol.events.EventTarget;

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
public abstract class Observable implements EventTarget {

    /**
     * Increases the revision counter and dispatches a 'change' event.
     */
    public native void changed();

    /**
     * Dispatches an event and calls all listeners listening for events of this type.
     *
     * @param eventType type of the event to dispatch
     */
    public native void dispatchEvent(String eventType);

    /**
     * Get the version number for this object. Each time the object is modified,
     * its version number will be incremented.
     *
     * @return Revision.
     */
    public native int getRevision();

    /**
     * Listen for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     * @return Unique key for the listener.
     */
    public native EventsKey on(String type, EventListener<? extends Event> listener);

    /**
     * Listen once for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     * @return {goog.events.Key} Unique key for the listener.
     */
    public native EventsKey once(String type, EventListener<? extends Event> listener);

    /**
     * Unlisten for a certain type of event.
     *
     * @param type
     *            The event type or array of event types.
     * @param listener
     *            The listener function.
     */
    public native void un(String type, EventListener<? extends Event> listener);

    /**
     * Removes an event listener using the key returned by on() or once().
     *
     * @param key key The key returned by
     *            `on()` or `once()` (or an array of keys).
     */
    public static native void unByKey(EventsKey key);

    /**
     * Generic change event. Triggered when the revision counter is increased.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addChangeListener(final EventListener<Event> listener) {
        return OLUtil.observe(this, "change", listener);
    }

}
