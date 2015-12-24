package de.desjardins.ol3.demo.client.example;

import de.desjardins.ol3.demo.client.utils.DemoUtils;

import ol.Attribution;
import ol.AttributionOptions;
import ol.Collection;
import ol.Extent;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.ViewOptions;
import ol.layer.Base;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.ImageStatic;
import ol.source.ImageStaticOptions;

/**
 * Example with a StaticImage layer.
 * 
 * @author Tino Desjardins
 *
 */
public class StaticImageExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show() {
        
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        
        Extent imageExtent = OLFactory.createExtent(0, 0, 1024, 968);
        
        projectionOptions.setCode("pixel");
        projectionOptions.setExtent(imageExtent);
        projectionOptions.setUnits("pixels");
        
        Projection projection = OLFactory.createProjection(projectionOptions);
        
        ImageStaticOptions imageStaticOptions = OLFactory.createOptions();
        imageStaticOptions.setUrl("http://imgs.xkcd.com/comics/online_communities.png");
        imageStaticOptions.setImageSize(OLFactory.createSize(1024, 968));
        imageStaticOptions.setImageExtent(imageExtent);
        imageStaticOptions.setProjection(projection);
        
        AttributionOptions attributionOptions = OLFactory.<AttributionOptions>createOptions()
                .setHtml("&copy; <a href=\"http://xkcd.com/license.html\">xkcd</a>");
        
        Attribution attribution = OLFactory.createAttribution(attributionOptions);
        Attribution[] attributions = new Attribution[1];
        attributions[0] = attribution;
        
        imageStaticOptions.setAttributions(attributions);
        
        ImageStatic imageStatic = OLFactory.createImageStaticSource(imageStaticOptions);
        
        LayerOptions layerOptions = OLFactory.createOptions();
        layerOptions.setSource(imageStatic);
        Image image = OLFactory.createImageLayer(layerOptions);
        
        Collection<Base> layers = OLFactory.createCollection();
        layers.push(image);
        
        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setCenter(OLFactory.createCoordinate(500, 500));
        viewOptions.setProjection(projection);
        viewOptions.setZoom(2);
        
        View view = OLFactory.createView(viewOptions);
        
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);
        mapOptions.setLayers(layers);
        
        Map map = OLFactory.createMap(mapOptions);
        
        // add some controls
        DemoUtils.addDefaultControls(map.getControls());
        
        ol.control.Attribution attributionControl = OLFactory.createAttributionControl();
        attributionControl.setCollapsed(false);
        
        map.addControl(attributionControl);
        
    }
    
}

