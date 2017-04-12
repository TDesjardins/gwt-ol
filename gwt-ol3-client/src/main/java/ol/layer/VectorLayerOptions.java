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
package ol.layer;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Feature;
import ol.GenericFunction;
import ol.Map;
import ol.style.Style;

/**
 * Vector layer options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class VectorLayerOptions extends LayerOptions {
    /**
     *
     * Sets the layer as overlay on a map. The map will not manage this layer in
     * its layers collection, and the layer will be rendered on top. This is
     * useful for temporary layers. The standard way to add a layer to a map and
     * have it managed by the map is to use {@link ol.Map#addLayer(Base)}.
     *
     * @param map {@link Map}
     */
    @JsProperty
    public native void setMap(Map map);

    /**
     * The buffer around the viewport extent used by the renderer when getting
     * features from the vector source for the rendering or hit-detection.
     * Recommended value: the size of the largest symbol, line width or label.
     * Default is 100 pixels.
     *
     * @param renderBuffer render buffer
     */
    @JsProperty
    public native void setRenderBuffer(double renderBuffer);

    @JsProperty
    public native void setStyle(Style style);

    /**
     * Layer style. See ol.style for default style which will be used if this is
     * not defined.
     *
     * @param style {@link Style}
     */
    @JsProperty
    public native void setStyle(Style[] style);
    
    @JsProperty
    public native void setStyle(GenericFunction<Feature, Style[]> style);

    /**
     * When set to true, feature batches will be recreated during animations.
     * This means that no vectors will be shown clipped, but the setting will
     * have a performance impact for large amounts of vector data. When set to
     * false, batches will be recreated when no animation is active. Default is
     * false.
     *
     * @param updateWhileAnimating update while animating?
     */
    @JsProperty
    public native void setUpdateWhileAnimating(boolean updateWhileAnimating);

    /**
     * When set to true, feature batches will be recreated during interactions.
     * See also updateWhileAnimating. Default is false.
     *
     * @param updateWhileInteracting update while interacting?
     */
    @JsProperty
    public native void setUpdateWhileInteracting(boolean updateWhileInteracting);

}
