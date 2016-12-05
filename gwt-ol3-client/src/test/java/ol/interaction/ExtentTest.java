package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ExtentTest extends GwtOL3BaseTestCase {

    public void testExtent() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                Extent extent = new Extent();
                
                assertNotNull(extent);
                assertTrue(extent instanceof Observable);
                assertTrue(extent instanceof Interaction);
            }
            
        });

    }

}
