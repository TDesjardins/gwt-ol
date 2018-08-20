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
package ol.layer;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.PluggableMap;

/**
 * Tile layer options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileLayerOptions extends LayerOptions {

    /**
     *
     * Sets the layer as overlay on a map. The map will not manage this layer in
     * its layers collection, and the layer will be rendered on top. This is
     * useful for temporary layers. The standard way to add a layer to a map and
     * have it managed by the map is to use {@link ol.PluggableMap#addLayer(Base)}.
     *
     * @param map {@link ol.PluggableMap}
     */
    @JsProperty
    public native void setMap(PluggableMap map);

    /**
     * Preload. Load low-resolution tiles up to preload levels. By default
     * preload is 0, which means no preloading.
     *
     * @param preload preload levels
     */
    @JsProperty
    public native void setPreLoad(int preload);

    /**
     * Use interim tiles on error. Default is true.
     *
     * @param useInterimTilesOnError use interim tiles on error?
     */
    @JsProperty
    public native void setUseInterimTilesOnError(boolean useInterimTilesOnError);

}
