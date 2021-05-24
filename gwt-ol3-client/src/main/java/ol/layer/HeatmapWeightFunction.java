/*******************************************************************************
 * Copyright 2014, 2021 gwt-ol
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
package ol.layer;

import jsinterop.annotations.JsFunction;
import ol.Feature;

/**
 * A function that returns a weight from a feature. Weight values should range
 * from 0 to 1 (and values outside will be clamped to that range)
 */
@FunctionalInterface
@JsFunction
public interface HeatmapWeightFunction {

    /**
     * @param feature feature for calculating the weight
     * @return weight
     */
    double getWeight(Feature feature);

}