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
 * Test for {@link ol.Extent}.
 * 
 * @author Tino Desjardins
 *
 */
public class ExtentTest extends GwtOL3BaseTestCase {

    public void testExtent() {

        injectUrlAndTest(() -> {

            Extent extent = OLFactory.createExtent(100, 50, 150, 110);
            assertNotNull(extent);
            assertEquals(100, extent.getLowerLeftX());
            assertEquals(50, extent.getLowerLeftY());
            assertEquals(150, extent.getUpperRightX());
            assertEquals(110, extent.getUpperRightY());
            assertEquals(50, extent.getWidth());
            assertEquals(60, extent.getHeight());
            assertEquals(extent.getWidth() * extent.getHeight(), extent.getArea());

            Coordinate topLeftCoordinate = extent.getTopLeft();
            assertEquals(100, topLeftCoordinate.getX());
            assertEquals(110, topLeftCoordinate.getY());

            Extent clonedExtent = extent.cloneObject();
            assertNotNull(extent);
            assertEquals(extent.getLowerLeftX(), clonedExtent.getLowerLeftX());
            assertEquals(extent.getLowerLeftY(), clonedExtent.getLowerLeftY());
            assertEquals(extent.getUpperRightX(), clonedExtent.getUpperRightX());
            assertEquals(extent.getUpperRightY(), clonedExtent.getUpperRightY());

        });

    }

}
