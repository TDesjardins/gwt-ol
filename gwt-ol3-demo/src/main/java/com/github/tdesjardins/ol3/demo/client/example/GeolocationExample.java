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
import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;
import com.google.gwt.user.client.Window;

import ol.Coordinate;
import ol.Feature;
import ol.Geolocation;
import ol.GeolocationOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.PositionOptions;
import ol.Size;
import ol.View;
import ol.ViewFitOptions;
import ol.ViewOptions;
import ol.control.Attribution;
import ol.control.ScaleLine;
import ol.events.Event;
import ol.geom.Point;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.Vector;
import ol.proj.Projection;
import ol.source.Osm;
import ol.source.XyzOptions;

/**
 * Example with Geolocation.
 *
 * @author Tino Desjardins
 *
 */
public class GeolocationExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create a OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();

        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = new Tile(osmLayerOptions);

        Vector vector = new Vector();

        // create a view
        ViewOptions viewOptions = OLFactory.createOptions();
        View view = new View(viewOptions);

        Coordinate centerCoordinate = new Coordinate(-0.1275, 51.507222);
        Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        view.setCenter(transformedCenterCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(osmLayer);
        map.addLayer(vector);

        // add some controls
        map.addControl(new ScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        Attribution attribution = new Attribution();
        attribution.setCollapsed(true);

        map.addControl(attribution);

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());

        ol.source.Vector vectorSource = new ol.source.Vector();
        vector.setSource(vectorSource);

        Feature positionFeature = new Feature();
        Feature accuracyFeature = new Feature();

        vectorSource.addFeature(accuracyFeature);
        vectorSource.addFeature(positionFeature);

        PositionOptions positionOptions = new PositionOptions();
        positionOptions.setEnableHighAccuracy(true);

        GeolocationOptions geolocationOptions = new GeolocationOptions();
        geolocationOptions.setTrackingOptions(positionOptions);
        geolocationOptions.setProjection(view.getProjection());

        Geolocation geolocation = new Geolocation(geolocationOptions);

        geolocation.addChangeListener((Event event) -> {

            positionFeature.setGeometry(new Point(geolocation.getPosition()));
            view.setCenter(geolocation.getPosition());

        });

        ViewFitOptions viewFitOptions = OLFactory.createOptions();
        viewFitOptions.setSize(new Size(100, 100));

        geolocation.on("change:accuracyGeometry", (Event event) -> {

            accuracyFeature.setGeometry(geolocation.getAccuracyGeometry());
            view.fit(geolocation.getAccuracyGeometry(), viewFitOptions);

        });

        geolocation.on("error", (Event event) -> {

            Window.alert("Could't determine location!");

        });

        // start tracking
        geolocation.setTracking(true);

    }

}

