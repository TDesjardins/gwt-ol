package ol;

import ol.BaseTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class AttributionTest extends BaseTestCase {

    public void testAttribution() {
        
        AttributionOptions attributionOptions = AttributionOptions.newInstance();
        
        assertNotNull(attributionOptions);
        
        Attribution attribution = Attribution.newInstance(attributionOptions);
        
        assertNotNull(attribution);
        
    }

}
