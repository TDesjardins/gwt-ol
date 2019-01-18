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
package ol.color;

import ol.GwtOLBaseTestCase;
import ol.OLFactory;

/**
 * Test for {@link ol.color.Color}.
 * 
 * @author Tino Desjardins
 *
 */
public class ColorTest extends GwtOLBaseTestCase {

    public void testColor() {

        this.injectUrlAndTest(() -> {

            Color color = OLFactory.createColor(255, 50, 100, .5);
            assertNotNull(color);
            assertEquals(color.getRed(), 255);
            assertEquals(color.getGreen(), 50);
            assertEquals(color.getBlue(), 100);
            assertEquals(color.getAlpha(), .5f);

            Color color2 = new Color(255, 50, 100, .5);
            assertNotNull(color2);
            assertEquals(color2.getRed(), 255);
            assertEquals(color2.getGreen(), 50);
            assertEquals(color2.getBlue(), 100);
            assertEquals(color2.getAlpha(), .5f);

            Color color3 = Color.getColorFromString("#FF4D0B");
            assertNotNull(color3);

            assertEquals(color3.getRed(), 255);
            assertEquals(color3.getGreen(), 77);
            assertEquals(color3.getBlue(), 11);
            assertEquals(color3.getAlpha(), 1f);

            assertEquals("rgba(255,77,11,1)", color3.asString());

        });

    }

}
