package ol.interaction;

import ol.*;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class KeyboardZoomTest extends BaseTestCase {

    public void testKeyboardZoom() {

        KeyboardZoom keyboardZoom = OLFactory.createKeyboardZoom();
        
        assertNotNull(keyboardZoom);
        assertTrue(keyboardZoom instanceof Observable);
        assertTrue(keyboardZoom instanceof Interaction);
        
    }

}
