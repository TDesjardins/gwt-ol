/**
 *
 */
package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;
import com.google.gwt.core.client.JavaScriptObject;

import ol.Collection;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.format.GeoJSON;
import ol.geom.LineString;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.VectorLayerOptions;
import ol.source.Osm;
import ol.source.Vector;
import ol.source.VectorOptions;
import ol.source.XyzOptions;

/**
 * Example of GeoJSON format.
 *
 * @author Tobias Lochmann
 */
public class GeoJSONExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show(String exampleId) {

        // create linestring
        Coordinate coordinate1 = OLFactory.createCoordinate(4e6, 2e6);
        Coordinate coordinate2 = OLFactory.createCoordinate(8e6, -2e6);
        Coordinate[] coordinates = { coordinate1, coordinate2 };

        LineString lineString = new LineString(coordinates);

        // create feature
        FeatureOptions featureOptions = OLFactory.createOptions();
        featureOptions.setGeometry(lineString);
        Feature feature = new Feature(featureOptions);

        // convert feature to GeoJSON
        GeoJSON geoJsonFormat = new GeoJSON();
        JavaScriptObject geoJSON = geoJsonFormat.writeFeatureObject(feature, null);

        // convert features from GeoJSON
        Feature featureGeoJSON = geoJsonFormat.readFeature(geoJSON, null);

        // show converted features
        Collection<Feature> lstFeatures = new Collection<Feature>();
        lstFeatures.push(featureGeoJSON);

        VectorOptions vectorSourceOptions = OLFactory.createOptions();
        vectorSourceOptions.setFeatures(OLFactory.<Feature[], Collection<Feature>> createObject2(lstFeatures));
        Vector vectorSource = new Vector(vectorSourceOptions);

        VectorLayerOptions vectorLayerOptions = OLFactory.createOptions();
        vectorLayerOptions.setSource(vectorSource);
        ol.layer.Vector vectorLayer = new ol.layer.Vector(vectorLayerOptions);

        // create a OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();
        Osm osmSource = new Osm(osmSourceOptions);

        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = new View();
        Coordinate centerCoordinate = OLFactory.createCoordinate(0, 0);
        view.setCenter(centerCoordinate);
        view.setZoom(2);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
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
