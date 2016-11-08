package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class PinchRotateTest extends GwtOL3BaseTestCase {

    public void testPinchRotate() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                PinchRotate pinchRotate = new PinchRotate();
                
                assertNotNull(pinchRotate);
                assertTrue(pinchRotate instanceof Observable);
                assertTrue(pinchRotate instanceof Interaction);
            }
            
        });
 
    }

}
