package ol.geom;

import ol.Coordinate;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;

/**
 * A test case for {@link Circle}.
 *
 * @author Tino Desjardins
 */
public class CircleTest extends GwtOL3BaseTestCase {

    public void testCircle() {

    	injectUrlAndTest(new TestWithInjection() {

			@Override
			public void test() {
				
				double radius = 5;
		        
		        Circle circle = OLFactory.createCircle(OLFactory.createCoordinate(10, 10), radius);
		        assertNotNull(circle);
		        assertTrue(circle instanceof Geometry);

		        Coordinate coordinate = circle.getCenter();
		        assertNotNull(coordinate);
		        assert(10 == coordinate.getX());
		        assert(10 == coordinate.getY());
		        
		        assert(radius == circle.getRadius());

			}});  	
                
    }

}
