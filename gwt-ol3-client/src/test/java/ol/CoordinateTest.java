/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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
 * Test for {@link ol.Coordinate}.
 * 
 * @author Tino Desjardins
 *
 */
public class CoordinateTest extends GwtOL3BaseTestCase {

    public void testCoordinate() {

        injectUrlAndTest(() -> {

            Coordinate coordinate = Coordinate.create(5.333, 12.25);
            assertNotNull(coordinate);
            assertEquals(2, coordinate.getDimension());

            assertEquals(coordinate.getX(), 5.333);
            assertEquals(coordinate.getY(), 12.25);

            assertEquals(coordinate.toStringXY(2), "5.33, 12.25");

            Coordinate shiftedCoordinate = coordinate.add(Coordinate.create(2, -3));
            assertEquals(7.333, shiftedCoordinate.getX());
            assertEquals(9.25, shiftedCoordinate.getY());

            coordinate.setZ(15.5);
            assertEquals(15.5, shiftedCoordinate.getZ());
            assertEquals(3, coordinate.getDimension());

            Coordinate coordinate2 = Coordinate.create(1.5, 2.5, 3.45);
            assertEquals(3, coordinate2.getDimension());
            assertEquals(3.45, coordinate2.getZ());

        });

    }

}
