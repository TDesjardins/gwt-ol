package de.desjardins.ol3.demo.client.example;

import ol.OLUtil;

import ol.Coordinate;
import ol.source.Xyz;
import ol.source.XyzOptions;
import ol.Attribution;
import ol.AttributionOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.MousePosition;
import ol.layer.LayerOptions;
import ol.layer.Tile;

/**
 * Example with XYZ-Source.
 * 
 * @author Tino Desjardins
 *
 */
public class XyzExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show() {
        
    	XyzOptions xyzOptions = OLFactory.createOptions();
    	xyzOptions.setUrl("http://server.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer/tile/{z}/{y}/{x}");
    	
    	AttributionOptions attributionOptions = OLFactory.<AttributionOptions>createOptions();
    	attributionOptions.setHtml("Tiles &copy; <a href=\"http://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer\">ArcGIS</a>");
        
        Attribution attribution = new Attribution(attributionOptions);
        Attribution[] attributions = new Attribution[1];
        attributions[0] = attribution;
        
        xyzOptions.setAttributions(attributions);
    	
    	Xyz xyzSource =  new Xyz(xyzOptions);
    	LayerOptions xyzLayerOptions = OLFactory.createOptions();
    	xyzLayerOptions.setSource(xyzSource);
    	
    	Tile xyzLayer = new Tile(xyzLayerOptions);
    	
    	// create a view
        View view = new View();

        Coordinate centerCoordinate = OLFactory.createCoordinate(-121.1, 47.5);
        Coordinate transformedCenterCoordinate = OLUtil.transform(centerCoordinate, "EPSG:4326", "EPSG:3857"); 
        
        view.setCenter(transformedCenterCoordinate);
        view.setZoom(7);
        
        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = new Map(mapOptions);
        
        ol.control.Attribution attributionControl = new ol.control.Attribution();
        attributionControl.setCollapsed(false);
        
        map.addControl(attributionControl);
        map.addControl(new MousePosition());
        map.addLayer(xyzLayer);

    }
    
}

