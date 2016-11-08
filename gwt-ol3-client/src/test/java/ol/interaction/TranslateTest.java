package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class TranslateTest extends GwtOL3BaseTestCase {

    public void testTranslate() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                TranslateOptions translateOptions = OLFactory.createOptions();
                Translate translate = new Translate(translateOptions);
                
                assertNotNull(translate);
                assertTrue(translate instanceof Observable);
                assertTrue(translate instanceof Interaction);
            }
            
        });
 
    }

}
