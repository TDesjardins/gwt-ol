package ol.control;

import ol.BaseTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class AttributionTest extends BaseTestCase {

    public void testAttribution() {

        
        Attribution attribution = Attribution.newInstance();
        
        assertNotNull(attribution);
        
    }

}
