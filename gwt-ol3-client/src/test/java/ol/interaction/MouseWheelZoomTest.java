package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class MouseWheelZoomTest extends GwtOL3BaseTestCase {

    public void testMouseWheelZoom() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                MouseWheelZoom mouseWheelZoom = new MouseWheelZoom();
                
                assertNotNull(mouseWheelZoom);
                assertTrue(mouseWheelZoom instanceof Observable);
                assertTrue(mouseWheelZoom instanceof Interaction);
            }
            
        });
 
    }

}
