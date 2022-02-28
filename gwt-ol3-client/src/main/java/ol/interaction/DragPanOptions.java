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
import ol.GenericFunction;
import ol.MapBrowserEvent;
import ol.Options;

/**
 * Options for {@link ol.interaction.DragZoom}.
 *
 * @author gkresic
 *
 * see https://openlayers.org/en/latest/apidoc/ol.interaction.DragZoom.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DragPanOptions implements Options {

    /**
     * @param condition A function that takes an {@link ol.MapBrowserEvent} and returns a boolean to indicate whether that event should be handled. Default is {@link ol.events.condition.Condition#getPrimaryAction()}.
     */
    @JsProperty
    public native void setCondition(GenericFunction<MapBrowserEvent, Boolean> condition);

    @JsProperty
    public native GenericFunction<MapBrowserEvent, Boolean> getCondition();
}
