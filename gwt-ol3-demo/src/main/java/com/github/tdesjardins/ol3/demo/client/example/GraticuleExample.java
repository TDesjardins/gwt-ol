package com.github.tdesjardins.ol3.demo.client.example;

import ol.Coordinate;
import ol.Graticule;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.MousePosition;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.source.Osm;
import ol.source.XyzOptions;

/**
 * Example for Graticule.
 *
 * @author Tino Desjardins
 *
 */
public class GraticuleExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create an OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();

        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = OLFactory.createView();

        Coordinate centerCoordinate = OLFactory.createCoordinate(1490463, 6894388);

        view.setCenter(centerCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = OLFactory.createMap(mapOptions);

        map.addLayer(osmLayer);

        // add some controls
        map.addControl(OLFactory.createZoomSlider());
        MousePosition mousePosition = new MousePosition();
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(2));
        map.addControl(mousePosition);
        map.addControl(OLFactory.createZoomToExtent());

        Graticule graticule = OLFactory.createGraticule();
        graticule.setMap(map);

    }

}

