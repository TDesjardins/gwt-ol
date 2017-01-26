package ol.source;

import ol.GwtOL3BaseTestCase;
import tol.j2cl.elem.global.Map;

/**
 * A test case for {@link ol.source.ImageArcGISRest}.
 *
 * @author Peter Zanetti
 *
 */
public class ImageArcGISRestTest extends GwtOL3BaseTestCase {

    @SuppressWarnings({ "static-method", "javadoc" })
    public void testImageArcGISRest() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {

          		Map<String> params = new Map<>();
          		params.set("layers", "show:1");

                assertEquals("show:1", params.get("layers"));

            		ImageArcGISRestOptions options = new ImageArcGISRestOptions();
            		options.setUrl(
            				"https://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Specialty/ESRI_StateCityHighway_USA/MapServer");
            		options.setParams(params);
            		options.setRatio(1.5f);
            		
                assertEquals(1.5f, options.getRatio());                
                assertNotNull(options.getParams());
                assertEquals("show:1", options.getParams().get("layers"));
                
            		ImageArcGISRest source = new ImageArcGISRest(options);            		
                assertNotNull(source.getImageLoadFunction());
            }

        });

    }

}
