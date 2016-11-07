package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.constants.DemoConstants;
import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;
import com.google.gwt.user.client.Window;

import ol.Coordinate;
import ol.Map;
import ol.MapBrowserEvent;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.Attribution;
import ol.event.DoubleClickListener;
import ol.interaction.DragPan;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.interaction.MouseWheelZoom;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.Osm;
import ol.source.XyzOptions;

/**
 * Example how to handle map events.
 *
 * @author Tino Desjardins
 *
 */
public class MapEventsExample implements Example {

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

        Coordinate centerCoordinate = OLFactory.createCoordinate(-0.1275, 51.507222);
        Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

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

        // clear default interactions
        map.getInteractions().clear();

        // add some interactions
        map.addInteraction(new DragPan());
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());
        map.addInteraction(new MouseWheelZoom());

        // add event handlers
        map.addDoubleClickListener(new DoubleClickListener() {

            @Override
            public void onDoubleClick(MapBrowserEvent evt) {
                Window.alert("double click at " + evt.getCoordinate().getX() + ", " + evt.getCoordinate().getX());
            }

        });

    }

}

