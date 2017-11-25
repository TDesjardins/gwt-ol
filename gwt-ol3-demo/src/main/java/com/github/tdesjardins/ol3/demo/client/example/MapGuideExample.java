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

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Collection;
import ol.Coordinate;
import ol.Extent;
import ol.Map;
import ol.MapOptions;
import ol.View;
import ol.ViewOptions;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.Base;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.proj.Projection;
import ol.source.ImageMapGuide;
import ol.source.ImageMapGuideOptions;
import ol.source.ImageMapGuideParams;

/**
 * Example with MapGuide layers.
 *
 * @author Tobias Lochmann
 *
 */
public class MapGuideExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create a projection
        Projection projection = Projection.get("EPSG:4326");

        // create a MapGuide params
        ImageMapGuideParams imageMapGuideParams = new ImageMapGuideParams();
        imageMapGuideParams.setFormat("PNG");
        imageMapGuideParams.setMapDefinition("Library://Public/Samples/Sheboygan/Maps/Sheboygan.MapDefinition");
        imageMapGuideParams.setUserName("OpenLayers");
        imageMapGuideParams.setPassword("OpenLayers");

    	// create a MapGuide image
        ImageMapGuideOptions imageMapGuideOptions = new ImageMapGuideOptions();
        imageMapGuideOptions.setParams(imageMapGuideParams);
        imageMapGuideOptions.setUrl("http://www.buoyshark.com/mapguide/mapagent/mapagent.fcgi?");
        imageMapGuideOptions.setUseOverlay(false);
        imageMapGuideOptions.setMetersPerUnit(111319.4908d);
        imageMapGuideOptions.setRatio(2.0f);

        ImageMapGuide imageMapGuideSource = new ImageMapGuide(imageMapGuideOptions);
        LayerOptions layerOptions = new LayerOptions();
        Extent bounds = new Extent(-87.865114442365922d,43.665065564837931d,-87.595394059497067d,43.823852564430069d);
        layerOptions.setExtent(bounds);
        layerOptions.setSource(imageMapGuideSource);
        Image mapGuideLayer = new Image(layerOptions);

        // create a view
        ViewOptions viewOptions = new ViewOptions();
        viewOptions.setProjection(projection);
        viewOptions.setZoom(12.0d);
        Coordinate centerCoordinate = new Coordinate(-87.7302542509315d, 43.744459064634d);
        viewOptions.setCenter(centerCoordinate);
        View view = new View(viewOptions);

        // create the map
        MapOptions mapOptions = new MapOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);
        Collection<Base> lstLayer = new Collection<Base>();
        lstLayer.push(mapGuideLayer);
        mapOptions.setLayers(lstLayer);
        Map map = new Map(mapOptions);

        // add some controls
        map.addControl(new ScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());
        map.addControl(new Rotate());

    }

}

