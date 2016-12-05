package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DragBoxTest extends GwtOL3BaseTestCase {

    public void testDragBox() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                DragBox dragBox = new DragBox();
                
                assertNotNull(dragBox);
                assertTrue(dragBox instanceof Observable);
                assertTrue(dragBox instanceof Interaction);
            }
            
        });

    }

}
