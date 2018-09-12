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

import ol.PluggableMap;
import ol.source.Source;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. A visual representation of raster or vector map data.
 * Layers group together those properties that pertain to how the data is to be
 * displayed, irrespective of the source of that data.
 *
 * Layers are usually added to a map with {@link ol.PluggableMap#addLayer}. Components
 * like {@link ol.interaction.Select} use unmanaged layers internally. These
 * unmanaged layers are associated with the map using
 * {@link ol.layer.Layer#setMap} instead.
 *
 * A generic `change` event is fired when the state of the source changes.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Layer extends Base {

    /**
     * Gets the source for this layer.
     *
     * @return source for this layer
     */
    public native <T extends Source> T getSource();

    /**
     * Sets the layer to be rendered on top of other layers on a map. The map
     * will not manage this layer in its layers collection, and the callback in
     * ol.PluggableMap#forEachLayerAtPixel will receive `null` as layer. This is
     * useful for temporary layers. To remove an unmanaged layer from the map,
     * use `#setMap(null)`.
     *
     * To add the layer to a map and have it managed by the map, use
     * {@link ol.PluggableMap#addLayer} instead.
     *
     * @param map
     *            Map.
     */
    public native void setMap(PluggableMap map);

    /**
     * Sets the source for this layer. If not provided to the constructor, the
     * source can be set by calling layer.setSource(source) after construction.
     *
     * @param source
     *            {@link Source}
     */
    public native void setSource(Source source);

}
