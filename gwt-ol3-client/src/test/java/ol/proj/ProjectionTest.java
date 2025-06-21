/*******************************************************************************
 * Copyright 2014, 2025 gwt-ol
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
package ol.proj;

import ol.Coordinate;
import ol.Extent;
import ol.GwtOLBaseTestCase;

/**
 *
 * @author Tino Desjardins
 *
 */
public class ProjectionTest extends GwtOLBaseTestCase {

    private static final String EPSG_CODE_4326 = "EPSG:4326";
    private static final String EPSG_CODE_3068 = "EPSG:3068";
    private static final String EPSG_CODE_3857 = "EPSG:3857";
    private static final String EPSG_CODE_21781 = "EPSG:21781";

    private static final String UNIT_METRE = "m";
    private static final String UNIT_DEGREES = "degrees";

    public void testProjection() {

        injectUrlAndTest(() -> {
            ProjectionOptions projectionOptions = new ProjectionOptions();
            projectionOptions.setCode(EPSG_CODE_21781);
            projectionOptions.setUnits(UNIT_METRE);

            Projection projection = new Projection(projectionOptions);

            assertNotNull(projection);
            assertEquals(EPSG_CODE_21781, projection.getCode());
            assertEquals(UNIT_METRE, projection.getUnits());
        });

    }

    public void testAddProjection() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {

                ProjectionOptions projectionOptions = new ProjectionOptions();
                projectionOptions.setCode(EPSG_CODE_3068);
                //projectionOptions.global(false);
                projectionOptions.setUnits(UNIT_METRE);

                Projection projection = new Projection(projectionOptions);
                assertNotNull(projection);

                Projection.addProjection(projection);

                Projection projectionToCompare = Projection.get(EPSG_CODE_3068);
                assertNotNull(projectionToCompare);

                assertEquals(projection.getCode(), projectionToCompare.getCode());

            }

        });

    }

    public void testGet() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                Projection projection = Projection.get(EPSG_CODE_4326);

                assertNotNull(projection);
                assertEquals(EPSG_CODE_4326, projection.getCode());
                assertTrue(projection.isGlobal());
                assertTrue(projection.getExtent().getLength() == 4);
                assertEquals(projection.getUnits(), UNIT_DEGREES);
            }
        });

    }

    /**
     * Tests coordinate transformation.
     */
    public void testTransform() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {

                double x = -121.1;
                double y = 47.5;

                Coordinate centerCoordinate = new Coordinate(x, y);
                Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, EPSG_CODE_4326, EPSG_CODE_3857);

                assertTrue(transformedCenterCoordinate.getDimension() == 2);
                assertTrue(transformedCenterCoordinate.getX() != x);
                assertTrue(transformedCenterCoordinate.getY() != y);

                Coordinate sameTransformedCenterCoordinate = Projection.transform(centerCoordinate, Projection.get(EPSG_CODE_4326), Projection.get(EPSG_CODE_3857));

                assertTrue(sameTransformedCenterCoordinate.getDimension() == 2);
                assertEquals(transformedCenterCoordinate.getX(), sameTransformedCenterCoordinate.getX());
                assertEquals(transformedCenterCoordinate.getY(), transformedCenterCoordinate.getY());

                double x2 = -121.0;
                double y2 = 47.0;

                Coordinate coordinate = new Coordinate(x2, y2);

                Coordinate fromLotLanCoordinate = Projection.fromLonLat(coordinate);
                Coordinate transformedCoordinate = Projection.toLonLat(fromLotLanCoordinate);

                assertEquals(transformedCoordinate.getX(), coordinate.getX());
                assertEquals(transformedCoordinate.getY(), coordinate.getY());

            }
        });

    }

    /**
     * Tests extent transformation.
     */
    public void testTransformExtent() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                Extent extent = Projection.get(EPSG_CODE_4326).getExtent();

                Extent transformedExtent = Projection.transformExtent(extent, EPSG_CODE_4326, EPSG_CODE_3857);

                assertTrue(transformedExtent.getLength() == 4);
                assertNotSame(extent.getLowerLeftX(), transformedExtent.getLowerLeftX());
                assertNotSame(extent.getLowerLeftY(), transformedExtent.getLowerLeftY());
                assertNotSame(extent.getUpperRightX(), transformedExtent.getUpperRightX());
                assertNotSame(extent.getUpperRightY(), transformedExtent.getUpperRightY());
            }
        });

    }

}
