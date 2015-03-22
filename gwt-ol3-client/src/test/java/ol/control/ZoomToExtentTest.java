package ol.control;

import ol.BaseTestCase;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ZoomToExtentTest extends BaseTestCase {

    public void testZoomToExtent() {

        ZoomToExtent zoomToExtent = ZoomToExtent.newInstance();
        
        assertNotNull(zoomToExtent);
        assertTrue(zoomToExtent instanceof Object);
        assertTrue(zoomToExtent instanceof Control);
        
    }

}
