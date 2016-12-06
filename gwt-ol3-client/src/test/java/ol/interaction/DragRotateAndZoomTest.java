package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DragRotateAndZoomTest extends GwtOL3BaseTestCase {

    public void testDragRotateAndZoom() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                DragRotateAndZoom dragRotateAndZoom = new DragRotateAndZoom();
                
                assertNotNull(dragRotateAndZoom);
                assertTrue(dragRotateAndZoom instanceof Observable);
                assertTrue(dragRotateAndZoom instanceof Interaction);
                assertTrue(dragRotateAndZoom instanceof Pointer);
            }
            
        });

    }

}
