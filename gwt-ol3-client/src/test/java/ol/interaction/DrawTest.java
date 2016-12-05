package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DrawTest extends GwtOL3BaseTestCase {

    public void testDraw() {

        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                DrawOptions drawOptions = OLFactory.createOptions();
                Draw draw = new Draw(drawOptions);
                
                assertNotNull(draw);
                assertTrue(draw instanceof Observable);
                assertTrue(draw instanceof Interaction);
                
                draw.setActive(true);

            }
            
        });

    }

}
