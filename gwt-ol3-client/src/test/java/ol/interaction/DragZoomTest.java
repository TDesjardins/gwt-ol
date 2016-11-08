package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DragZoomTest extends GwtOL3BaseTestCase {

    public void testDragZoom() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                DragZoom dragZoom = new DragZoom();
                
                assertNotNull(dragZoom);
                assertTrue(dragZoom instanceof Observable);
                assertTrue(dragZoom instanceof Interaction);
                assertTrue(dragZoom instanceof Pointer);
            }
            
        });

    }

}
