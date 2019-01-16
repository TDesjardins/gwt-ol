/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol3
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
import ol.Collection;
import ol.Feature;
import ol.GenericFunction;
import ol.Options;
import ol.style.StyleFunction;

/**
 * Interaction for modifying feature geometries.
 *
 * @author guandalini
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ModifyOptions implements Options {

    /**
     * A function that takes an ol.MapBrowserEvent and returns a boolean to
     * indicate whether that event will be considered to add or move a vertex to
     * the sketch. Default is ol.events.condition.primaryAction.
     *
     * @param function
     */
    @JsProperty
    public native void setCondition(GenericFunction<?, ?> function);

    /**
     * A function that takes an ol.MapBrowserEvent and returns a boolean to
     * indicate whether that event should be handled. By default,
     * ol.events.condition.singleClick with ol.events.condition.noModifierKeys
     * results in a vertex deletion.
     *
     * @param function
     */
    @JsProperty
    public native void setDeleteCondition(GenericFunction<?, ?> function);

    /**
     * Pixel tolerance for considering the pointer close enough to a segment or
     * vertex for editing. Default is 10.
     *
     * @param clickTolerance
     */
    @JsProperty
    public native void setPixelTolerance(int clickTolerance);

    /**
     * Style used for the features being modified. By default the default edit
     * style is used (see ol.style).
     *
     * @param styleFunction
     */
    @JsProperty
    public native void setStyle(StyleFunction styleFunction);

    /**
     * The features the interaction works on. Required.
     *
     * @param features
     */
    @JsProperty
    public native void setFeatures(Collection<Feature> features);

    /**
     * Wrap the world horizontally on the sketch overlay. Default is false.
     *
     * @param wrapX
     */
    @JsProperty
    public native void setWrapX(boolean wrapX);

}