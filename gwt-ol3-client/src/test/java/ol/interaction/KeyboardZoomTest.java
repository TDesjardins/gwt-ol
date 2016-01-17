package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class KeyboardZoomTest extends GwtOL3BaseTestCase {

    public void testKeyboardZoom() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                KeyboardZoom keyboardZoom = OLFactory.createKeyboardZoom();
                
                assertNotNull(keyboardZoom);
                assertTrue(keyboardZoom instanceof Observable);
                assertTrue(keyboardZoom instanceof Interaction);
            }
        });
 
    }

}
