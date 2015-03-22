package ol.control;

import ol.BaseTestCase;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ScaleLineTest extends BaseTestCase {

    public void testScaleLine() {

        ScaleLine scaleLine = ScaleLine.newInstance();
        
        assertNotNull(scaleLine);
        assertTrue(scaleLine instanceof Object);
        assertTrue(scaleLine instanceof Control);
        
    }

}
