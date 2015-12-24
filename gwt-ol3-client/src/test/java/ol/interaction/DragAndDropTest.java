package ol.interaction;

import ol.BaseTestCase;
import ol.OLFactory;
import ol.Observable;

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
