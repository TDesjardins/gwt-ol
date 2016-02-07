package ol;

import ol.View;
import ol.ViewOptions;
import ol.proj.Projection;
import ol.OLFactory;
import ol.proj.ProjectionOptions;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ViewTest extends GwtOL3BaseTestCase {

    public void testView() {
        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                ProjectionOptions projectionOptions = OLFactory.createOptions();
                projectionOptions.setCode("EPSG:21781");
                projectionOptions.setUnits("m");
                
                assertNotNull(projectionOptions);
                
                Projection projection = new Projection(projectionOptions);
                
                assertNotNull(projection);
                
                ViewOptions viewOptions = OLFactory.createOptions();
                viewOptions.setProjection(projection);
                View view = new View(viewOptions);

                Coordinate centerCoordinate = OLFactory.createCoordinate(660000, 190000);
                
                view.setCenter(centerCoordinate);
                view.setZoom(9);
                
                assertNotNull(view);
                assertTrue(view instanceof Object);
                
            }
            
        });
        
    }

}
