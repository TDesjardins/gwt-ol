package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class PinchZoomTest extends GwtOL3BaseTestCase {

    public void testPinchZoom() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                PinchZoom pinchZoom = new PinchZoom();
                
                assertNotNull(pinchZoom);
                assertTrue(pinchZoom instanceof Observable);
                assertTrue(pinchZoom instanceof Interaction);
            }
            
        });
 
    }

}
