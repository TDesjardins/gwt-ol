/*******************************************************************************
 * Copyright 2014, 2020 gwt-ol
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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.layer.Base;
import ol.layer.Layer;

/**
 * Options for customizing {@link PluggableMap#forEachFeatureAtPixel(Pixel, FeatureAtPixelFunction, AtPixelOptions)} and
 * {@link PluggableMap#forEachLayerAtPixel(Pixel, LayerAtPixelFunction, AtPixelOptions)}.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class AtPixelOptions implements Options {

    /**
     * <p>Defines layer filter function. The filter function will receive one argument, the <code>layer-candidate</code> and it should return a <code>boolean</code> value.
     * Only layers which are visible and for which this function returns <code>true</code> will be tested for features.
     * By default, all visible layers will be tested.<p>
     *
     * @param layerFilter Layer filter function
     */
    @JsProperty
    public native void setLayerFilter(GenericFunction<Layer, Boolean> layerFilter);

    @JsProperty
    public native GenericFunction<Base, Boolean> getLayerFilter();

    /**
     * Defines hit-detection tolerance in pixels. Pixels inside the radius around the given position will be checked for features.
     * This only works for the canvas renderer and not for WebGL. Default is <code>0</code>.
     *
     * @param hitTolerance Hit-detection tolerance in pixels.
     */
    @JsProperty
    public native void setHitTolerance(int hitTolerance);

    @JsProperty
    public native int getHitTolerance();

}
