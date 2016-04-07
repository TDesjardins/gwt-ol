package ol.geom;

import ol.BaseTestCase;
import ol.Coordinate;
import ol.OLFactory;

/**
 * A test case for {@link Point}.
 *
 * @author Tino Desjardins
 */
public class PointTest extends BaseTestCase {

    public void test() {

        Point point = OLFactory.createPoint(1, 2);
        assertNotNull(point);
        assertTrue(point instanceof Geometry);

        Coordinate coordinate = point.getCoordinates();
        assertNotNull(coordinate);
        assert(1 == coordinate.getX());
        assert(2 == coordinate.getY());

    }

}
