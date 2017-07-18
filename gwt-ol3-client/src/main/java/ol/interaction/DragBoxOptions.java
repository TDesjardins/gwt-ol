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
package ol.interaction;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.DragBoxEndConditionFunction;
import ol.GenericFunction;
import ol.MapBrowserEvent;
import ol.Options;

/**
 * Options for {@link ol.interaction.DragBox}.
 *
 * @author gkresic
 *
 * @see https://openlayers.org/en/latest/apidoc/ol.interaction.DragBox.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DragBoxOptions implements Options {

    /**
     * @param className CSS class name for styling the box. The default is <code>ol-dragbox</code>.
     */
    @JsProperty
    public native void setClassName(String className);

    @JsProperty
    public native String getClassName();

    /**
     * @param condition A function that takes an {@link ol.MapBrowserEvent} and returns a boolean to indicate whether that event should be handled. Default is {@link ol.events.condition.Condition#getShiftKeyOnly()}.
     */
    @JsProperty
    public native void setCondition(GenericFunction<MapBrowserEvent, Boolean> condition);

    @JsProperty
    public native GenericFunction<MapBrowserEvent, Boolean> getCondition();

    /**
     * @param minArea The minimum area of the box in pixel, this value is used by the default {@link #getBoxEndCondition()} function. Default is <code>64</code>.
     */
    @JsProperty
    public native void setMinArea(int minArea);

    @JsProperty
    public native int getMinArea();

    /**
     * @param boxEndCondition A function that takes a {@link ol.MapBrowserEvent} and two {@link ol.Pixel}s to indicate whether a <code>boxend</code> event should be fired. Default is <code>true</code> if the area of the box is bigger than the {@link #getMinArea()} option.
     */
    @JsProperty
    public native void setBoxEndCondition(DragBoxEndConditionFunction boxEndCondition);

    @JsProperty
    public native DragBoxEndConditionFunction getBoxEndCondition();

}
