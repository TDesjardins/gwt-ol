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
 * A test case for {@link GeometryCollection}.
 *
 * @author sbaumhekel
 */
public class GeometryCollectionTest extends GwtOL3BaseTestCase {

    public void testGeometryCollection() {

        injectUrlAndTest(() -> {

            Geometry[] geoms = new Geometry[] { OLFactory.createPoint(1, 2), OLFactory.createLineString(
                    new Coordinate[] { OLFactory.createCoordinate(1, 2), OLFactory.createCoordinate(2, 3) }) };

            GeometryCollection col = new GeometryCollection(geoms);

            assertNotNull(col);

            Geometry[] geoms2 = col.getGeometries();

            assertNotNull(geoms2);
            assertEquals(2, geoms2.length);

            Geometry g1 = geoms2[0];
            Geometry g2 = geoms2[1];

            assertNotNull(g1);
            assertNotNull(g2);
            assertEquals("Point", g1.getType());
            assertEquals("LineString", g2.getType());

        });

    }

}
