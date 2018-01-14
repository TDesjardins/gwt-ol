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

import com.github.tdesjardins.ol3.demo.client.constants.DemoConstants;
import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.ViewOptions;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.Osm;
import ol.source.Wmts;
import ol.source.WmtsOptions;
import ol.source.XyzOptions;
import ol.tilegrid.TileGrid;
import ol.tilegrid.WmtsTileGrid;
import ol.tilegrid.WmtsTileGridOptions;

/**
 * Example with WMTS layer.
 *
 * @author Tino Desjardins
 *
 */
public class WmtsExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create a projection       
        Projection projection = Projection.get(DemoConstants.EPSG_3857);

        // create a OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();

        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        Tile osmLayer = new Tile(osmLayerOptions);

        WmtsOptions wmtsOptions = OLFactory.createOptions();
        wmtsOptions.setUrl("https://services.arcgisonline.com/arcgis/rest/services/Demographics/USA_Population_Density/MapServer/WMTS/");
        wmtsOptions.setLayer("0");
        wmtsOptions.setFormat("image/png");
        wmtsOptions.setMatrixSet(DemoConstants.EPSG_3857);
        wmtsOptions.setStyle("default");
        wmtsOptions.setProjection(projection);
        wmtsOptions.setWrapX(true);
        wmtsOptions.setTileGrid(this.createWmtsTileGrid(projection));

        // create attribution
        wmtsOptions.setAttributions("Tiles &copy; <a href=\"http://services.arcgisonline.com/arcgis/rest/services/Demographics/USA_Population_Density/MapServer/\">ArcGIS</a>");

        Wmts wmtsSource = new Wmts(wmtsOptions);

        LayerOptions wmtsLayerOptions = OLFactory.createOptions();
        wmtsLayerOptions.setSource(wmtsSource);

        Tile wmtsLayer = new Tile(wmtsLayerOptions);
        wmtsLayer.setOpacity(0.7);

        // create a view
        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setProjection(projection);
        View view = new View(viewOptions);

        Coordinate centerCoordinate = new Coordinate(-11158582, 4813697);

        view.setCenter(centerCoordinate);
        view.setZoom(4);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        // add layers
        map.addLayer(osmLayer);
        map.addLayer(wmtsLayer);

        // add some controls
        map.addControl(new ScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());
        map.addControl(new Rotate());

    }

    /**
     * Creates a WMTS tilegrid.
     * 
     * @param projection projection of the grid
     * @return WMTS tilegrid
     */
    private TileGrid createWmtsTileGrid(Projection projection) {

        WmtsTileGridOptions wmtsTileGridOptions = OLFactory.createOptions();

        double[] resolutions = new double[14];
        String[] matrixIds = new String[14];

        double width = projection.getExtent().getWidth();
        double matrixWidth = width / 256;

        for (int i = 0; i < 14; i++) {
            resolutions[i] = matrixWidth / Math.pow(2, i);
            matrixIds[i] = String.valueOf(i);
        }

        Coordinate tileGridOrigin = projection.getExtent().getTopLeft();
        wmtsTileGridOptions.setOrigin(tileGridOrigin);
        wmtsTileGridOptions.setResolutions(resolutions);
        wmtsTileGridOptions.setMatrixIds(matrixIds);

        return new WmtsTileGrid(wmtsTileGridOptions);

    }

}

