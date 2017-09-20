/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
import ol.source.TileWms;
import ol.source.TileWmsOptions;
import ol.source.TileWmsParams;
import ol.source.WmsServerType;

/**
 * Example with WMS layers.
 *
 * @author Peter Zanetti
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

		TileWmsParams params = new TileWmsParams();
		params.setLayers("topp:states");
		params.setTiled(true);

		TileWmsOptions options = new TileWmsOptions();
		options.setUrl("https://ahocevar.com/geoserver/wms");
		options.setParams(params);
		options.setServerType(WmsServerType.GEOSERVER);

		TileWms source = new TileWms(options);

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
