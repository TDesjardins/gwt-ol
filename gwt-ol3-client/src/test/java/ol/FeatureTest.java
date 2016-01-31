package ol;

/**
 * Test for {@link Feature}.
 *
 * @author Tino Desjardins
 *
 */
public class FeatureTest extends GwtOL3BaseTestCase {

    private static final String FEATURE_ID = "#1";
    
    public void testAttribution() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                Feature feature = new Feature();
                
                assertNotNull(feature);
                assertTrue(feature instanceof Object);
                assertTrue(feature instanceof Observable);
                
                feature.setId(FEATURE_ID);
                
                assertEquals(FEATURE_ID, feature.getId());

            }
            
        });

    }

}
