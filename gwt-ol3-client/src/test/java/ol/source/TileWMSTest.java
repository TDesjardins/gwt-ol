package ol.source;

import ol.GwtOL3BaseTestCase;
import tol.j2cl.elem.global.Map;

/**
 * A test case for {@link ol.source.TileWMS}.
 *
 * @author Peter Zanetti
 *
 */
public class TileWMSTest extends GwtOL3BaseTestCase {

	@SuppressWarnings({ "static-method", "javadoc" })
	public void testTileWMS() {

		injectUrlAndTest(new TestWithInjection() {

			@Override
			public void test() {

				TileWMSParams tileWMSParams = new TileWMSParams();
				tileWMSParams.setLayers("topp:states");
				tileWMSParams.setTiled(true);

				TileWMSOptions options = new TileWMSOptions();
				options.setUrl("https://ahocevar.com/geoserver/wms");
				options.setParams(tileWMSParams);
				options.setServerType(WMSServerType.GEOSERVER);

				TileWMS source = new TileWMS(options);

				assertEquals("topp:states", source.getParams().get("LAYERS"));
				assertEquals("topp:states", source.getTileWMSParams().LAYERS);

				Map<String> params = new Map<>();
				params.set("LAYERS", "topp");

				source.updateParams(params);
				assertEquals("topp", source.getParams().get("LAYERS"));
			}

		});

	}

}
