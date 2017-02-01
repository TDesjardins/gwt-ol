package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Coordinate;
import ol.Extent;
import ol.Map;
import ol.MapOptions;
import ol.View;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.Tile;
import ol.source.TileWMS;
import ol.source.TileWMSOptions;
import ol.source.TileWMSParams;
import ol.source.WMSServerType;

/**
 * Example with WMS layers.
 *
 * @author Tino Desjardins
 *
 */
public class TileWmsExample implements Example {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.desjardins.ol3.demo.client.example.Example#show()
	 */
	@Override
	public void show(String exampleId) {
		TileWMSParams.DELIMITER = ":";
		TileWMSParams params = new TileWMSParams();
		params.showLayers("topp", "states");
		params.setTiled(true);

		TileWMSOptions options = new TileWMSOptions();
		options.setUrl("https://ahocevar.com/geoserver/wms");
		options.setParams(params);
		options.setServerType(WMSServerType.GEOSERVER);

		TileWMS source = new TileWMS(options);

		Extent extent = Extent.create(-13884991, 2870341, -7455066, 6338219);
		Tile layer = new Tile();
		layer.setExtent(extent);
		layer.setSource(source);

		Coordinate centerCoordinate = Coordinate.create(-10997148, 4569099);
		View view = new View();
		view.setCenter(centerCoordinate);
		view.setZoom(4);

		// create the map
		MapOptions mapOptions = new MapOptions();
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
