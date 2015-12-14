package de.desjardins.ol3.demo.client.example;

import de.desjardins.ol3.demo.client.utils.DemoUtils;
import ol.*;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.ImageWMS;
import ol.source.ImageWMSOptions;
import ol.source.ImageWMSParams;

/**
 * Example with WMS layers.
 * 
 * @author Tino Desjardins
 *
 */
public class WmsExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show() {
        
        ImageWMSParams imageWMSParams = OLFactory.createOptions();
        imageWMSParams.setLayers("ch.swisstopo.geologie-geotechnik-gk500-gesteinsklassierung,ch.bafu.schutzgebiete-paerke_nationaler_bedeutung");
        
        ImageWMSOptions imageWMSOptions = OLFactory.createOptions();
        imageWMSOptions.setUrl("http://wms.geo.admin.ch/");
        imageWMSOptions.setParams(imageWMSParams);
        imageWMSOptions.setRatio(1.5f);

        ImageWMS imageWMSSource = OLFactory.createImageWMSSource(imageWMSOptions);

        LayerOptions layerOptions = OLFactory.createLayerOptions();
        layerOptions.setSource(imageWMSSource);
        
        Image wmsLayer = OLFactory.createImageLayer(layerOptions);
        
        // create a projection
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.setCode("EPSG:21781");
        projectionOptions.setUnits("m");
        
        Projection projection = OLFactory.createProjection(projectionOptions);
        
        // create a view
        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setProjection(projection);
        View view = OLFactory.createView(viewOptions);

        Coordinate centerCoordinate = OLFactory.createCoordinate(660000, 190000);
        
        view.setCenter(centerCoordinate);
        view.setZoom(9);

        // create the map
        MapOptions mapOptions = OLFactory.createMapOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = OLFactory.createMap(mapOptions);
        
        map.addLayer(wmsLayer);

        // add some controls
        map.addControl(OLFactory.createScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        // add some interactions
        map.addInteraction(OLFactory.createKeyboardPan());
        map.addInteraction(OLFactory.createKeyboardZoom());
        map.addControl(OLFactory.createRotate());
        
    }
    
}

