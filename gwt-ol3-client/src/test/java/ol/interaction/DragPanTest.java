package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DragPanTest extends GwtOL3BaseTestCase {

    public void testDragPan() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                DragPan dragPan = new DragPan();
                
                assertNotNull(dragPan);
                assertTrue(dragPan instanceof Observable);
                assertTrue(dragPan instanceof Interaction);
            }
            
        });

    }

}
