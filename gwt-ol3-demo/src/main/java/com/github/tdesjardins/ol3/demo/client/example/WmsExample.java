package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.ViewOptions;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
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
    public void show(String exampleId) {

        ImageWMSParams imageWMSParams = OLFactory.createOptions();
        imageWMSParams.setLayers("ch.swisstopo.geologie-geotechnik-gk500-gesteinsklassierung,ch.bafu.schutzgebiete-paerke_nationaler_bedeutung");

        ImageWMSOptions imageWMSOptions = OLFactory.createOptions();
        imageWMSOptions.setUrl("http://wms.geo.admin.ch/");
        imageWMSOptions.setParams(imageWMSParams);
        imageWMSOptions.setRatio(1.5f);

        ImageWMS imageWMSSource = new ImageWMS(imageWMSOptions);

        LayerOptions layerOptions = OLFactory.createOptions();
        layerOptions.setSource(imageWMSSource);

        Image wmsLayer = new Image(layerOptions);

        // create a projection
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.setCode("EPSG:21781");
        projectionOptions.setUnits("m");

        Projection projection = new Projection(projectionOptions);

        // create a view
        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setProjection(projection);
        View view = new View(viewOptions);

        Coordinate centerCoordinate = OLFactory.createCoordinate(660000, 190000);

        view.setCenter(centerCoordinate);
        view.setZoom(9);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(wmsLayer);

        // add some controls
        map.addControl(new ScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());
        map.addControl(new Rotate());

    }

}

