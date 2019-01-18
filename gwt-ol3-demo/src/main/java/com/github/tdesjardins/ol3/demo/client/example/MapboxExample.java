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

import ol.source.Xyz;
import ol.source.XyzOptions;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.Size;
import ol.View;
import ol.control.MousePosition;
import ol.layer.LayerOptions;
import ol.layer.Tile;

/**
 * Mapbox example using XYZ-Source.
 * 
 * @author Tino Desjardins
 *
 */
public class MapboxExample implements Example {

    /** This is the Mapbox access token of gwt-ol3. Please replace it with your own token if you want to integrate Mapbox in your application! */
    private static final String ACCESS_TOKEN = "pk.eyJ1IjoiZ3d0LW9sMyIsImEiOiJjaW0yMDM5aTgwMGxsdnVtNXNiNDg2b2VvIn0.qqoJgK-09q7UeOwh-hNtCA";

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        XyzOptions mapboxOptions = new XyzOptions();
        mapboxOptions.setTileSize(new Size(512, 512));
        mapboxOptions.setUrl("https://api.mapbox.com/styles/v1/mapbox/dark-v8/tiles/{z}/{x}/{y}?access_token=" + ACCESS_TOKEN);

        mapboxOptions.setAttributions("© <a href='https://www.mapbox.com/about/maps/'>Mapbox</a> © <a href='http://www.openstreetmap.org/copyright'>OpenStreetMap</a>");

        Xyz mapboxSource =  new Xyz(mapboxOptions);
        LayerOptions xyzLayerOptions = OLFactory.createOptions();
        xyzLayerOptions.setSource(mapboxSource);

        Tile mapboxLayer = new Tile(xyzLayerOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = new Coordinate(1490463, 6894388);
        view.setCenter(centerCoordinate);
        view.setZoom(10);

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

        map.addLayer(mapboxLayer);

    }

}

