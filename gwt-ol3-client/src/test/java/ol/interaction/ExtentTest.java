/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol3
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
package ol.interaction;

import ol.GwtOLBaseTestCase;

/**
 *
 * @author Tino Desjardins
 *
 */
public class ExtentTest extends GwtOLBaseTestCase {

    public void testExtent() {

        injectUrlAndTest(() -> {

            ol.Extent initialExtent = new ol.Extent(1.0, 2.0, 3.0, 4.0);

            /*ExtentOptions extentOptions = new ExtentOptions();
            extentOptions.setExtent(initialExtent);
            Extent extent = new Extent(extentOptions);

            assertNotNull(extent);
            assertTrue(extent instanceof Observable);
            assertTrue(extent instanceof Interaction);
            assertEquals(4.0, extent.getExtent().getUpperRightY());

            ol.Extent updatedExtent = new ol.Extent(11.0, 22.0, 33.0, 44.0);

            extent.setExtent(updatedExtent);
            assertEquals(44.0, extent.getExtent().getUpperRightY());*/

        });

    }

}
