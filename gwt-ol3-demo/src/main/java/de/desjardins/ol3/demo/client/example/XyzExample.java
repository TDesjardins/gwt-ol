package de.desjardins.ol3.demo.client.example;

import ol.proj.Projection;
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
    	
    	AttributionOptions attributionOptions = AttributionOptions.newInstance()
                .html("Tiles &copy; <a href=\"http://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer\">ArcGIS</a>");
        
        Attribution attribution = Attribution.newInstance(attributionOptions);
        Attribution[] attributions = new Attribution[1];
        attributions[0] = attribution;
        
        xyzOptions.setAttributions(attributions);
    	
    	Xyz xyzSource =  OLFactory.createXyz(xyzOptions);
    	LayerOptions xyzLayerOptions = OLFactory.createLayerOptions();
    	xyzLayerOptions.setSource(xyzSource);
    	
    	Tile xyzLayer = OLFactory.createTileLayer(xyzLayerOptions);
    	
    	// create a view
        View view = OLFactory.createView();

        double[] centerCoordinate = OLFactory.createCoordinate(-121.1, 47.5);
        double[] transformedCenterCoordinate = Projection.transform(centerCoordinate, "EPSG:4326", "EPSG:3857"); 
        
        view.setCenter(transformedCenterCoordinate);
        view.setZoom(7);
        
        // create the map
        MapOptions mapOptions = OLFactory.createMapOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = Map.newInstance(mapOptions);
        
        ol.control.Attribution attributionControl = ol.control.Attribution.newInstance();
        attributionControl.setCollapsed(false);
        
        map.addControl(attributionControl);
        map.addControl(MousePosition.newInstance());
        map.addLayer(xyzLayer);

    }
    
}

