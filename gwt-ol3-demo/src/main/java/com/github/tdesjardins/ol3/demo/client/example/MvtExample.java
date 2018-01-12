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
package com.github.tdesjardins.ol3.demo.client.example;

import ol.source.VectorTile;
import ol.source.VectorTileOptions;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.View;
import ol.control.MousePosition;
import ol.format.Mvt;
import ol.layer.VectorTileLayerOptions;

/**
 * Mapbox vector tiles example.
 * 
 * @author Tino Desjardins
 *
 */
public class MvtExample implements Example {

    /** This is the Mapbox access token of gwt-ol3. Please replace it with your own token if you want to integrate Mapbox in your application! */
    private static final String ACCESS_TOKEN = "pk.eyJ1IjoiZ3d0LW9sMyIsImEiOiJjaW0yMDM5aTgwMGxsdnVtNXNiNDg2b2VvIn0.qqoJgK-09q7UeOwh-hNtCA";

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        VectorTileOptions vectorTileOptions = new VectorTileOptions();
        vectorTileOptions.setFormat(new Mvt());
        vectorTileOptions.setUrl("https://{a-d}.tiles.mapbox.com/v4/mapbox.mapbox-streets-v6/{z}/{x}/{y}.vector.pbf?access_token=" + ACCESS_TOKEN);
        vectorTileOptions.setAttributions("© <a href=\"https://www.mapbox.com/map-feedback/\">Mapbox</a> © <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap contributors</a>'");

        VectorTile vectorTile = new VectorTile(vectorTileOptions);

        VectorTileLayerOptions tileLayerOptions = new VectorTileLayerOptions();
        tileLayerOptions.setSource(vectorTile);

        ol.layer.VectorTile mvtLayer = new ol.layer.VectorTile(tileLayerOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = new Coordinate(0, 0);
        view.setCenter(centerCoordinate);
        view.setZoom(2);

        // create the map
        MapOptions mapOptions = new MapOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        ol.control.Attribution attributionControl = new ol.control.Attribution();
        attributionControl.setCollapsed(false);

        map.addControl(attributionControl);
        map.addControl(new MousePosition());
        map.addControl(DemoUtils.createMapboxLogo());

        map.addLayer(mvtLayer);

    }

}
