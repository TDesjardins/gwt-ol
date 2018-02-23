/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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

import ol.Collection;
import ol.Coordinate;
import ol.ImageData;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.PixelColor;
import ol.RasterOperation;
import ol.View;
import ol.layer.Base;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.Osm;
import ol.source.Raster;
import ol.source.RasterOperationType;
import ol.source.RasterOptions;
import ol.source.Source;
import ol.source.XyzOptions;

/**
 * Example with a Raster source.
 *
 * @author Daniel Eggert (daniel.eggert@gfz-potsdam.de)
 */
public class RasterExample implements Example {

    /*
     * (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        XyzOptions osmSourceOptions = OLFactory.createOptions();
        osmSourceOptions.setCrossOrigin("Anonymous");

        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        // create OSM layer only for background and attribution
        Tile osmLayer = new Tile(osmLayerOptions);

        // create raster source
        Raster raster = getRasterSource(osmSource, RasterOperationType.PIXEL);

        LayerOptions layerOptions = OLFactory.createOptions();
        layerOptions.setSource(raster);
        Image image = new Image(layerOptions);

        Collection<Base> layers = new Collection<>();
        layers.push(osmLayer);
        layers.push(image);

        View view = new View();

        Coordinate centerCoordinate = new Coordinate(-0.1275, 51.507222);
        Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        view.setCenter(transformedCenterCoordinate);
        view.setZoom(10);

        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);
        mapOptions.setLayers(layers);

        Map map = new Map(mapOptions);

        // add some controls
        DemoUtils.addDefaultControls(map.getControls());

    }

    private static Raster getRasterSource(Source source, RasterOperationType type) {

        // wrap source with raster source layer
        RasterOptions rasterOptions = OLFactory.createRasterOptionsWithSource(source);
        rasterOptions.setOperationType(type);

        RasterOperation<?> rasterOperation = null;
        switch(type) {
            case PIXEL:
                rasterOperation = (PixelColor[] pixels) -> {

                    final int channel = 0;
                    final int threshold = 245;

                    // get pixel of first source
                    PixelColor pixel = pixels[0];

                    // extract pixel value and apply operation
                    int value = pixel.getChannel(channel);
                    pixel.clear();

                    if (value > threshold) {
                        pixel.setChannel(channel, 255);
                        pixel.setAlpha(128);
                    }

                    return pixel;
                };

                break;
            case IMAGE:
                rasterOperation = (ImageData[] sourceImages) -> {

                    // get image of first source
                    ImageData image = sourceImages[0];

                    // apply image wide operation, make the lower part of the image darker
                    final int width = image.width;
                    final int height = image.height;

                    PixelColor pixel = new PixelColor(0, 0, 0, 128);

                    for (int y = height / 2; y < height; ++y) {
                        for (int x = 0; x < width; ++x) {
                            image.putPixel(x, y, pixel);
                        }
                    }

                    return image;

                };
                break;
        }

        // set raster operation and return raster
        rasterOptions.setOperation(rasterOperation);
        return new Raster(rasterOptions);

    }

}
