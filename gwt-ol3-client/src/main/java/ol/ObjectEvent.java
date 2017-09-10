/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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

import com.google.gwt.core.client.JavaScriptObject;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.events.Event;

/**
 * Events emitted by {@link ol.Object} instances are instances of this type.
 *
 * @author sbaumhekel
 *
 * @deprecated Use {@link ol.Object.Event} instead.
 */
@Deprecated
@JsType(isNative = true)
public interface ObjectEvent extends Event {

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
