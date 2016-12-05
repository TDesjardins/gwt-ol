package ol;

/**
 * Test for {@link Sphere}.
 *
 * @author Tino Desjardins
 *
 */
public class SphereTest extends GwtOL3BaseTestCase {
    
    public void testAttribution() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                Sphere sphere = new Sphere(OLUtil.EARTH_RADIUS_NORMAL);
                
                assertNotNull(sphere);

            }
            
        });

    }

}
