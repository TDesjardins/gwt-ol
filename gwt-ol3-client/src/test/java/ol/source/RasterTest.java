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
package ol.source;

import ol.GwtOLBaseTestCase;
import ol.PixelColor;

/**
 * A test case for {@link ol.source.Raster}.
 *
 * @author Tino desjardins
 */
public class RasterTest extends GwtOLBaseTestCase {

    public void testRaster() {

        injectUrlAndTest(() -> {

            RasterOptions rasterOptions = new RasterOptions();
            rasterOptions.disableWorkerSupport();
            rasterOptions.setSource(new Osm());
            rasterOptions.setOperationType(RasterOperationType.PIXEL);

            rasterOptions.setOperation((PixelColor[] pixels) -> {

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
            });

            Raster raster = new Raster(rasterOptions);

            assertNotNull(raster);
            assertTrue(raster instanceof Source);

        });

    }

}
