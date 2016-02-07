package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DragAndDropTest extends GwtOL3BaseTestCase {

    public void testDragAndDrop() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                DragAndDrop dragAndDrop = new DragAndDrop();
                
                assertNotNull(dragAndDrop);
                assertTrue(dragAndDrop instanceof Observable);
                assertTrue(dragAndDrop instanceof Interaction);
            }
            
        });

    }

}
