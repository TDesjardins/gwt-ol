package ol.control;

import ol.GwtOL3BaseTestCase;
import ol.Object;

/**
 *
 * @author Tino Desjardins
 *
 */
public class FullScreenTest extends GwtOL3BaseTestCase {

    public void testFullScreen() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                FullScreen fullScreen = new FullScreen();

                assertNotNull(fullScreen);
                assertTrue(fullScreen instanceof Object);
                assertTrue(fullScreen instanceof Control);
            }
        });

    }

}
