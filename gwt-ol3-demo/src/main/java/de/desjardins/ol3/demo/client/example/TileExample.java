package de.desjardins.ol3.demo.client.example;

import com.google.gwt.user.client.Window;

import de.desjardins.ol3.demo.client.utils.DemoUtils;

import ol.event.EventListener;
import ol.interaction.DragAndDrop;
import ol.interaction.DragAndDropEvent;
import ol.layer.Tile;
import ol.source.MapQuest;
import ol.source.MapQuestOptions;
import ol.source.Stamen;
import ol.source.StamenOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.layer.LayerOptions;

/**
 * Example with Tile-layers.
 * 
 * @author Tino Desjardins
 *
 */
public class TileExample implements Example {

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
        
        LayerOptions stamenLayerOptions = OLFactory.createLayerOptions();
        
        
        // create a Stamen-layer
        StamenOptions stamenOptions = OLFactory.createStamenOptions();
        stamenOptions.setLayer("watercolor");
        
        Stamen stamenSource = OLFactory.createStamenSource(stamenOptions);
        stamenLayerOptions.setSource(stamenSource);
        Tile stamenLayer = OLFactory.createTileLayer(stamenLayerOptions);

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
        
        stamenLayer.setOpacity(0.5f);
        map.addLayer(mapQuestLayer);

        // add some controls
        map.addControl(OLFactory.createScaleLine());
        DemoUtils.addDefaultControls(map.getControls());
        
        // add some interactions
        map.addInteraction(OLFactory.createKeyboardPan());
        map.addInteraction(OLFactory.createKeyboardZoom());
        
        DragAndDrop dragAndDrop = OLFactory.createDragAndDrop();
        map.addInteraction(dragAndDrop);
        
        EventListener<DragAndDropEvent> eventListener = new EventListener<DragAndDropEvent>() {
            
            @Override
            public void on(DragAndDropEvent event) {
                Window.alert(String.valueOf(event.getFeatures().length));
                Window.alert(event.getProjection().getUnits());
                Window.alert(String.valueOf(event.getProjection().getMetersPerUnit()));
                
            }
        };

        dragAndDrop.on("addfeatures", EventListener.createEventListener(eventListener));

        map.addControl(OLFactory.createRotate());
        
        map.getLayers().push(stamenLayer);
        
    }
    
}

