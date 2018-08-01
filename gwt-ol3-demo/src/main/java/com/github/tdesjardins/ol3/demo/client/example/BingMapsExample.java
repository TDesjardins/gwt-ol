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
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.Attribution;
import ol.control.ScaleLine;
import ol.control.ZoomSlider;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.BingMaps;
import ol.source.BingMapsOptions;

/**
 * Example with BingMaps source.
 *
 * @author Tino Desjardins
 *
 */
public class BingMapsExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create a BingMaps layer
        BingMapsOptions bingMapsOptions = OLFactory.createOptions();

        // This is the Bing Maps key of gwt-ol3. You can get your Bing Maps Key from http://www.bingmapsportal.com/
        bingMapsOptions.setKey("Ait3bjnyw1A9Stlcm3o8B8X7nqMMVt9P8T2vWUvswLuagnLz6Fl9AiErBAFuSX74");
        bingMapsOptions.setImagerySet("Aerial");
        bingMapsOptions.setMaxZoom(19);

        BingMaps bingMapsSource = new BingMaps(bingMapsOptions);

        LayerOptions layerOptions = OLFactory.createOptions();
        layerOptions.setSource(bingMapsSource);

        Tile bingLayer = new Tile(layerOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = new Coordinate(-0.1275, 51.507222);
        Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        view.setCenter(transformedCenterCoordinate);
        view.setZoom(13);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(bingLayer);

        // add some controls
        map.addControl(new ScaleLine());

        Attribution attribution = new Attribution();
        attribution.setCollapsed(true);

        map.addControl(attribution);
        map.addControl(new ZoomSlider());

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());

    }

}
