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
package ol.events.condition;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.GenericFunction;
import ol.MapBrowserEvent;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Condition {

    /**
     * @return function that returns <tt>true</tt> if only the alt-key is pressed, <tt>false</tt> otherwise (e.g. when additionally the shift-key is pressed)
     */
    @JsProperty(name = "altKeyOnly", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getAltKeyOnly();

    /**
     * @return function that returns <tt>true</tt> if only the alt-key and shift-key is pressed, false otherwise (e.g. when additionally the
     *         platform-modifier-key is pressed).
     */
    @JsProperty(name = "altShiftKeysOnly", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getAltShiftKeysOnly();

    /**
     * @return function that returns always <tt>true</tt> .
     */
    @JsProperty(name = "always", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getAlways();

    /**
     * @return function that returns true if the event is a click event
     */
    @JsProperty(name = "click", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getClick();

    /**
     * @return function that returns true if the event is a dblclick event
     */
    @JsProperty(name = "doubleClick", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getDoubleClick();

    /**
     * @return function that returns true if the event is a dblclick event
     */
    @JsProperty(name = "mouseOnly", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getMouseOnly();

    /**
     * @return function that always returns false
     */
    @JsProperty(name = "never", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getNever();

    /**
     * @return function that returns true if no modifier key (alt-, shift- or platform-modifier-key) is pressed.
     */
    @JsProperty(name = "noModifierKeys", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getNoModifierKeys();

    /**
     * @return function that returns true if the browser event is a pointermove event
     */
    @JsProperty(name = "platformModifierKeyOnly", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getPlatformModifierKeyOnly();

    /**
     * @return function that returns true if the browser event is a pointermove event
     */
    @JsProperty(name = "pointerMove", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getPointerMove();

    /**
     * @return function that returns true if the event originates from a primary pointer in contact with the surface or if the left mouse button is pressed.
     */
    @JsProperty(name = "primaryAction", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getPrimaryAction();

    /**
     * @return function that returns true if only the shift-key is pressed, false otherwise (e.g. when additionally the alt-key is pressed).
     */
    @JsProperty(name = "shiftKeyOnly", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getShiftKeyOnly();

    /**
     * @return function that returns true if the event is a map singleclick event, false otherwise.
     */
    @JsProperty(name = "singleClick", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getSingleClick();

    /**
     * @return function that returns true if the target element is not editable, i.e. not a <input>-, <select>- or <textarea>-element, false otherwise.
     */
    @JsProperty(name = "targetNotEditable", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getTargetNotEditable();

}
