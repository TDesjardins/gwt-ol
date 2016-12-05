package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DoubleClickZoomTest extends GwtOL3BaseTestCase {

    public void testDoubleClickZoom() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                DoubleClickZoom doubleClickZoom = new DoubleClickZoom();
                
                assertNotNull(doubleClickZoom);
                assertTrue(doubleClickZoom instanceof Observable);
                assertTrue(doubleClickZoom instanceof Interaction);
            }
            
        });

    }

}
