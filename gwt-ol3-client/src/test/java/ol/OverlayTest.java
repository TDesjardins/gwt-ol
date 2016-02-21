package ol;

/**
 *
 * @author Tino Desjardins
 *
 */
public class OverlayTest extends GwtOL3BaseTestCase {

    public void testOverlay() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                
                OverlayOptions overlayOptions = OLFactory.createOptions();

                assertNotNull(overlayOptions);

                Overlay overlay = OLFactory.createOverlay(overlayOptions);

                assertNotNull(overlay);
                
                assertTrue(overlay instanceof Observable);
                assertTrue(overlay instanceof Object);
                
            }
            
        });

    }

}
