package ol.interaction;

import ol.*;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class KeyboardPanTest extends BaseTestCase {

    public void testKeyboardPan() {

        KeyboardPan keyboardPan = OLFactory.createKeyboardPan();
        
        assertNotNull(keyboardPan);
        assertTrue(keyboardPan instanceof Observable);
        assertTrue(keyboardPan instanceof Interaction);
        
    }

}
