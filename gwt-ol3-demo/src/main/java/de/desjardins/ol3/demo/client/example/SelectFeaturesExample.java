/**
 *
 */
package de.desjardins.ol3.demo.client.example;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Window;

import de.desjardins.ol3.demo.client.constants.DemoConstants;
import de.desjardins.ol3.demo.client.utils.DemoUtils;
import ol.Collection;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.OLUtil;
import ol.View;
import ol.control.MousePosition;
import ol.control.MousePositionOptions;
import ol.event.EventListener;
import ol.geom.Polygon;
import ol.interaction.Select;
import ol.interaction.SelectEvent;
import ol.interaction.SelectOptions;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.VectorLayerOptions;
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
    public void show(Element element) {

    	Coordinate centerCoordinate = OLFactory.createCoordinate(13.37, 52.52);
        Coordinate transformedMidPoint = OLUtil.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);
    	
        // create a polygon
        Polygon polygon = DemoUtils.createTestPolygon();

        // create a feature
        FeatureOptions featureOptions = OLFactory.createOptions();
        // TODO Setter for ID seems to doesn't have an effect in feature options.
        // featureOptions.setId("g1");
        featureOptions.setGeometry(polygon);
        
        Feature feature = OLFactory.createFeature(featureOptions);
        feature.setId("g1");
        feature.set("name", "triangle");
        
        // create another feature via cloning
        Feature feature2 = feature.clone();
        feature2.setId("g2");
        feature2.getGeometry().rotate(180, transformedMidPoint);
        
        Collection<Feature> lstFeatures = OLFactory.createCollection();
        lstFeatures.push(feature);
        lstFeatures.push(feature2);
        
        VectorOptions vectorSourceOptions = OLFactory.createOptions();
        vectorSourceOptions.setFeatures(OLFactory.<Feature[], Collection<Feature>> createObject2(lstFeatures));
        Vector vectorSource = OLFactory.createVectorSource(vectorSourceOptions);

        VectorLayerOptions vectorLayerOptions = OLFactory.createOptions();
        vectorLayerOptions.setSource(vectorSource);
        ol.layer.Vector vectorLayer = OLFactory.createVector(vectorLayerOptions);

        // create an OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();
        Osm osmSource = OLFactory.createOsm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);
        Tile osmLayer = OLFactory.createTileLayer(osmLayerOptions);

        // create a view
        View view = OLFactory.createView();
        
        view.setCenter(transformedMidPoint);
        view.setZoom(14);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(DemoConstants.MAP_DIV);
        mapOptions.setView(view);
        Collection<Base> lstLayer = OLFactory.createCollection();
        lstLayer.push(osmLayer);
        lstLayer.push(vectorLayer);
        mapOptions.setLayers(lstLayer);
        Map map = OLFactory.createMap(mapOptions);
        
        // add some controls
        map.addControl(OLFactory.createScaleLine());
        
        MousePositionOptions mousePositionOptions = OLFactory.createOptions();
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.setCode(DemoConstants.EPSG_4326);
        mousePositionOptions.setProjection(OLFactory.createProjection(projectionOptions));
        
        MousePosition mousePosition = OLFactory.createMousePosition(mousePositionOptions);
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(5));
        map.addControl(mousePosition);
        
        // create a select interaction
        final Select selectFeature = OLFactory.createSelect((SelectOptions)OLFactory.createOptions());
        map.addInteraction(selectFeature);
        
        EventListener<SelectEvent> selectListener = new EventListener<SelectEvent>() {

            @Override
            public void onEvent(SelectEvent event) {
            
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

        OLUtil.observe(selectFeature, "select", selectListener);

    }

}
