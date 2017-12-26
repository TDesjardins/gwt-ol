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
package proj4;

/**
 * Test for {@link proj4.Proj4}.
 *
 * @author Tino Desjardins
 *
 */
public class Proj4Test extends GwtProj4BaseTestCase {

    private static final String EPSG_3068 = "EPSG:3068";
    private static final String EPSG_4326 = "EPSG:4326";

    public void testProj4() {

        this.injectUrlAndTest(() -> {

           Proj4.defs(EPSG_3068, "+proj=cass +lat_0=52.41864827777778 +lon_0=13.62720366666667 +x_0=40000 +y_0=10000 +ellps=bessel +datum=potsdam +units=m +no_defs");

           Coordinate coordinateEpsg4326 = new Coordinate(13.3, 52.5);

           Coordinate coordinateEpsg3068 = Proj4.proj4(EPSG_3068, coordinateEpsg4326);
           assertNotNull(coordinateEpsg3068);

           Coordinate coordinate = Proj4.proj4(EPSG_4326, EPSG_3068, coordinateEpsg4326);

           assertNotNull(coordinate);
           assertEquals(coordinateEpsg3068.getX(), coordinate.getX());
           assertEquals(coordinateEpsg3068.getY(), coordinate.getY());

           Coordinate coordinate2 = Proj4.proj4(EPSG_3068, EPSG_4326).inverse(coordinateEpsg4326);

           assertNotNull(coordinate);
           assertEquals(coordinateEpsg3068.getX(), coordinate2.getX());
           assertEquals(coordinateEpsg3068.getY(), coordinate2.getY());

           Coordinate coordinate3 = Proj4.proj4(EPSG_4326, EPSG_3068).forward(coordinateEpsg4326);

           assertNotNull(coordinate3);
           assertEquals(coordinateEpsg3068.getX(), coordinate3.getX());
           assertEquals(coordinateEpsg3068.getY(), coordinate3.getY());

        });

    }

}
