package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class KeyboardPanTest extends GwtOL3BaseTestCase {

    public void testKeyboardPan() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                KeyboardPan keyboardPan = new KeyboardPan();
                
                assertNotNull(keyboardPan);
                assertTrue(keyboardPan instanceof Observable);
                assertTrue(keyboardPan instanceof Interaction);
            }
            
        });
 
    }

}
