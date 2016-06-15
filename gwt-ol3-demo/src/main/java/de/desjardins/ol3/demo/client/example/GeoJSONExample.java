/**
 *
 */
package de.desjardins.ol3.demo.client.example;

import com.google.gwt.core.client.GWT;

import de.desjardins.ol3.demo.client.utils.DemoUtils;
import ol.*;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.format.GeoJSON;
import ol.geom.LineString;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.*;
import ol.layer.Tile;
import ol.source.*;
import ol.source.Vector;

/**
 * Example of GeoJSON format.
 *
 * @author Tobias Lochmann
 */
public class GeoJSONExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show() {

        // Create Linestring
        Coordinate coordinate1 = OLFactory.createCoordinate(4e6, 2e6);
        Coordinate coordinate2 = OLFactory.createCoordinate(8e6, -2e6);
        Coordinate[] coordinates = { coordinate1, coordinate2 };
        LineString lineString = OLFactory.createLineString(coordinates);

        // Create feature
        FeatureOptions featureOptions = OLFactory.createOptions();
        featureOptions.setGeometry(lineString);
        Feature feature = new Feature(featureOptions);
        GWT.log("Feature: " + feature);

        // Convert Feature to GeoJson
        GeoJSON gj = new GeoJSON();
        GeoJSON geoJSON = gj.writeFeatureObject(feature, null);

        // Convert Features from GeoJSON
        Feature featureGeoJSON = gj.readFeature(geoJSON, null);

        // show converted Features
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
        mapOptions.setTarget("map");
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
