package com.github.tdesjardins.ol3.demo.client.example;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.Attribution;
import ol.event.MeasureEvent;
import ol.event.MeasureListener;
import ol.gwt.Measure;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;
import com.google.gwt.core.client.GWT;

import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.Osm;
import ol.source.XyzOptions;
import ol.layer.LayerOptions;

/**
 * Example measuring on an OSM layer.
 *
 * @author Tino Desjardins
 *
 */
public class MeasureExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create a OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();

        Osm osmSource = OLFactory.createOsm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = OLFactory.createTileLayer(osmLayerOptions);

        // create a view
        View view = OLFactory.createView();

        Coordinate centerCoordinate = OLFactory.createCoordinate(-0.1275, 51.507222);
        Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, "EPSG:4326", "EPSG:3857");

        view.setCenter(transformedCenterCoordinate);
        view.setZoom(10);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = OLFactory.createMap(mapOptions);

        map.addLayer(osmLayer);

        // add some controls
        map.addControl(OLFactory.createScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        Attribution attribution = OLFactory.createAttributionControl();
        attribution.setCollapsed(true);

        map.addControl(attribution);

        // add some interactions
        map.addInteraction(OLFactory.createKeyboardPan());
        map.addInteraction(OLFactory.createKeyboardZoom());

		// add measurement functionality to the map
		final Measure measure = new Measure(map);
		// start measuring immediately
		measure.startMeasureLength(new MeasureListener() {

			@Override
			public void onMeasure(MeasureEvent evt) {
				// log the measured length
				GWT.log("measure: " + evt.getMeasure());
			}

		}, true, true);

    }

}

