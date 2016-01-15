package ol.geom;

import ol.*;

/**
 * A test case for {@link GeometryCollection}.
 * 
 * @author sbaumhekel
 */
public class GeometryCollectionTest extends BaseTestCase {

    public void test() {
	Geometry[] geoms = new Geometry[] { OLFactory.createPoint(1, 2), OLFactory.createLineString(
		new Coordinate[] { OLFactory.createCoordinate(1, 2), OLFactory.createCoordinate(2, 3) }) };
	GeometryCollection col = OLFactory.createGeometryCollection(geoms);
	assertNotNull(col);
	Geometry[] geoms2 = col.getGeometries();
	assertNotNull(geoms2);
	assertEquals(2, geoms2.length);
	Geometry g1 = geoms2[0];
	Geometry g2 = geoms2[1];
	assertNotNull(g1);
	assertNotNull(g2);
	assertEquals(Geometry.POINT, g1.getType());
	assertEquals(Geometry.LINE_STRING, g2.getType());
    }

}
