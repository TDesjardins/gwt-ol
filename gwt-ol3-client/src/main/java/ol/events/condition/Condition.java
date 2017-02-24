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
     * @return function that always returns false
     */
    @JsProperty(name = "never", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getNever();
    
    /**
     * @return function that returns true if the browser event is a pointermove event
     */
    @JsProperty(name = "pointerMove", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getPointerMove();
    
}
