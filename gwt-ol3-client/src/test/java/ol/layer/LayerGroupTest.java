package ol.layer;

import ol.Collection;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.source.Vector;

/**
 * A test case for {@link ol.layer.Group}.
 *
 * @author sbaumhekel
 * @author Tino Desjardins
 *
 */
public class LayerGroupTest extends GwtOL3BaseTestCase {

    @SuppressWarnings({ "static-method", "javadoc" })
    public void testLayerGroup() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {

                // create empty layer group and ensure it is empty
                Group layerGroup = new Group();
                Collection<ol.layer.Base> layers1 = layerGroup.getLayers();

                assertEquals(0, layers1.getLength());

                // add two layers and ensure they are in there
                Layer vectorLayer1 = OLFactory.createVector(OLFactory.createLayerOptionsWithSource(new Vector()));
                Layer vectorLayer2 = OLFactory.createVector(OLFactory.createLayerOptionsWithSource(new Vector()));

                ol.Collection<Base> layers2 = new Collection<Base>();
                layers2.push(vectorLayer1);
                layers2.push(vectorLayer2);
                layerGroup.setLayers(layers2);
                layers1 = layerGroup.getLayers();

                assertEquals(2, layers1.getLength());

            }

        });

    }

}
