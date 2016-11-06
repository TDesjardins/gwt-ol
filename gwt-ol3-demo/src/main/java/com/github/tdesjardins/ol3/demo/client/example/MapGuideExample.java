package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.*;
import ol.Collection;
import ol.Map;
import ol.layer.*;
import ol.layer.Image;
import ol.proj.Projection;
import ol.source.*;
/**
 * Example with MapGuide layers.
 *
 * @author Tobias Lochmann
 *
 */
public class MapGuideExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

    	// create a projection
        Projection projection = Projection.get("EPSG:4326");

        // create a MapGuide params
    	ImageMapGuideParams imageMapGuideParams = OLFactory.createOptions();
    	imageMapGuideParams.setFormat("PNG");
    	imageMapGuideParams.setMapDefinition("Library://Samples/Sheboygan/Maps/Sheboygan.MapDefinition");

    	// create a MapGuide image
        ImageMapGuideOptions imageMapGuideOptions = OLFactory.createOptions();
        imageMapGuideOptions.setParams(imageMapGuideParams);
        imageMapGuideOptions.setUrl("http://data.mapguide.com/mapguide/mapagent/mapagent.fcgi?USERNAME=Anonymous");
        imageMapGuideOptions.setUseOverlay(false);
        imageMapGuideOptions.setMetersPerUnit(111319.4908d);
        imageMapGuideOptions.setRatio(2.0f);

        ImageMapGuide imageMapGuideSource = OLFactory.createImageMapGuideSource(imageMapGuideOptions);
        LayerOptions layerOptions = OLFactory.createOptions();
        Extent bounds =Extent.create(-87.865114442365922d,43.665065564837931d,-87.595394059497067d,43.823852564430069d);
        layerOptions.setExtent(bounds);
        layerOptions.setSource(imageMapGuideSource);
        Image MapGuideLayer = OLFactory.createImageLayer(layerOptions);


        // create a view
        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setProjection(projection);
        viewOptions.setZoom(12.0d);
        Coordinate centerCoordinate = OLFactory.createCoordinate(-87.7302542509315d, 43.744459064634d);
        viewOptions.setCenter(centerCoordinate);
        View view = OLFactory.createView(viewOptions);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);
        Collection<Base> lstLayer= OLFactory.createCollection();
        lstLayer.push(MapGuideLayer);
        mapOptions.setLayers(lstLayer);
        Map map = OLFactory.createMap(mapOptions);

        // add some controls
        map.addControl(OLFactory.createScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        // add some interactions
        map.addInteraction(OLFactory.createKeyboardPan());
        map.addInteraction(OLFactory.createKeyboardZoom());
        map.addControl(OLFactory.createRotate());

    }

}

