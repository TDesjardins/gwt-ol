package ol.control;

import ol.BaseTestCase;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class FullScreenTest extends BaseTestCase {

    public void testFullScreen() {

        FullScreen fullScreen = FullScreen.newInstance();
        
        assertNotNull(fullScreen);
        assertTrue(fullScreen instanceof Object);
        assertTrue(fullScreen instanceof Control);
        
    }

}
