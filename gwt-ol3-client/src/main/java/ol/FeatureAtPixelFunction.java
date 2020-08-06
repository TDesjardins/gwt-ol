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
import ol.layer.Layer;

/**
 * Callback for {@link PluggableMap#forEachFeatureAtPixel(Pixel, FeatureAtPixelFunction, FeatureAtPixelOptions)}
 *
 * @author gkresic
 */
@FunctionalInterface
@JsFunction
public interface FeatureAtPixelFunction {

    /**
     * @param feature feature or render feature at the pixel.
     * @param layer layer of the feature (null for unmanaged layers).
     * @return To stop detection, callback functions can return a truthy value.
     */
    boolean call(Feature feature, Layer layer);

}
