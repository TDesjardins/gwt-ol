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

import java.util.ArrayList;
import java.util.List;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Collection;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.GenericFunction;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.color.Color;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.geom.Point;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.VectorLayerOptions;
import ol.source.Cluster;
import ol.source.ClusterOptions;
import ol.source.Osm;
import ol.source.Vector;
import ol.source.VectorOptions;
import ol.source.XyzOptions;
import ol.style.Circle;
import ol.style.CircleOptions;
import ol.style.Style;
import ol.style.StyleOptions;
import ol.style.Text;
import ol.style.TextOptions;

/**
 * Example about using clusters.
 *
 * @author mazlixek
 */
public class ClusterExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show(String exampleId) {

        Collection<Feature> features = new Collection<Feature>();
        int e = 450000;

        for (int i = 0; i < 20000; ++i) {
            // create a point
            Coordinate coordinate = new Coordinate(2 * e * Math.random() - e, 2 * e * Math.random() - e);
            Point point = new Point(coordinate);

            // create feature
            FeatureOptions featureOptions = new FeatureOptions();
            featureOptions.setGeometry(point);
            Feature feature = new Feature(featureOptions);

            features.push(feature);
        }

        // create source
        VectorOptions vectorSourceOptions = new VectorOptions();
        vectorSourceOptions.setFeatures(features);
        Vector vectorSource = new Vector(vectorSourceOptions);

        // create clustering
        ClusterOptions clusterOptions = new ClusterOptions();
        clusterOptions.setDistance(40);
        clusterOptions.setSource(vectorSource);
        Cluster clusterSource = new Cluster(clusterOptions);

        // create vector layer
        VectorLayerOptions vectorLayerOptions = new VectorLayerOptions();
        vectorLayerOptions.setSource(clusterSource);
        vectorLayerOptions.setStyle(new GenericFunction<Feature, Style[]>() {

            @Override
            public Style[] call(Feature cluster) {
                // create style
                List<Style> style = new ArrayList<>();

                Feature[] features = (Feature[])cluster.get("features");
                int clusterSize = features.length;

                StyleOptions styleOptions = new StyleOptions();

                TextOptions textOptions = new TextOptions();
                textOptions.setText(String.valueOf(clusterSize));
                styleOptions.setText(new Text(textOptions));

                CircleOptions circleOptions = new CircleOptions();
                circleOptions.setRadius(10);
                Color color = Color.getColorFromString("#3399CC");
                circleOptions.setFill(OLFactory.createFill(color));
                styleOptions.setImage(new Circle(circleOptions));
                style.add(new Style(styleOptions));

                return style.toArray(new Style[0]);
            }
        });

        ol.layer.Vector vectorLayer = new ol.layer.Vector(vectorLayerOptions);

        // create a OSM-layer
        XyzOptions osmSourceOptions = new XyzOptions();
        Osm osmSource = new Osm(osmSourceOptions);

        LayerOptions osmLayerOptions = new LayerOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = new View();
        Coordinate centerCoordinate = new Coordinate(0, 0);
        view.setCenter(centerCoordinate);
        view.setZoom(2);

        // create the map
        MapOptions mapOptions = new MapOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);
        Collection<Base> lstLayer = new Collection<Base>();
        lstLayer.push(osmLayer);
        lstLayer.push(vectorLayer);
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
