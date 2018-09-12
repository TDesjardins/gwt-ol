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

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. Most non-trivial classes inherit from this.
 *
 * This extends {@link ol.Observable} with observable properties, where each
 * property is observable as well as the object as a whole.
 *
 * Classes that inherit from this have pre-defined properties, to which you can
 * add your owns. The pre-defined properties are listed in this documentation as
 * 'Observable Properties', and have their own accessors; for example,
 * {@link ol.PluggableMap} has a `target` property, accessed with `getTarget()` and
 * changed with `setTarget()`. Not all properties are however settable. There
 * are also general-purpose accessors `get()` and `set()`. For example,
 * `get('target')` is equivalent to `getTarget()`.
 *
 * The `set` accessors trigger a change event, and you can monitor this by
 * registering a listener. For example, {@link ol.View} has a `center` property,
 * so `view.on('change:center', function(evt) {...});` would call the function
 * whenever the value of the center property changes. Within the function,
 * `evt.target` would be the view, so `evt.target.getCenter()` would return the
 * new center.
 *
 * You can add your own observable properties with `object.set('prop',
 * 'value')`, and retrieve that with `object.get('prop')`. You can listen for
 * changes on that property value with `object.on('change:prop', listener)`. You
 * can get a list of all properties with {@link ol.Object#getProperties
 * object.getProperties()}.
 *
 * Note that the observable properties are separate from standard JS properties.
 * You can, for example, give your map object a title with `map.title='New
 * title'` and with `map.set('title', 'Another title')`. The first will be a
 * `hasOwnProperty`; the second will appear in `getProperties()`. Only the
 * second is observable.
 *
 * Properties can be deleted by using the unset method. E.g.
 * object.unset('foo').
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Object extends Observable {

    /**
     * Gets a value.
     *
     * @param key
     *            Key name.
     * @return Value.
     */
    public native <T> T get(String key);

    /**
     * Get an object of all property names and values.
     *
     * @return object of all property names and values
     */
    public native <T> JsPropertyMap<T> getProperties();

    /**
     * Sets a value.
     *
     * @param key
     *            Key name.
     * @param value
     *            Value.
     */
    public native <T> void set(String key, T value);

    /**
     * Sets a collection of key-value pairs. Note that this changes any existing properties
     * and adds new ones (it does not remove any existing properties).
     *
     * @param properties properties to set
     */
    public native <T> void setProperties(JsPropertyMap<T> properties);

    /**
     * Sets a collection of key-value pairs. Note that this changes any existing properties
     * and adds new ones (it does not remove any existing properties).
     *
     * @param properties properties to set
     * @param silent Update without triggering an event.
     */
    public native <T> void setProperties(JsPropertyMap<T> properties, boolean silent);

    /**
     * Unsets a property.
     *
     * @param key
     *            Key name.
     */
    public native void unset(String key);

    /**
     * Events emitted by {@link ol.Object} instances are instances of this type.
     *
     * @author sbaumhekel
     *
     *
     */
    @JsType(isNative = true)
    public interface Event extends ol.events.Event {

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
         * @param <T>
         *
         * @return old value
         */
        @JsProperty
        <T> T getOldValue();

    }

}
