package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.source.ImageArcGISRest;
import ol.source.ImageArcGISRestOptions;
import ol.source.ImageArcGISRestParams;

/**
 * Example with ArcGIS Server layer
 * 
 * @author Peter Zanetti
 */
public class ArcGISExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show(String exampleId) {

        ImageArcGISRestParams params = new ImageArcGISRestParams();
        params.showLayers("2");

        ImageArcGISRestOptions options = new ImageArcGISRestOptions();
        options.setUrl(
                "https://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Specialty/ESRI_StateCityHighway_USA/MapServer");
        options.setParams(params);
        options.setRatio(1.5f);

        ImageArcGISRest source = new ImageArcGISRest(options);

        LayerOptions layerOptions = OLFactory.createOptions();
        layerOptions.setSource(source);

        Image layer = new Image(layerOptions);

        // create a view
        View view = new View();

        Coordinate center = OLFactory.createCoordinate(-10997148, 4569099);

        view.setCenter(center);
        view.setZoom(4);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(layer);

        // add some controls
        map.addControl(new ScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());
        map.addControl(new Rotate());

    }

}
