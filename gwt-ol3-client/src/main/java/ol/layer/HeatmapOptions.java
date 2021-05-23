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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Heatmap options.
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class HeatmapOptions extends VectorLayerOptions {

    /**
     * @param gradient The color gradient of the heatmap, specified as
     * an array of CSS color strings.
     */
    @JsProperty
    public native void setGradient(String[] gradient);

    /**
     * @param radius radius size in pixels.
     */
    @JsProperty
    public native void setRadius(double radius);

    /**
     * @param blur blur size in pixels.
     */
    @JsProperty
    public native void setBlur(double blur);

    /**
     * @param weightAttribute The feature attribute to use for the weight
     */
    @JsProperty
    public native void setWeight(String weightAttribute);

    /**
     * @param heatmapWeightFunction function that calculates a weight
     * from a feature. Weight values should range from 0 to 1 (and values
     * outside will be clamped to that range).
     */
    @JsProperty
    public native void setWeight(HeatmapWeightFunction heatmapWeightFunction);

}
