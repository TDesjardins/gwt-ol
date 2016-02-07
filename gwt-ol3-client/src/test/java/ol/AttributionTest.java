package ol;

/**
 *
 * @author Tino Desjardins
 *
 */
public class AttributionTest extends GwtOL3BaseTestCase {

    public void testAttribution() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                AttributionOptions attributionOptions = OLFactory.createOptions();
                assertNotNull(attributionOptions);
                
                Attribution attribution = new Attribution(attributionOptions);
                assertNotNull(attribution);
                
            }
            
        });

    }

}
