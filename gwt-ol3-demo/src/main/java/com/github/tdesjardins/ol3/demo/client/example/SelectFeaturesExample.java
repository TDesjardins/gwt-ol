/**
 *
 */
package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.constants.DemoConstants;
import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;
import com.google.gwt.user.client.Window;

import ol.Collection;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.MousePosition;
import ol.control.MousePositionOptions;
import ol.event.EventListener;
import ol.geom.Polygon;
import ol.interaction.Select;
import ol.interaction.SelectOptions;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.VectorLayerOptions;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.Osm;
import ol.source.Vector;
import ol.source.VectorOptions;
import ol.source.XyzOptions;

/**
 * Example for feature selection.
 *
 * @author Tino Desjardins
 */
public class SelectFeaturesExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show(String exampleId) {

    	Coordinate centerCoordinate = OLFactory.createCoordinate(13.37, 52.52);
        Coordinate transformedMidPoint = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        // create a polygon
        Polygon polygon = DemoUtils.createTestPolygon();

        // create a feature
        FeatureOptions featureOptions = OLFactory.createOptions();
        // TODO Setter for ID seems to doesn't have an effect in feature options.
        // featureOptions.setId("g1");
        featureOptions.setGeometry(polygon);

        Feature feature = new Feature(featureOptions);
        feature.setId("g1");
        feature.set("name", "triangle");

        // create another feature via cloning
        Feature feature2 = feature.clone();
        feature2.setId("g2");
        feature2.getGeometry().rotate(180, transformedMidPoint);

        Collection<Feature> lstFeatures = new Collection<Feature>();
        lstFeatures.push(feature);
        lstFeatures.push(feature2);

        VectorOptions vectorSourceOptions = OLFactory.createOptions();
        vectorSourceOptions.setFeatures(OLFactory.<Feature[], Collection<Feature>> createObject2(lstFeatures));
        Vector vectorSource = new Vector(vectorSourceOptions);

        VectorLayerOptions vectorLayerOptions = OLFactory.createOptions();
        vectorLayerOptions.setSource(vectorSource);
        ol.layer.Vector vectorLayer = new ol.layer.Vector(vectorLayerOptions);

        // create an OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();
        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);
        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = new View();

        view.setCenter(transformedMidPoint);
        view.setZoom(14);

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
        map.addControl(OLFactory.createScaleLine());

        MousePositionOptions mousePositionOptions = OLFactory.createOptions();
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.setCode(DemoConstants.EPSG_4326);
        mousePositionOptions.setProjection(OLFactory.createProjection(projectionOptions));

        MousePosition mousePosition = new MousePosition(mousePositionOptions);
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(5));
        map.addControl(mousePosition);

        // create a select interaction
        final Select selectFeature = new Select((SelectOptions)OLFactory.createOptions());
        map.addInteraction(selectFeature);

        EventListener<Select.Event> selectListener = new EventListener<Select.Event>() {

            @Override
            public void onEvent(Select.Event event) {

            	Collection<Feature> selectedFeatures = selectFeature.getFeatures();

            	if (selectedFeatures.getLength() > 0) {
            		Feature feature = selectedFeatures.item(0);
            		String output = "You selected feature with id '" + feature.getId() + "'"
            				+ " and name '" + feature.get("name") + "'"
            				+ " and geometry name '" + feature.getGeometryName() + "'"
            				+ ".";
            		Window.alert(output);
            	}

            }

        };

        selectFeature.on("select", selectListener);

    }

}
