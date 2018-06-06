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
package ol.interaction;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.GenericFunction;
import ol.MapBrowserEvent;
import ol.Options;
import ol.SelectFilterFunction;
import ol.layer.Layer;

/**
 * Options for interaction {@link Select}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SelectOptions implements Options {

    /**
     * Hit-detection tolerance. Pixels inside the radius around the given position
     * will be checked for features. This only works for the canvas renderer and
     * not for WebGL. Default is 0.
     *
     * @param hitTolerance hit-detection tolerance
     */
    @JsProperty
    public native void setHitTolerance(int hitTolerance);

    /**
     *
     * Style for the selected features. By default the default edit style is used
     * (see ol.style).
     *
     * @param styleFunction
     */
    @JsProperty
    public native void setStyle(GenericFunction<?, ?> styleFunction);

    /**
     *
     * A list of layers from which features should be selected. Alternatively, a
     * filter function can be provided. The function will be called for each layer
     * in the map and should return true for layers that you want to be
     * selectable. If the option is absent, all visible layers will be considered
     * selectable.
     *
     * @param layers
     */
    @JsProperty
    public native void setLayers(Layer[] layers);

    /**
     *
     * A function that takes an ol.MapBrowserEvent and returns a boolean to
     * indicate whether that event should be handled. By default, this is
     * ol.events.condition.never. Use this if you want to use different events for
     * add and remove instead of toggle.
     *
     * @param function
     */
    @JsProperty
    public native void setRemoveCondition(GenericFunction<?, ?> function);

    /**
     *
     * A boolean that determines if the default behaviour should select only
     * single features or all (overlapping) features at the clicked map position.
     * Default is false i.e single select
     *
     * @param multi
     */
    @JsProperty
    public native void setMulti(boolean multi);

    /**
     *
     * A function that takes an ol.MapBrowserEvent and returns a boolean to
     * indicate whether that event should be handled. This is in addition to the
     * condition event. By default, ol.events.condition.shiftKeyOnly, i.e.
     * pressing shift as well as the condition event, adds that feature to the
     * current selection if it is not currently selected, and removes it if it is.
     * See add and remove if you want to use different events instead of a toggle.
     *
     * @param function
     */
    @JsProperty
    public native void setToggleCondition(GenericFunction<?, ?> function);

    /**
     * Collection where the interaction will place selected features. Optional. If
     * not set the interaction will create a collection. In any case the
     * collection used by the interaction is returned by
     * ol.interaction.Select#getFeatures.
     *
     * @param features
     */
    @JsProperty
    public native void setFeatures(Collection<Feature> features);

    /**
     * A function that takes an ol.Feature and an ol.layer.Layer and returns true
     * if the feature may be selected or false otherwise.
     *
     * @param function
     */
    @JsProperty
    public native void setFilter(SelectFilterFunction function);

    /**
     * A function that takes an ol.MapBrowserEvent and returns a boolean
     * to indicate whether that event should be handled.
     * By default, this is ol.events.condition.never.
     * Use this if you want to use different events for add and remove instead of toggle.
     *
     * @param function
     */
    @JsProperty
    public native void setAddCondition(GenericFunction<?, ?> function);

    /**
     * A function that takes an ol.MapBrowserEvent and returns a boolean to indicate whether that event should be handled.
     * This is the event for the selected features as a whole. By default, this is ol.events.condition.singleClick.
     * Clicking on a feature selects that feature and removes any that were in the selection.
     * Clicking outside any feature removes all from the selection.
     * See toggle, add, remove options for adding/removing extra features to/ from the selection.
     *
     * @param function
     */
    @JsProperty
    public native void setCondition(GenericFunction<MapBrowserEvent, Boolean> function);

    /**
     * Wrap the world horizontally on the selection overlay. Default is true.
     *
     * @param wrapX
     */
    @JsProperty
    public native void setWrapX(boolean wrapX);

}
