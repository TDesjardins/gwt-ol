package de.desjardins.ol3.demo.client;

import com.google.gwt.core.client.EntryPoint;

import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.ViewOptions;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.ImageWMS;
import ol.source.ImageWMSOptions;
import ol.source.ImageWMSParams;
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

        // choose your example
        OL3ExampleType exampleType = OL3ExampleType.TileExample;
        
        switch (exampleType) {
            case WmsExample: 
                createMapWithWmsConfiguration();
                break;
            case TileExample:
                createMapWithTileConfiguration();
                break;
            default:
                createMapWithTileConfiguration();
        }

    }
    
    /**
     * Creates a map with a WMS-layer.
     */
    private static void createMapWithWmsConfiguration() {

        ImageWMSParams imageWMSParams = OLFactory.createParams();
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

        double[] coords = new double[2];

        coords[0] = 660000;
        coords[1] = 190000;

        view.setCenter(coords);
        view.setZoom(9);

        // create the map
        MapOptions mapOptions = OLFactory.createMapOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);

        Map map = OLFactory.createMap(mapOptions);

        map.addLayer(wmsLayer);

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
        
    }
    
    /**
     * Creates a map with Tile-layers.
     */
    private static void createMapWithTileConfiguration() {

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
