package ol;

import ol.View;
import ol.MapOptions;
import ol.ViewOptions;
import ol.proj.Projection;
import ol.OLFactory;
import ol.proj.ProjectionOptions;

/**
 *
 * @author Tino Desjardins
 *
 */
public class MapTest extends GwtOL3BaseTestCase {

    public void testMapCreation() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {

                ProjectionOptions projectionOptions = OLFactory.createOptions();
                projectionOptions.setCode("EPSG:21781");
                projectionOptions.setUnits("m");

                Projection projection = new Projection(projectionOptions);

                ViewOptions viewOptions = OLFactory.createOptions();
                viewOptions.setProjection(projection);
                View view = new View(viewOptions);

                Coordinate centerCoordinate = OLFactory.createCoordinate(660000, 190000);

                view.setCenter(centerCoordinate);
                view.setZoom(9);

                final MapOptions mapOptions = OLFactory.createOptions();
                mapOptions.setTarget("map");
                mapOptions.setView(view);

                Map map = new Map(mapOptions);
                assertNotNull(map);

            }

        });

    }

}
