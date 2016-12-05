package ol.interaction;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class SelectTest extends GwtOL3BaseTestCase {

    public void testSelect() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                SelectOptions selectOptions = OLFactory.createOptions();
                Select select = new Select(selectOptions);
                
                assertNotNull(select);
                assertTrue(select instanceof Observable);
                assertTrue(select instanceof Interaction);
            }
            
        });
 
    }

}
