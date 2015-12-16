package de.desjardins.ol3.demo.client.example;

import ol.proj.Projection;
import ol.source.Xyz;
import ol.source.XyzOptions;
import ol.*;
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
    	
    	AttributionOptions attributionOptions = OLFactory.<AttributionOptions>createOptions()
                .setHtml("Tiles &copy; <a href=\"http://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer\">ArcGIS</a>");
        
        Attribution attribution = OLFactory.createAttribution(attributionOptions);
        Attribution[] attributions = new Attribution[1];
        attributions[0] = attribution;
        
        xyzOptions.setAttributions(attributions);
    	
    	Xyz xyzSource =  OLFactory.createXyz(xyzOptions);
    	LayerOptions xyzLayerOptions = OLFactory.createOptions();
    	xyzLayerOptions.setSource(xyzSource);
    	
    	Tile xyzLayer = OLFactory.createTileLayer(xyzLayerOptions);
    	
    	// create a view
        View view = OLFactory.createView();

        Coordinate centerCoordinate = OLFactory.createCoordinate(-121.1, 47.5);
        Coordinate transformedCenterCoordinate = OLUtil.transform(centerCoordinate, "EPSG:4326", "EPSG:3857"); 
        
        view.setCenter(transformedCenterCoordinate);
        view.setZoom(7);
        
        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = OLFactory.createMap(mapOptions);
        
        ol.control.Attribution attributionControl = OLFactory.createAttributionControl();
        attributionControl.setCollapsed(false);
        
        map.addControl(attributionControl);
        map.addControl(OLFactory.createMousePosition());
        map.addLayer(xyzLayer);

    }
    
}

