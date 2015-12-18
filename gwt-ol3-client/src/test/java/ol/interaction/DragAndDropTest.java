package ol.interaction;

import ol.*;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DragAndDropTest extends BaseTestCase {

    public void testDragAndDrop() {

        DragAndDrop dragAndDrop = OLFactory.createDragAndDrop();
        
        assertNotNull(dragAndDrop);
        assertTrue(dragAndDrop instanceof Observable);
        assertTrue(dragAndDrop instanceof Interaction);
        
    }

}
