package ol.proj;

import com.google.gwt.core.client.JsArrayNumber;

import ol.Coordinate;
import ol.Extent;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;

/**
 *
 * @author Tino Desjardins
 *
 */
public class ProjectionTest extends GwtOL3BaseTestCase {

	private static final String EPSG_CODE_4326 = "EPSG:4326";
	private static final String EPSG_CODE_3068 = "EPSG:3068";
	private static final String EPSG_CODE_3857 = "EPSG:3857";
	private static final String EPSG_CODE_21781 = "EPSG:21781";
	private static final String UNIT_METRE = "m";
	private static final String UNIT_DEGREES = "degrees";

    public void testProjection() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                ProjectionOptions projectionOptions = OLFactory.createOptions();
                projectionOptions.setCode(EPSG_CODE_21781);
                projectionOptions.setUnits(UNIT_METRE);

                Projection projection = new Projection(projectionOptions);

                assertNotNull(projection);
                assertEquals(EPSG_CODE_21781, projection.getCode());
                assertEquals(UNIT_METRE, projection.getUnits());
            }

        });

    }

    public void testAddProjection() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {

                ProjectionOptions projectionOptions = OLFactory.createOptions();
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
                assertTrue(projection.getExtent().<JsArrayNumber>cast().length() == 4);
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

                Coordinate centerCoordinate = OLFactory.createCoordinate(x, y);
                Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, EPSG_CODE_4326, EPSG_CODE_3857);

                assertTrue(transformedCenterCoordinate.length() == 2);
                assertNotSame(transformedCenterCoordinate.getX(), x);
                assertNotSame(transformedCenterCoordinate.getY(), y);
                
                Coordinate sameTransformedCenterCoordinate = Projection.transform(centerCoordinate, Projection.get(EPSG_CODE_4326), Projection.get(EPSG_CODE_3857));
                
                assertTrue(sameTransformedCenterCoordinate.length() == 2);
                assertSame(transformedCenterCoordinate.getX(), sameTransformedCenterCoordinate.getX());
                assertSame(transformedCenterCoordinate.getY(), transformedCenterCoordinate.getY());
                
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

                assertTrue(transformedExtent.<JsArrayNumber>cast().length() == 4);
                assertNotSame(extent.getLowerLeftX(), transformedExtent.getLowerLeftX());
                assertNotSame(extent.getLowerLeftY(), transformedExtent.getLowerLeftY());
                assertNotSame(extent.getUpperRightX(), transformedExtent.getUpperRightX());
                assertNotSame(extent.getUpperRightY(), transformedExtent.getUpperRightY());
            }
        });

    }

}
