package ol.layer;

import ol.BaseTestCase;
import ol.OLFactory;
import ol.Observable;

/**
 * A test case for {@link ol.layer.Group}.
 * 
 * @author sbaumhekel
 */
public class LayerGroupTest extends BaseTestCase {

    @SuppressWarnings({ "static-method", "javadoc" })
    public void test() {
        
    	// create empty layer group and ensure it is empty
        Group layerGroup = OLFactory.createLayerGroup(null);
        assertNotNull(layerGroup);
        assertTrue(layerGroup instanceof Observable);
        assertTrue(layerGroup instanceof Base);
        
        ol.Collection<ol.layer.Base> layers = layerGroup.getLayers();
        assertNotNull(layers);
        assertEquals(0, layers.getLength());
        
        // add two layers and ensure they are in there
        Layer v1 = OLFactory.createVector(OLFactory.createLayerOptionsWithSource(OLFactory.createVectorSource()));
        Layer v2 = OLFactory.createVector(OLFactory.createLayerOptionsWithSource(OLFactory.createVectorSource()));
        
        ol.Collection<ol.layer.Base> newLayers = OLFactory.createCollection();
        newLayers.push(v1);
        newLayers.push(v2);
        layerGroup.setLayers(newLayers);
        layers = layerGroup.getLayers();
        assertEquals(2, layers.getLength());
    }

}
