package ol.source;

import ol.GwtOL3BaseTestCase;

/**
 * A test case for {@link ol.source.TileWMS}.
 *
 * @author Peter Zanetti
 */
public class TileWMSTest extends GwtOL3BaseTestCase {

    @SuppressWarnings({ "static-method", "javadoc" })
    public void testTileWMS() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {

                TileWMSParams params = new TileWMSParams();
                params.setLayers("topp:states");
                params.setTiled(true);

                TileWMSOptions options = new TileWMSOptions();
                options.setUrl("https://ahocevar.com/geoserver/wms");
                options.setParams(params);
                options.setServerType(WMSServerType.GEOSERVER);

                TileWMS source = new TileWMS(options);

                assertEquals("topp:states", source.getParams().getLayers());

                params.setLayers("topp");

                source.updateParams(params);
                assertEquals("topp", source.getParams().getLayers());
            }

        });

    }

}
