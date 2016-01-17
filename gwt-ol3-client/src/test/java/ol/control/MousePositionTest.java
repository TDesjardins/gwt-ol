package ol.control;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class MousePositionTest extends GwtOL3BaseTestCase {

    public void testMousePosition() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                MousePosition mousePosition = OLFactory.createMousePosition();
                
                assertNotNull(mousePosition);
                assertTrue(mousePosition instanceof Object);
                assertTrue(mousePosition instanceof Control);
            }
        });
  
    }

}
