package de.desjardins.ol3.demo.client.example;

import ol.Graticule;
import ol.layer.Tile;
import ol.source.MapQuest;
import ol.source.MapQuestOptions;

import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.layer.LayerOptions;

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
        LayerOptions mapQuestLayerOptions = OLFactory.createLayerOptions();
        
        MapQuestOptions mapQuestOptions = OLFactory.createMapQuestOptions();
        mapQuestOptions.setLayer("hyb");
        
        MapQuest mapQuestSource = OLFactory.createMapQuestSource(mapQuestOptions);
        mapQuestLayerOptions.setSource(mapQuestSource);
        Tile mapQuestLayer = OLFactory.createTileLayer(mapQuestLayerOptions);

        // create a view
        View view = OLFactory.createView();

        double[] centerCoordinate = OLFactory.createCoordinate(1490463, 6894388);
        
        view.setCenter(centerCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createMapOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = Map.newInstance(mapOptions);
        
        map.addLayer(mapQuestLayer);

        // add some controls
        map.addControl(OLFactory.createZoomSlider());
        map.addControl(OLFactory.createMousePosition());
        map.addControl(OLFactory.createZoomToExtent());
        
        Graticule graticule = Graticule.newInstance();
        graticule.setMap(map);
        
    }
    
}

