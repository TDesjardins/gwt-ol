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

import com.github.tdesjardins.ol3.demo.client.constants.DemoConstants;

import ol.Coordinate;
import ol.source.Xyz;
import ol.source.XyzOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.MousePosition;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;

/**
 * Example with XYZ-Source.
 *
 * @author Tino Desjardins
 *
 */
public class XyzExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        XyzOptions xyzOptions = OLFactory.createOptions();
        xyzOptions.setUrl("http://server.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer/tile/{z}/{y}/{x}");

        xyzOptions.setAttributions("Tiles &copy; <a href=\"http://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer\">ArcGIS</a>");

        Xyz xyzSource =  new Xyz(xyzOptions);
        LayerOptions xyzLayerOptions = OLFactory.createOptions();
        xyzLayerOptions.setSource(xyzSource);

        Tile xyzLayer = new Tile(xyzLayerOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = new Coordinate(-121.1, 47.5);
        Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        view.setCenter(transformedCenterCoordinate);
        view.setZoom(7);

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
        map.addLayer(xyzLayer);

    }

}

