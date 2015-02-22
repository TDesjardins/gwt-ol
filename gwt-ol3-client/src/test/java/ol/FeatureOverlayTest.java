package ol;

import ol.BaseTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class FeatureOverlayTest extends BaseTestCase {

    public void testFeatureOverlay() {
        
        FeatureOverlayOptions featureOverlayOptions = FeatureOverlayOptions.newInstance();
        
        assertNotNull(featureOverlayOptions);
        
        FeatureOverlay featureOverlay = FeatureOverlay.newInstance(featureOverlayOptions);
        
        assertNotNull(featureOverlay);
        
    }

}
