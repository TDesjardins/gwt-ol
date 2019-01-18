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

import com.google.gwt.event.shared.HandlerRegistration;

import javax.annotation.Nullable;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.event.EventListener;

/**
 *
 * @author Tino Desjardins
 * @param <T> type of the elements
 *
 */
@JsType(isNative = true)
public class Collection<T> extends Object {

    /**
     * Triggered when an item is added to the collection.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addElementAddedListener(final EventListener<Event<T>> listener) {
        return OLUtil.observe(this, "add", listener);
    }

    /**
     * Triggered when an item is removed from the collection.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addElementRemovedListener(final EventListener<Event<T>> listener) {
        return OLUtil.observe(this, "remove", listener);
    }

    public native void clear();

    /**
     * Returns <tt>true</tt> if this collection contains the specified element.
     *
     * @param item element whose presence in this collection is to be tested
     * @return <tt>true</tt> if this collection contains the specified element
     */
    @JsOverlay
    public final boolean contains(T item) {
        if (item != null) {
            for (int i = 0; i < getLength(); i++) {
                if (item(i).equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public native T[] getArray();

    public native int getLength();

    public native void insertAt(int index, T element);

    /**
     * Returns <tt>true</tt> if this collection contains no elements.
     *
     * @return <tt>true</tt> if this collection contains no elements
     */
    @JsOverlay
    public final boolean isEmpty() {
        return getLength() == 0;
    }

    public native T item(int index);

    public native T pop();

    public native int push(T element);

    /**
     * Remove the first occurrence of an element from the collection.
     *
     * @param element Element.
     * @return The removed element or undefined if none found.
     */
    @Nullable
    public native T remove(T element);

    /**
     * Remove the element at the provided index and return it. Return
     * `undefined` if the collection does not contain this index.
     *
     * @param index Index.
     * @return Value.
     */
    @Nullable
    public native T removeAt(int index);

    public native void setAt(int index, T element);

    /**
     * Events emitted by {@link ol.Collection} instances are instances of this type.
     *
     * @author Tino Desjardins
     *
     */
    @JsType(isNative = true)
    public interface Event<T> extends ol.events.Event {

        @Nullable
        @JsProperty
        public T getElement();

    }

}
