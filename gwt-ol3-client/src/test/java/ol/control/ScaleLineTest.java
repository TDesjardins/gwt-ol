package ol.control;

import ol.GwtOL3BaseTestCase;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ScaleLineTest extends GwtOL3BaseTestCase {

    public void testScaleLine() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                ScaleLine scaleLine = new ScaleLine();
                
                assertNotNull(scaleLine);
                assertTrue(scaleLine instanceof Object);
                assertTrue(scaleLine instanceof Control);
            }
        });
        
    }

}
