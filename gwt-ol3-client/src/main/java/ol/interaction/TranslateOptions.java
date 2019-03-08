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
import ol.Options;
import ol.layer.Layer;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TranslateOptions implements Options {

    /**
     * Only features contained in this collection will be able to be translated. If not specified, all features on the map will be able to be translated.
     *
     * @param features
     */
    @JsProperty
    public native void setFeatures(Collection<Feature> features);
	
	/**
	 * A list of layers from which features should be translated. Alternatively,
	 * a filter function can be provided. The function will be called for each
	 * layer in the map and should return true for layers that you want to be
	 * translatable. If the option is absent, all visible layers will be
	 * considered translatable.
	 * 
	 * @param layer
	 */
	@JsProperty
	public native void setLayers(Layer[] layer);

}
