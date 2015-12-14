package de.desjardins.ol3.demo.client.example;

import ol.*;
import ol.control.Attribution;

import de.desjardins.ol3.demo.client.utils.DemoUtils;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.Osm;
import ol.source.TileDebug;
import ol.source.TileDebugOptions;
import ol.source.XyzOptions;
import ol.layer.LayerOptions;

/**
 * Example with OSM layer and tile debug layer.
 * 
 * @author Tino Desjardins
 *
 */
public class OsmExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show() {
        
        // create a OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();
        
        Osm osmSource = OLFactory.createOsm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createLayerOptions();
        osmLayerOptions.setSource(osmSource);
        
        Tile osmLayer = OLFactory.createTileLayer(osmLayerOptions);

        // create debug layer
        TileDebugOptions tileDebugOptions = OLFactory.createOptions();
        tileDebugOptions.setProjection("EPSG:3857");
        tileDebugOptions.setTileGrid(osmSource.getTileGrid());

        TileDebug tileDebugSource = OLFactory.createTileDebug(tileDebugOptions);
        
        LayerOptions tileDebugLayerOptions = OLFactory.createLayerOptions();
        
        tileDebugLayerOptions.setSource(tileDebugSource);
        
        Tile tileDebugLayer = OLFactory.createTileLayer(tileDebugLayerOptions);
        
        
        // create a view
        View view = OLFactory.createView();

        Coordinate centerCoordinate = OLFactory.createCoordinate(-0.1275, 51.507222);
        Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, "EPSG:4326", "EPSG:3857"); 
        
        view.setCenter(transformedCenterCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createMapOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = OLFactory.createMap(mapOptions);
        
        map.addLayer(osmLayer);
        map.addLayer(tileDebugLayer);

        // add some controls
        map.addControl(OLFactory.createScaleLine());
        DemoUtils.addDefaultControls(map.getControls());
        
        Attribution attribution = Attribution.newInstance();
        attribution.setCollapsed(true);
        
        map.addControl(attribution);
        
        // add some interactions
        map.addInteraction(OLFactory.createKeyboardPan());
        map.addInteraction(OLFactory.createKeyboardZoom());
        
        
    }
    
}

