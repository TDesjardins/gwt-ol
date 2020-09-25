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
/**
 *
 */
package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.constants.DemoConstants;
import com.google.gwt.core.client.Scheduler;

import java.util.Arrays;
import java.util.List;

import ol.Collection;
import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.View;
import ol.animation.AnimationOptions;
import ol.control.MousePosition;
import ol.control.MousePositionOptions;
import ol.control.ScaleLine;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.Osm;
import ol.source.XyzOptions;

/**
 * Example for animations.
 *
 * @author Tino Desjardins
 */
public class AnimationExample implements Example {

    private int currentLocationIndex = 0;

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show(String exampleId) {

        Coordinate centerCoordinate = new Coordinate(13.37, 52.52);
        Coordinate transformedMidPoint = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        // create an OSM-layer
        XyzOptions osmSourceOptions = new XyzOptions();
        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = new LayerOptions();
        osmLayerOptions.setSource(osmSource);
        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = new View();

        view.setCenter(transformedMidPoint);
        view.setZoom(16);

        // create the map
        MapOptions mapOptions = new MapOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Collection<Base> lstLayer = new Collection<Base>();
        lstLayer.push(osmLayer);
        mapOptions.setLayers(lstLayer);
        Map map = new Map(mapOptions);

        // add some controls
        map.addControl(new ScaleLine());

        MousePositionOptions mousePositionOptions = new MousePositionOptions();
        ProjectionOptions projectionOptions = new ProjectionOptions();
        projectionOptions.setCode(DemoConstants.EPSG_4326);
        mousePositionOptions.setProjection(new Projection(projectionOptions));

        MousePosition mousePosition = new MousePosition(mousePositionOptions);
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(5));
        map.addControl(mousePosition);

        Coordinate tvTowerCoordinate = Projection.transform(new Coordinate(13.409, 52.52), DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);
        Coordinate pplaceCoordinate = Projection.transform(new Coordinate(13.377, 52.509), DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);
        Coordinate zooCoordinate = Projection.transform(new Coordinate(13.338, 52.508), DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        final List<Coordinate> coordinates = Arrays.asList(transformedMidPoint, tvTowerCoordinate, pplaceCoordinate, zooCoordinate);

        Scheduler.get().scheduleFixedPeriod(() -> {

            int index = getNextIndex(coordinates.size());

            AnimationOptions panAnimationOptions = new AnimationOptions();
            panAnimationOptions.setDuration(2000);
            // Switch this to rotate the animation while animating.
            // panAnimationOptions.setRotation(view.getRotation() + 2 * Math.PI);
            panAnimationOptions.setCenter(coordinates.get(index));

            view.animate(panAnimationOptions);

            AnimationOptions zoomOutAnimationOptions = new AnimationOptions();
            zoomOutAnimationOptions.setDuration(1000);
            zoomOutAnimationOptions.setResolution(view.getResolution() + 4);

            AnimationOptions zoomInAnimationOptions = new AnimationOptions();
            zoomInAnimationOptions.setDuration(1000);
            zoomInAnimationOptions.setResolution(view.getResolution());

            view.animate(zoomOutAnimationOptions, zoomInAnimationOptions);

            return true;

        }, 6000);

    }

    private int getNextIndex(int range) {
        int index = (int)(Math.random() * range);
        if (this.currentLocationIndex == index) {
            index = this.getNextIndex(range);
        }

        this.currentLocationIndex = index;

        return index;
    }

}
