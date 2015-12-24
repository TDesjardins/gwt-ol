package ol.interaction;

import ol.BaseTestCase;
import ol.OLFactory;
import ol.Observable;

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
