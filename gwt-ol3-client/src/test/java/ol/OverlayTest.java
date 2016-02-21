package ol;

/**
 *
 * @author Tino Desjardins
 *
 */
public class OverlayTest extends BaseTestCase {

    public void testOverlay() {

        OverlayOptions overlayOptions = OLFactory.createOptions();

        assertNotNull(overlayOptions);

        Overlay overlay = OLFactory.createOverlay(overlayOptions);

        assertNotNull(overlay);
        
        assertTrue(overlay instanceof Observable);
        assertTrue(overlay instanceof Object);

    }

}
