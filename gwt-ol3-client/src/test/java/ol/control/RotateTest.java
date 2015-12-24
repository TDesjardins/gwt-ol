package ol.control;

import ol.BaseTestCase;
import ol.OLFactory;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class RotateTest extends BaseTestCase {

    public void testRotate() {

        Rotate rotate = OLFactory.createRotate();
        
        assertNotNull(rotate);
        assertTrue(rotate instanceof Object);
        assertTrue(rotate instanceof Control);
        
    }

}
