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
package ol.geom;

import ol.Coordinate;
import ol.GwtOL3BaseTestCase;
import ol.Extent;

/**
 * A test case for {@link Circle}.
 *
 * @author Tino Desjardins
 */
public class CircleTest extends GwtOL3BaseTestCase {

    public void testCircle() {

        injectUrlAndTest(() -> {

            double radius = 5;

            Circle circle = new Circle(new Coordinate(10, 10), radius);
            assertNotNull(circle);
            assertTrue(circle instanceof Geometry);

            Coordinate coordinate = circle.getCenter();
            assertNotNull(coordinate);
            assert(10 == coordinate.getX());
            assert(10 == coordinate.getY());

            assert(radius == circle.getRadius());

            assertTrue(circle.intersectsExtent(new Extent(0, 0, 15, 15)));
            assertFalse(circle.intersectsExtent(new Extent(0, 0, 5, 5)));

        });

    }

}
