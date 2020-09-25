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

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.MousePosition;
import ol.control.OverviewMap;
import ol.control.ZoomSlider;
import ol.control.ZoomToExtent;
import ol.layer.Graticule;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.source.Osm;
import ol.source.XyzOptions;

/**
 * Example for Graticule.
 *
 * @author Tino Desjardins
 *
 */
public class GraticuleExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create an OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();

        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = new Coordinate(1490463, 6894388);

        view.setCenter(centerCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(osmLayer);

        // add some controls
        map.addControl(new ZoomSlider());
        MousePosition mousePosition = new MousePosition();
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(2));
        map.addControl(mousePosition);
        map.addControl(new ZoomToExtent());
        
        OverviewMap overviewMap = new OverviewMap();
        map.addControl(overviewMap);

        Graticule graticule = new Graticule();
        graticule.setMap(map);

    }

}

