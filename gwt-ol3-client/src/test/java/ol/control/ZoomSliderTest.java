package ol.control;

import ol.BaseTestCase;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ZoomSliderTest extends BaseTestCase {

    public void testZoomSlider() {

        ZoomSlider zoomSlider = ZoomSlider.newInstance();
        
        assertNotNull(zoomSlider);
        assertTrue(zoomSlider instanceof Object);
        assertTrue(zoomSlider instanceof Control);
        
    }

}
