package ol.control;

import ol.GwtOL3BaseTestCase;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class RotateTest extends GwtOL3BaseTestCase {

    public void testRotate() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                Rotate rotate = new Rotate();
                
                assertNotNull(rotate);
                assertTrue(rotate instanceof Object);
                assertTrue(rotate instanceof Control);
            }
            
        });
 
    }

}
