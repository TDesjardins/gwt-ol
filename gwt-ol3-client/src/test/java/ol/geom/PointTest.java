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
package ol.geom;

import ol.Coordinate;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;

/**
 * A test case for {@link Point}.
 *
 * @author Tino Desjardins
 */
public class PointTest extends GwtOL3BaseTestCase {

    public void testPoint() {

        injectUrlAndTest(new TestWithInjection() {


            @Override
            public void test() {
                Point point = OLFactory.createPoint(1, 2);
                assertNotNull(point);
                assertTrue(point instanceof Geometry);

                Coordinate coordinate = point.getCoordinates();
                assertNotNull(coordinate);
                assert(1 == coordinate.getX());
                assert(2 == coordinate.getY());
            }

        });

    }

}
