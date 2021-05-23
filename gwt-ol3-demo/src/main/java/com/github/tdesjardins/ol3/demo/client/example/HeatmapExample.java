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
package com.github.tdesjardins.ol3.demo.client.example;

import ol.Coordinate;
import ol.Feature;
import ol.source.Stamen;
import ol.source.StamenOptions;
import ol.source.VectorOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.MousePosition;
import ol.format.Kml;
import ol.format.KmlOptions;
import ol.layer.Heatmap;
import ol.layer.HeatmapOptions;
import ol.layer.LayerOptions;
import ol.layer.Tile;

/**
 * Example with heatmap.
 *
 * @author Tino Desjardins
 *
 */
public class HeatmapExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        StamenOptions stamenOptions = new StamenOptions();
        stamenOptions.setLayer("toner");

        Stamen stamen = new Stamen(stamenOptions);

        LayerOptions rasterLayerOptions = OLFactory.createOptions();
        rasterLayerOptions.setSource(stamen);

        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setUrl("https://openlayers.org/en/latest/examples/data/kml/2012_Earthquakes_Mag5.kml");
        KmlOptions kmlOptions = new KmlOptions();
        kmlOptions.setExtractStyles(false);
        Kml kml = new Kml(kmlOptions);
        vectorOptions.setFormat(kml);

        ol.source.Vector vectorSource = new ol.source.Vector(vectorOptions);

        Tile stamenLayer = new Tile(rasterLayerOptions);

        HeatmapOptions heatmapOptions = new HeatmapOptions();
        heatmapOptions.setSource(vectorSource);
        heatmapOptions.setBlur(15);
        heatmapOptions.setRadius(8);
        heatmapOptions.setWeight((Feature feature) -> {

            String magnitudeValue = feature.get("name");
            String parsedMagnitude = magnitudeValue.substring(2);
            parsedMagnitude = parsedMagnitude.substring(0, parsedMagnitude.indexOf(" "));

            return Double.parseDouble(parsedMagnitude) - 5;

        });

        Heatmap heatmapLayer = new Heatmap(heatmapOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = new Coordinate(0, 0);
        view.setCenter(centerCoordinate);
        view.setZoom(2);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        ol.control.Attribution attributionControl = new ol.control.Attribution();
        attributionControl.setCollapsed(false);

        map.addControl(attributionControl);
        MousePosition mousePosition = new MousePosition();
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(2));
        map.addControl(mousePosition);
        map.addLayer(stamenLayer);
        map.addLayer(heatmapLayer);

    }

}

