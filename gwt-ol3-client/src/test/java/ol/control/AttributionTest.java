package ol.control;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class AttributionTest extends GwtOL3BaseTestCase {

    public void testAttribution() {

        this.injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                Attribution attribution = OLFactory.createAttributionControl();
                assertNotNull(attribution);
            }
        });

    }

}
