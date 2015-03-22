package ol.interaction;

import ol.BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class KeyboardZoomTest extends BaseTestCase {

    public void testKeyboardZoom() {

        KeyboardZoom keyboardZoom = KeyboardZoom.newInstance();
        
        assertNotNull(keyboardZoom);
        assertTrue(keyboardZoom instanceof Observable);
        assertTrue(keyboardZoom instanceof Interaction);
        
    }

}
