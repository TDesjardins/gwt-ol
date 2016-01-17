package ol.control;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
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
                ScaleLine scaleLine = OLFactory.createScaleLine();
                
                assertNotNull(scaleLine);
                assertTrue(scaleLine instanceof Object);
                assertTrue(scaleLine instanceof Control);
            }
        });
        
    }

}
