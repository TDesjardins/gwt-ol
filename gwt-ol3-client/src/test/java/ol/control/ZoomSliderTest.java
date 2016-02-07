package ol.control;

import ol.GwtOL3BaseTestCase;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ZoomSliderTest extends GwtOL3BaseTestCase {

    public void testZoomSlider() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                ZoomSlider zoomSlider = new ZoomSlider();
                
                assertNotNull(zoomSlider);
                assertTrue(zoomSlider instanceof Object);
                assertTrue(zoomSlider instanceof Control);
            }
        });

    }

}
