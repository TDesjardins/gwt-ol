/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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
import ol.Feature;
import ol.style.Style;
import ol.GenericFunction;

/**
 * Vector data that is rendered client-side. Note that any property set in the
 * options is set as a {@link ol.Object} property on the layer object; for
 * example, setting `title: 'My Title'` in the options means that `title` is
 * observable, and has get/set accessors.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Vector extends Layer {


    public Vector() {}
    
    public Vector(VectorLayerOptions vectorLayerOptions) {}
    
    /**
     * Get the style for features. This returns whatever was passed to the
     * `style` option at construction or to the `setStyle` method.
     * 
     * @return {ol.style.Style|Array.<ol.style.Style>|ol.StyleFunction}
     *         Layer style.
     */
    public native ol.style.Style getStyle();

    /**
     * Set the style for features. This can be a single style object, an array
     * of styles, or a function that takes a feature and resolution and returns
     * an array of styles. If it is `undefined` the default style is used. If it
     * is `null` the layer has no style (a `null` style), so only features that
     * have their own styles will be rendered in the layer. See {@link ol.style}
     * for information on the default style.
     * 
     * @param style
     *            Layer style.
     */
    public native void setStyle(ol.style.Style style);

    public native void setStyle(GenericFunction<Feature, Style[]> style);

}
