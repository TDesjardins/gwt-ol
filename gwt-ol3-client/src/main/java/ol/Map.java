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
package ol;

import jsinterop.annotations.JsType;

/**
 * The map is the core component of OpenLayers. For a map to render, a view, one
 * or more layers, and a target container are needed:
 *
 * var map = new ol.Map({ view: new ol.View({ center: [0, 0], zoom: 1 }),
 * layers: [ new ol.layer.Tile({ source: new ol.source.MapQuest({layer: 'osm'})
 * }) ], target: 'map' });
 *
 * The above snippet creates a map using a {@link ol.layer.Tile} to display
 * OSM data and render it to a DOM element with the id `map`.
 *
 * The constructor places a viewport container (with CSS class name
 * `ol-viewport`) in the target element (see `getViewport()`), and then two
 * further elements within the viewport: one with CSS class name
 * `ol-overlaycontainer-stopevent` for controls and some overlays, and one with
 * CSS class name `ol-overlaycontainer` for other overlays (see the `stopEvent`
 * option of {@link ol.Overlay} for the difference). The map itself is placed in
 * a further element within the viewport, either DOM or Canvas, depending on the
 * renderer.
 *
 * Layers are stored as a `ol.Collection` in layerGroups. A top-level group is
 * provided by the library. This is what is accessed by `getLayerGroup` and
 * `setLayerGroup`. Layers entered in the options are added to this group, and
 * `addLayer` and `removeLayer` change the layer collection in the group.
 * `getLayers` is a convenience function for `getLayerGroup().getLayers()`. Note
 * that `ol.layer.Group` is a subclass of `ol.layer.Base`, so layers entered in
 * the options or added with `addLayer` can be groups, which can contain further
 * groups, and so on.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public class Map extends PluggableMap {

    public Map(MapOptions mapOptions) {}

}
