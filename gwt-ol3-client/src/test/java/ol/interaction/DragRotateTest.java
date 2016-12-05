package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DragRotateTest extends GwtOL3BaseTestCase {

    public void testDragAndDrop() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                DragRotate dragRotate = new DragRotate();
                
                assertNotNull(dragRotate);
                assertTrue(dragRotate instanceof Observable);
                assertTrue(dragRotate instanceof Interaction);
                assertTrue(dragRotate instanceof Pointer);
            }
            
        });

    }

}
