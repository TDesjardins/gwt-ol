package com.github.tdesjardins.ol3.demo.client.example;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.Overlay;
import ol.OverlayOptions;
import ol.View;
import ol.control.Attribution;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;

import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.Osm;
import ol.source.XyzOptions;
import ol.layer.LayerOptions;

/**
 * Example with OSM layer and tile debug layer.
 *
 * @author Tino Desjardins
 *
 */
public class OverlayExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create a OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();

        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = OLFactory.createCoordinate(2.3, 51.507222);
        Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, "EPSG:4326", "EPSG:3857");

        view.setCenter(transformedCenterCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(osmLayer);

        // add some controls
        map.addControl(OLFactory.createScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        Attribution attribution = new Attribution();
        attribution.setCollapsed(true);

        map.addControl(attribution);

        // add some interactions
        map.addInteraction(OLFactory.createKeyboardPan());
        map.addInteraction(OLFactory.createKeyboardZoom());

        DivElement overlay = Document.get().createDivElement();
        overlay.setClassName("overlay-font");
        overlay.setInnerText("Created with GWT SDK " + GWT.getVersion());

        OverlayOptions overlayOptions = OLFactory.createOptions();
        overlayOptions.setElement(overlay);
        overlayOptions.setPosition(transformedCenterCoordinate);
        overlayOptions.setOffset(OLFactory.createPixel(-300, 0));

        map.addOverlay(new Overlay(overlayOptions));

    }

}

