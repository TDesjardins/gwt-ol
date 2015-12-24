package ol.control;

import ol.BaseTestCase;
import ol.OLFactory;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class AttributionTest extends BaseTestCase {

    public void testAttribution() {

        
        Attribution attribution = OLFactory.createAttributionControl();
        
        assertNotNull(attribution);
        
    }

}
