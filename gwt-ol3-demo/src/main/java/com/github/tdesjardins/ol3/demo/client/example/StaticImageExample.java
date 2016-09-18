package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

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
    public void show(String exampleId) {

        ProjectionOptions projectionOptions = OLFactory.createOptions();

        Extent imageExtent = OLFactory.createExtent(0, 0, 1024, 968);

        projectionOptions.setCode("pixel");
        projectionOptions.setExtent(imageExtent);
        projectionOptions.setUnits("pixels");

        Projection projection = new Projection(projectionOptions);

        ImageStaticOptions imageStaticOptions = OLFactory.createOptions();
        imageStaticOptions.setUrl("http://imgs.xkcd.com/comics/online_communities.png");
        imageStaticOptions.setImageSize(OLFactory.createSize(1024, 968));
        imageStaticOptions.setImageExtent(imageExtent);
        imageStaticOptions.setProjection(projection);

        // create attribution
        AttributionOptions attributionOptions = OLFactory.<AttributionOptions>createOptions();
        attributionOptions.setHtml("&copy; <a href=\"http://xkcd.com/license.html\">xkcd</a>");

        Attribution attribution = new Attribution(attributionOptions);
        Attribution[] attributions = new Attribution[1];
        attributions[0] = attribution;

        imageStaticOptions.setAttributions(attributions);

        ImageStatic imageStatic = new ImageStatic(imageStaticOptions);

        LayerOptions layerOptions = OLFactory.createOptions();
        layerOptions.setSource(imageStatic);
        Image image = new Image(layerOptions);

        Collection<Base> layers = new Collection<Base>();
        layers.push(image);

        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setCenter(OLFactory.createCoordinate(500, 500));
        viewOptions.setProjection(projection);
        viewOptions.setZoom(2);

        View view = new View(viewOptions);

        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);
        mapOptions.setLayers(layers);

        Map map = new Map(mapOptions);

        // add some controls
        DemoUtils.addDefaultControls(map.getControls());

        ol.control.Attribution attributionControl = new ol.control.Attribution();
        attributionControl.setCollapsed(false);

        map.addControl(attributionControl);

    }

}

