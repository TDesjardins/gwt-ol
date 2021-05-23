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

import jsinterop.annotations.JsType;

/**
 * Layer for rendering vector data as a heatmap. Note that any property set in the
 * options is set as a {@link ol.Object} property on the layer object;
 * for example, setting title: 'My Title' in the options means that title is
 * observable, and has get/set accessors.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Heatmap extends Vector {

    public Heatmap() {}

    public Heatmap(HeatmapOptions vectorLayerOptions) {}

    /**
     * @return blur size in pixels.
     */
    public native double getBlur();

    /**
     * @param blur blur size in pixels.
     */
    public native void setBlur(double blur);

    /**
     * @return gradient colors.
     */
    public native String[] getGradient();

    /**
     * Default gradient: {"#00f", "#0ff", "#0f0", "#ff0", "#f00"}
     * 
     * @param gradient gradient colors.
     */
    public native void setGradient(String[] gradient);

    /**
     * @return radius size in pixels.
     */
    public native double getRadius();

    
    /**
     * @param radius radius size in pixels.
     */
    public native void setRadius(double radius);

}
