package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
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
                DragAndDrop dragAndDrop = OLFactory.createDragAndDrop();
                
                assertNotNull(dragAndDrop);
                assertTrue(dragAndDrop instanceof Observable);
                assertTrue(dragAndDrop instanceof Interaction);
            }
            
        });

    }

}
