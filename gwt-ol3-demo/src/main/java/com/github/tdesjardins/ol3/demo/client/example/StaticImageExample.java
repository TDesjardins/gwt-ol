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
import ol.OLFactory;
import ol.Size;
import ol.View;
import ol.ViewOptions;
import ol.layer.Base;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.ImageStatic;
import ol.source.ImageStaticOptions;

/**
 * Example with a StaticImage layer.
 *
 * @author Tino Desjardins
 *
 */
public class StaticImageExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        ProjectionOptions projectionOptions = OLFactory.createOptions();

        Extent imageExtent = new Extent(0, 0, 1024, 968);

        projectionOptions.setCode("pixel");
        projectionOptions.setExtent(imageExtent);
        projectionOptions.setUnits("pixels");

        Projection projection = new Projection(projectionOptions);

        ImageStaticOptions imageStaticOptions = OLFactory.createOptions();
        imageStaticOptions.setUrl("http://imgs.xkcd.com/comics/online_communities.png");
        imageStaticOptions.setImageSize(new Size(1024, 968));
        imageStaticOptions.setImageExtent(imageExtent);
        imageStaticOptions.setProjection(projection);

        // create attribution
        imageStaticOptions.setAttributions("&copy; <a href=\"http://xkcd.com/license.html\">xkcd</a>");

        ImageStatic imageStatic = new ImageStatic(imageStaticOptions);

        LayerOptions layerOptions = OLFactory.createOptions();
        layerOptions.setSource(imageStatic);
        Image image = new Image(layerOptions);

        Collection<Base> layers = new Collection<Base>();
        layers.push(image);

        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setCenter(new Coordinate(500, 500));
        viewOptions.setProjection(projection);
        viewOptions.setZoom(2);

        View view = new View(viewOptions);

        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);
        mapOptions.setLayers(layers);

        Map map = new Map(mapOptions);

        // add some controls
        DemoUtils.addDefaultControls(map.getControls());

        ol.control.Attribution attributionControl = new ol.control.Attribution();
        attributionControl.setCollapsed(false);

        map.addControl(attributionControl);

    }

}

