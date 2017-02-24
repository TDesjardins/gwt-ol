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
package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;
import com.google.gwt.user.client.Window;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.Attribution;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.event.EventListener;
import ol.interaction.DragAndDrop;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.source.Stamen;
import ol.source.StamenOptions;

/**
 * Example with Tile-layers.
 *
 * @author Tino Desjardins
 *
 */
public class TileExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        LayerOptions stamenLayerOptions = OLFactory.createOptions();

        // create a Stamen-layer
        StamenOptions stamenOptions = OLFactory.createOptions();
        stamenOptions.setLayer("watercolor");

        Stamen stamenSource = new Stamen(stamenOptions);
        stamenLayerOptions.setSource(stamenSource);
        Tile stamenLayer = new Tile(stamenLayerOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = OLFactory.createCoordinate(1490463, 6894388);

        view.setCenter(centerCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        stamenLayer.setOpacity(0.5f);

        // add some controls
        map.addControl(new ScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        Attribution attribution = new Attribution();
        attribution.setCollapsed(true);

        map.addControl(attribution);

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());

        DragAndDrop dragAndDrop = new DragAndDrop();
        map.addInteraction(dragAndDrop);

        EventListener<DragAndDrop.Event> eventListener = new EventListener<DragAndDrop.Event>() {

            @Override
            public void onEvent(DragAndDrop.Event event) {
                Window.alert(String.valueOf(event.getFeatures().length));
                Window.alert(event.getProjection().getUnits());
                Window.alert(String.valueOf(event.getProjection().getMetersPerUnit()));

            }
        };

        dragAndDrop.on("addfeatures", eventListener);

        map.addControl(new Rotate());

        map.getLayers().push(stamenLayer);

    }

}

