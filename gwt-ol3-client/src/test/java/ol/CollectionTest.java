package ol;

import ol.control.Attribution;
import ol.control.Control;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class CollectionTest extends GwtOL3BaseTestCase {

    public void testCollection() {
        
        this.injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                Collection<Control> controls = new Collection<Control>();
                
                assertNotNull(controls);
                assertTrue(controls.getLength() == 0);
                
                assertNotNull(controls.getArray());
                
                controls.push(new Attribution());
                
                assertTrue(controls.getLength() == 1);
                
                //assertTrue(controls.getArray().length == 1);
                
                //Control[] controlArray = controls.getArray();
            }
        });
        
    }

}
