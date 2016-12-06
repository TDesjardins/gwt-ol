package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class SnapTest extends GwtOL3BaseTestCase {

    public void testSnap() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                SnapOptions snapOptions = OLFactory.createOptions();
                Snap snap = new Snap(snapOptions);
                
                assertNotNull(snap);
                assertTrue(snap instanceof Observable);
                assertTrue(snap instanceof Interaction);
            }
            
        });
 
    }

}
