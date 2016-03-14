/**
 *
 */
package de.desjardins.ol3.demo.client.example;

import com.google.gwt.core.client.GWT;

import de.desjardins.ol3.demo.client.utils.DemoUtils;

import ol.Collection;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.format.GeoJSON;
import ol.geom.LineString;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.VectorLayerOptions;
import ol.source.Osm;
import ol.source.Vector;
import ol.source.VectorOptions;
import ol.source.XyzOptions;

/**
 * Example of GeoJSON
 *
 * @author Tobias Lochmann
 */
public class GeoJSONExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show() {

        // Create Linstring
        Coordinate coordinate1 = OLFactory.createCoordinate(4e6, 2e6);
        Coordinate coordinate2 = OLFactory.createCoordinate(8e6, -2e6);
        Coordinate[] coordinates = { coordinate1, coordinate2 };
        LineString ls = OLFactory.createLineString(coordinates);

        // Create featrue
        FeatureOptions featureOptions = OLFactory.createOptions();
        featureOptions.setGeometry(ls);
        Feature feature = OLFactory.createFeature(featureOptions);

        GWT.log("Feature: " + feature);

        // Convert Feature to GeoJson
        GeoJSON gj = OLFactory.createGeoJSON();
        GeoJSON geoJSON = gj.writeFeatureObject(feature, null);

        // Convert Features from GeoJSON
        Feature featureGeoJSON = gj.readFeature(geoJSON, null);

        // show converted Features
        Collection<Feature> lstFeatures = OLFactory.createCollection();
        lstFeatures.push(featureGeoJSON);
        VectorOptions vectorSourceOptions = OLFactory.createOptions();
        vectorSourceOptions.setFeatures(OLFactory.<Feature[], Collection<Feature>> createObject2(lstFeatures));
        Vector vectorSource = OLFactory.createVectorSource(vectorSourceOptions);

        VectorLayerOptions vectorLayerOptions = OLFactory.createOptions();
        vectorLayerOptions.setSource(vectorSource);
        ol.layer.Vector vectorLayer = OLFactory.createVector(vectorLayerOptions);

        // create a OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();
        Osm osmSource = OLFactory.createOsm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);
        Tile osmLayer = OLFactory.createTileLayer(osmLayerOptions);

        // create a view
        View view = OLFactory.createView();
        Coordinate centerCoordinate = OLFactory.createCoordinate(0, 0);
        view.setCenter(centerCoordinate);
        view.setZoom(2);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);
        Collection<Base> lstLayer = OLFactory.createCollection();
        lstLayer.push(osmLayer);
        lstLayer.push(vectorLayer);
        mapOptions.setLayers(lstLayer);
        Map map = OLFactory.createMap(mapOptions);

        // add some controls
        map.addControl(OLFactory.createScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        // add some interactions
        map.addInteraction(OLFactory.createKeyboardPan());
        map.addInteraction(OLFactory.createKeyboardZoom());
        map.addControl(OLFactory.createRotate());

    }

}
