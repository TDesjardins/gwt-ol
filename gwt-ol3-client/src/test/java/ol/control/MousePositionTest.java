package ol.control;

import ol.BaseTestCase;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class MousePositionTest extends BaseTestCase {

    public void testMousePosition() {

        MousePosition mousePosition = MousePosition.newInstance();
        
        assertNotNull(mousePosition);
        assertTrue(mousePosition instanceof Object);
        assertTrue(mousePosition instanceof Control);
        
    }

}
