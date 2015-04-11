package ol.proj;

import ol.proj.Projection;
import ol.OLFactory;
import ol.proj.ProjectionOptions;
import ol.BaseTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ProjectionTest extends BaseTestCase {

	private static final String EPSG_CODE_4326 = "EPSG:4326";
	private static final String EPSG_CODE_3857 = "EPSG:3857";
	private static final String EPSG_CODE_21781 = "EPSG:21781";
	private static final String UNIT_METRE = "m";
	private static final String UNIT_DEGREES = "degrees";
	
    public void testProjection() {
    	
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.code(EPSG_CODE_21781)
            .units(UNIT_METRE);
        
        Projection projection = Projection.newInstance(projectionOptions);
        
        assertNotNull(projection);
        assertEquals(EPSG_CODE_21781, projection.getCode());
        assertEquals(UNIT_METRE, projection.getUnits());
        
    }
    
    public void testGet() {
    	
    	Projection projection = Projection.get(EPSG_CODE_4326);
        
        assertNotNull(projection);
        assertEquals(EPSG_CODE_4326, projection.getCode());
        assertTrue(projection.isGlobal());
        assertTrue(projection.getExtent().length == 4);
        assertEquals(projection.getUnits(), UNIT_DEGREES);
        
    }
    
    /**
     * Tests coordinate transformation.
     */
    public void testTransform() {
    	
    	double x = -121.1;
    	double y = 47.5;
    	
    	double[] centerCoordinate = OLFactory.createCoordinate(x, y);
        double[] transformedCenterCoordinate = Projection.transform(centerCoordinate, EPSG_CODE_4326, EPSG_CODE_3857); 
        
        assertTrue(transformedCenterCoordinate.length == 2);
        assertNotSame(transformedCenterCoordinate[0], x);
        assertNotSame(transformedCenterCoordinate[1], y);
        
    }

}
