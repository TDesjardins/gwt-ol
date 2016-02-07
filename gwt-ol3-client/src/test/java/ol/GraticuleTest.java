package ol;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class GraticuleTest extends GwtOL3BaseTestCase {

    public void testGraticule() {
        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                Graticule graticule = new Graticule();
                
                assertNotNull(graticule);
            }
        });
        
    }

}
