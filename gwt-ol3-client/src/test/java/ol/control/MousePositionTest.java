package ol.control;

import ol.BaseTestCase;
import ol.Coordinate;
import ol.OLFactory;
import ol.OLUtil;
import ol.Object;
import ol.proj.Projection;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class MousePositionTest extends BaseTestCase {

    public void testMousePosition() {

        MousePosition mousePosition = OLFactory.createMousePosition();
        
        assertNotNull(mousePosition);
        assertTrue(mousePosition instanceof Object);
        assertTrue(mousePosition instanceof Control);
        
    }
    
    public void testMousePositionWithOptions() {
    	
    	Projection projection = OLUtil.getProjection("EPSG:4326");
    	String undefinedHtml = "no coordinates";
    	
    	MousePositionOptions mousePositionOptions = OLFactory.createOptions();
    	mousePositionOptions.setCoordinateFormat(Coordinate.createStringXY(5));
    	mousePositionOptions.setProjection(projection);
    	mousePositionOptions.setUndefinedHTML(undefinedHtml);
    	
    	MousePosition mousePosition = OLFactory.createMousePosition(mousePositionOptions);
    	
    	assertNotNull(mousePosition);
        assertTrue(mousePosition instanceof Object);
        assertTrue(mousePosition instanceof Control);
        
        assertNotNull(mousePosition.getProjection());
        assertEquals(projection, mousePosition.getProjection());
    	
    }

}
