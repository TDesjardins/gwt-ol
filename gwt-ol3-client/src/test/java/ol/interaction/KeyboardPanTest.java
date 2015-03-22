package ol.interaction;

import ol.BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class KeyboardPanTest extends BaseTestCase {

    public void testKeyboardPan() {

        KeyboardPan keyboardPan = KeyboardPan.newInstance();
        
        assertNotNull(keyboardPan);
        assertTrue(keyboardPan instanceof Observable);
        assertTrue(keyboardPan instanceof Interaction);
        
    }

}
