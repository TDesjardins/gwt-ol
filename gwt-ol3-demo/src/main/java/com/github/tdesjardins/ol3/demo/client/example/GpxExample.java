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
package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.Attribution;
import ol.control.ScaleLine;
import ol.format.Gpx;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.VectorLayerOptions;
import ol.source.Osm;
import ol.source.VectorOptions;

/**
 * Example with GPX Layers.
 *
 * @author Eric Smets
 *
 */
public class GpxExample implements Example{

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create a OSM-layer
        Osm osmSource = new Osm();
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = new Tile(osmLayerOptions);

        // create a GPX vector layer
        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setUrl("https://openlayers.org/en/v5.3.0/examples/data/gpx/fells_loop.gpx");
        vectorOptions.setFormat(new Gpx());

        ol.source.Vector vectorSource = new ol.source.Vector(vectorOptions);
        VectorLayerOptions vectorLayerOptions = new VectorLayerOptions();
        vectorLayerOptions.setSource(vectorSource);
        ol.layer.Vector gpxLayer = new ol.layer.Vector(vectorLayerOptions);

        // create a view
        View view = new View();

        Coordinate center = new Coordinate(-7916041.528716288, 5228379.045749711);

        view.setCenter(center);
        view.setZoom(12);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(osmLayer);
        map.addLayer(gpxLayer);

        // add some controls
        map.addControl(new ScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        Attribution attribution = new Attribution();
        attribution.setCollapsed(true);

        map.addControl(attribution);

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());

    }

}

