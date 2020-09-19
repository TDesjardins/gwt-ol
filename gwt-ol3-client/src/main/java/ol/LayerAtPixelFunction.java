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

import jsinterop.annotations.JsFunction;
import ol.color.Color;
import ol.layer.Layer;

/**
 * Callback for {@link PluggableMap#forEachFeatureAtPixel(Pixel, LayerAtPixelFunction, FeatureAtPixelOptions)}
 */
@FunctionalInterface
@JsFunction
public interface LayerAtPixelFunction {

    /**
     *
     * @param layer layer
     * @param color [R, G, B, A] pixel values (0 - 255), will be null for layer types that do not currently support this argument
     * @return To stop detection, callback functions can return a truthy value.
     */
    boolean call(Layer layer, Color color);

}
