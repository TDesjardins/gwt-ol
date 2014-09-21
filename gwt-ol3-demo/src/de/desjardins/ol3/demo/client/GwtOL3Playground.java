package de.desjardins.ol3.demo.client;

import com.google.gwt.core.client.EntryPoint;

import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.source.MapQuest;
import ol.source.MapQuestOptions;
import ol.source.Stamen;
import ol.source.StamenOptions;

/**
 * EntryPoint for playing with GwtOL3-Features.
 *
 * @author Tino Desjardins
 *
 */
public class GwtOL3Playground implements EntryPoint {

    @Override
    public void onModuleLoad() {

        // create a MapQuest-layer
        LayerOptions mapQuestLayerOptions = OLFactory.createLayerOptions();
        
        MapQuestOptions mapQuestOptions = OLFactory.createMapQuestOptions();
        mapQuestOptions.setLayer("hyb");
        
        MapQuest mapQuestSource = OLFactory.createMapQuestSource(mapQuestOptions);
        mapQuestLayerOptions.setSource(mapQuestSource);
        Tile mapQuestLayer = OLFactory.createTileLayer(mapQuestLayerOptions);
        
        LayerOptions stamenLayerOptions = OLFactory.createLayerOptions();
        
        
        // create a Stamen-layer
        StamenOptions stamenOptions = OLFactory.createStamenOptions();
        stamenOptions.setLayer("watercolor");
        
        Stamen stamenSource = OLFactory.createStamenSource(stamenOptions);
        stamenLayerOptions.setSource(stamenSource);
        Tile stamenLayer = OLFactory.createTileLayer(stamenLayerOptions);

        // create a view
        View view = OLFactory.createView();

        double[] coords = new double[2];
        
        coords[0] = 1490463;
        coords[1] = 6894388;
        
        view.setCenter(coords);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createMapOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = OLFactory.createMap(mapOptions);
        
        stamenLayer.setOpacity(0.5f);
        map.addLayer(mapQuestLayer);

        // add some controls
        map.addControl(OLFactory.createFullScreen());
        map.addControl(OLFactory.createScaleLine());
        map.addControl(OLFactory.createZoomSlider());
        map.addControl(OLFactory.createMousePosition());
        map.addControl(OLFactory.createZoomToExtent());
        
        // add some interactions
        map.addInteraction(OLFactory.createKeyboardPan());
        map.addInteraction(OLFactory.createKeyboardZoom());
        map.addControl(OLFactory.createRotate());
        
        
        map.getLayers().push(stamenLayer);
        
    }
 
}
