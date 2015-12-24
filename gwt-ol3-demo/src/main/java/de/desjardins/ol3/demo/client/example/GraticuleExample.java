package de.desjardins.ol3.demo.client.example;

import ol.Coordinate;
import ol.Graticule;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.source.MapQuest;
import ol.source.MapQuestOptions;

/**
 * Example for Graticule.
 * 
 * @author Tino Desjardins
 *
 */
public class GraticuleExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show() {
        
        // create a MapQuest-layer
        LayerOptions mapQuestLayerOptions = OLFactory.createOptions();
        
        MapQuestOptions mapQuestOptions = OLFactory.createOptions();
        mapQuestOptions.setLayer("hyb");
        
        MapQuest mapQuestSource = OLFactory.createMapQuestSource(mapQuestOptions);
        mapQuestLayerOptions.setSource(mapQuestSource);
        Tile mapQuestLayer = OLFactory.createTileLayer(mapQuestLayerOptions);

        // create a view
        View view = OLFactory.createView();

        Coordinate centerCoordinate = OLFactory.createCoordinate(1490463, 6894388);
        
        view.setCenter(centerCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = OLFactory.createMap(mapOptions);
        
        map.addLayer(mapQuestLayer);

        // add some controls
        map.addControl(OLFactory.createZoomSlider());
        map.addControl(OLFactory.createMousePosition());
        map.addControl(OLFactory.createZoomToExtent());
        
        Graticule graticule = OLFactory.createGraticule();
        graticule.setMap(map);
        
    }
    
}

