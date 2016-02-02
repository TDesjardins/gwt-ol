package ol.layer;

import ol.*;

/**
 * A test case for {@link ol.layer.Group}.
 * 
 * @author sbaumhekel
 */
public class LayerGroupTest extends BaseTestCase {

    @SuppressWarnings({ "static-method", "javadoc" })
    public void test() {
        // create empty layer group and ensure it is empty
        Group g = OLFactory.createLayerGroup(null);
        ol.Collection<ol.layer.Base> c = g.getLayers();
        assertEquals(0, c.getLength());
        // add two layers and ensure they are in there
        Layer v1 = OLFactory.createVector(OLFactory.createLayerOptionsWithSource(OLFactory.createVectorSource()));
        Layer v2 = OLFactory.createVector(OLFactory.createLayerOptionsWithSource(OLFactory.createVectorSource()));
        ol.Collection<ol.layer.Base> c2 = OLFactory.createCollection();
        c2.push(v1);
        c2.push(v2);
        g.setLayers(c2);
        c = g.getLayers();
        assertEquals(2, c.getLength());
    }

}
