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

import ol.geom.Polygon;
import ol.proj.Projection;
import ol.sphere.Sphere;
import ol.sphere.SphereMetricOptions;

/**
 * Test for {@link Sphere}.
 *
 * @author Tino Desjardins
 *
 */
public class SphereTest extends GwtOLBaseTestCase {

    public void testSphere() {

        injectUrlAndTest(() -> {

            Coordinate[][] coordinates = new Coordinate[1][4];

            Coordinate point1 = new Coordinate(13.36, 52.53);
            Coordinate point2 = new Coordinate(13.36, 52.51);
            Coordinate point3 = new Coordinate(13.37, 52.52);
            Coordinate point4 = new Coordinate(13.36, 52.53);

            coordinates[0][0] = point1;
            coordinates[0][1] = point2;
            coordinates[0][2] = point3;
            coordinates[0][3] = point4;

            SphereMetricOptions sphereMetricOptions = new SphereMetricOptions();
            sphereMetricOptions.setProjection(Projection.get("EPSG:4326"));
            sphereMetricOptions.setRadius(OLUtil.EARTH_RADIUS_NORMAL);

            Polygon polygon = new Polygon(coordinates);

            double area = Sphere.getArea(polygon, sphereMetricOptions);

            assertTrue(area > 0);

            double distance = Sphere.getDistance(point1, point2, OLUtil.EARTH_RADIUS_NORMAL);

            assertTrue(distance > 0);

            double length = Sphere.getLength(polygon, sphereMetricOptions);

            assertTrue(length > 0);

        });

    }

}
