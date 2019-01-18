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
package ol;

/**
 * Test for {@link ol.Extent}.
 * 
 * @author Tino Desjardins
 *
 */
public class ExtentTest extends GwtOLBaseTestCase {

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

            assertTrue(extent.equals(clonedExtent));

        });

    }

    public void testBuffer() {

        injectUrlAndTest(() -> {

            Extent extent = new Extent(100, 50, 150, 110);
            assertNotNull(extent);

            Extent bufferedExtent = extent.buffer(5);
            assertTrue(extent.getArea() < bufferedExtent.getArea());

            bufferedExtent = bufferedExtent.buffer(-5);
            assertTrue(extent.getArea() == bufferedExtent.getArea());

        });

    }

    public void testContainsCoordinate() {

        injectUrlAndTest(() -> {

            Extent extent = new Extent(100, 50, 150, 110);
            assertNotNull(extent);

            assertTrue(extent.containsCoordinate(new Coordinate(110, 60)));
            assertTrue(extent.containsCoordinate(new Coordinate(100, 150)));
            assertTrue(extent.containsCoordinate(new Coordinate(100, 110)));

            assertFalse(extent.containsCoordinate(new Coordinate(50, 50)));
            assertFalse(extent.containsCoordinate(new Coordinate(10, 10)));

        });

    }

    public void testContainsExtent() {

        injectUrlAndTest(() -> {

            Extent extent = new Extent(100, 50, 150, 110);
            assertNotNull(extent);

            assertTrue(extent.containsExtent(new Extent(100, 50, 150, 110)));
            assertTrue(extent.containsExtent(new Extent(110, 60, 140, 100)));

            assertFalse(extent.containsExtent(new Extent(10, 50, 150, 110)));
            assertFalse(extent.containsExtent(new Extent(10, 10, 20, 20)));

        });

    }

    public void testContainsXY() {

        injectUrlAndTest(() -> {

            Extent extent = new Extent(100, 50, 150, 110);
            assertNotNull(extent);

            assertTrue(extent.containsXY(100, 50));
            assertTrue(extent.containsXY(110, 60));

            assertFalse(extent.containsXY(10, 50));
            assertFalse(extent.containsXY(200, 20));

        });

    }

    public void testCreateEmpty() {

        injectUrlAndTest(() -> {

            Extent emptyExtent = Extent.createEmpty();
            assertTrue(emptyExtent.isEmpty());

            Extent extent = new Extent(100, 50, 150, 110);
            assertFalse(extent.isEmpty());

        });

    }

    public void testExtend() {

        injectUrlAndTest(() -> {

            Extent extent = new Extent(100, 50, 150, 110);
            assertNotNull(extent);

            Extent extentToInclude = new Extent(110, 50, 150, 120);
            assertNotNull(extentToInclude);

            double areaBefore = extent.getArea();

            Extent referencedExtent = extent.extend(extentToInclude);

            double areaAfter = extent.getArea();

            assertTrue(areaAfter > areaBefore);
            assertEquals(referencedExtent, extent);

        });

    }

}
