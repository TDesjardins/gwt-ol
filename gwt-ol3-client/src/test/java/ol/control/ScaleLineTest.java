package ol.control;

import ol.*;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ScaleLineTest extends BaseTestCase {

    public void testScaleLine() {

        ScaleLine scaleLine = OLFactory.createScaleLine();
        
        assertNotNull(scaleLine);
        assertTrue(scaleLine instanceof Object);
        assertTrue(scaleLine instanceof Control);
        
    }

}
