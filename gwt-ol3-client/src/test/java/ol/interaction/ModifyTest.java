package ol.interaction;

import ol.Collection;
import ol.Feature;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ModifyTest extends GwtOL3BaseTestCase {

    public void testModify() {

        ModifyOptions modifyOptions = OLFactory.createOptions();
        Collection<Feature> features = new Collection<Feature>();

        modifyOptions.setFeatures(features);
        Modify modify = new Modify(modifyOptions);
        
        assertNotNull(modify);
        assertTrue(modify instanceof Observable);
        assertTrue(modify instanceof Interaction);
        
    }

}
