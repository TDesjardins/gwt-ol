package ol.proj;

import ol.*;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ProjectionTest extends BaseTestCase {

	private static final String EPSG_CODE_4326 = "EPSG:4326";
	private static final String EPSG_CODE_3068 = "EPSG:3068";
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
    
    public void testAddProjection() {
    	
    	ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.code(EPSG_CODE_3068)
        	.global(false)
            .units(UNIT_METRE);
        
        Projection projection = Projection.newInstance(projectionOptions);
        assertNotNull(projection);
        
        Projection.addProjection(projection);
        
        Projection projectionToCompare = Projection.get(EPSG_CODE_3068);
        assertNotNull(projectionToCompare);
        
        assertEquals(projection.getCode(), projectionToCompare.getCode());
        
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
    	
    	Coordinate centerCoordinate = OLFactory.createCoordinate(x, y);
    	Coordinate transformedCenterCoordinate = Projection.transform(centerCoordinate, EPSG_CODE_4326, EPSG_CODE_3857); 
        
        assertTrue(transformedCenterCoordinate.length() == 2);
        assertNotSame(transformedCenterCoordinate.getX(), x);
        assertNotSame(transformedCenterCoordinate.getY(), y);
        
    }
    
    /**
     * Tests extent transformation.
     */
    public void testTransformExtent() {
    	
    	double[] extent = Projection.get(EPSG_CODE_4326).getExtent();
    	
        double[] transformedExtent = Projection.transformExtent(extent, EPSG_CODE_4326, EPSG_CODE_3857); 
        
        assertTrue(transformedExtent.length == 4);
        assertNotSame(extent[0], transformedExtent[0]);
        assertNotSame(extent[1], transformedExtent[1]);
        assertNotSame(extent[2], transformedExtent[2]);
        assertNotSame(extent[3], transformedExtent[3]);
        
    }

}
