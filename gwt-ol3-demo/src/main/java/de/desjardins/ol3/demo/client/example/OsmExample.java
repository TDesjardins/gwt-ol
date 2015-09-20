package de.desjardins.ol3.demo.client.example;

import ol.control.Attribution;

import de.desjardins.ol3.demo.client.utils.DemoUtils;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.Osm;
import ol.source.TileDebug;
import ol.source.TileDebugOptions;
import ol.source.XyzOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
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
        
        Osm osmSource = Osm.newInstance(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createLayerOptions();
        osmLayerOptions.setSource(osmSource);
        
        Tile osmLayer = OLFactory.createTileLayer(osmLayerOptions);

        // create debug layer
        TileDebugOptions tileDebugOptions = OLFactory.createOptions();
        tileDebugOptions.setProjection("EPSG:3857");
        tileDebugOptions.setTileGrid(osmSource.getTileGrid());

        TileDebug tileDebugSource = TileDebug.newInstance(tileDebugOptions);
        
        LayerOptions tileDebugLayerOptions = OLFactory.createLayerOptions();
        
        tileDebugLayerOptions.setSource(tileDebugSource);
        
        Tile tileDebugLayer = OLFactory.createTileLayer(tileDebugLayerOptions);
        
        
        // create a view
        View view = OLFactory.createView();

        double[] centerCoordinate = OLFactory.createCoordinate(-0.1275, 51.507222);
        double[] transformedCenterCoordinate = Projection.transform(centerCoordinate, "EPSG:4326", "EPSG:3857"); 
        
        view.setCenter(transformedCenterCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createMapOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = Map.newInstance(mapOptions);
        
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

