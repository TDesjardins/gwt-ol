/**
 *
 */
package de.desjardins.ol3.demo.client.example;

import com.google.gwt.core.client.JavaScriptObject;

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
 * Example of GeoJSON format.
 *
 * @author Tobias Lochmann
 */
public class GeoJSONExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show() {

        // create linestring
        Coordinate coordinate1 = OLFactory.createCoordinate(4e6, 2e6);
        Coordinate coordinate2 = OLFactory.createCoordinate(8e6, -2e6);
        Coordinate[] coordinates = { coordinate1, coordinate2 };
        LineString lineString = OLFactory.createLineString(coordinates);

        // create feature
        FeatureOptions featureOptions = OLFactory.createOptions();
        featureOptions.setGeometry(lineString);
        Feature feature = OLFactory.createFeature(featureOptions);

        // convert feature to GeoJSON
        GeoJSON geoJsonFormat = OLFactory.createGeoJSON();
        JavaScriptObject geoJSON = geoJsonFormat.writeFeatureObject(feature, null);

        // convert features from GeoJSON
        Feature featureGeoJSON = geoJsonFormat.readFeature(geoJSON, null);

        // show converted features
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
