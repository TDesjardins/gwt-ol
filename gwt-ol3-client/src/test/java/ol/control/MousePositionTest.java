package ol.control;

import ol.*;
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
