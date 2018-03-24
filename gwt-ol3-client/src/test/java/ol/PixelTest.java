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
package ol;

/**
 * Test for {@link ol.Pixel}.
 * 
 * @author Tino Desjardins
 *
 */
public class PixelTest extends GwtOLBaseTestCase {

    public void testPixel() {

        injectUrlAndTest(() -> {

            Pixel pixel = new Pixel(100, 50);
            assertNotNull(pixel);
            assertEquals(100, pixel.getX());
            assertEquals(50, pixel.getY());

            Pixel clonedPixel = pixel.cloneObject();
            assertNotNull(clonedPixel);
            assertEquals(pixel.getX(), clonedPixel.getX());
            assertEquals(pixel.getY(), clonedPixel.getY());

        });

    }

}
