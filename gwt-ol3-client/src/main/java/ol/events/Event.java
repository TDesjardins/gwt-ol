/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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
package ol.events;

import javax.annotation.Nullable;

import jsinterop.annotations.JsProperty;

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
     * @param <T>
     * 
     * @return {Object|undefined}
     */
    @Nullable
    @JsProperty
    <T extends EventTarget> T getCurrentTarget();

    /**
     * Target of the event.
     * 
     * @return {Object|undefined}
     */
    @Nullable
    @JsProperty
    <T extends EventTarget> T  getTarget();

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
