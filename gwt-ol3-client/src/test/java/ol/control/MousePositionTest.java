package ol.control;

import ol.BaseTestCase;
import ol.OLFactory;
import ol.Object;

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

}
