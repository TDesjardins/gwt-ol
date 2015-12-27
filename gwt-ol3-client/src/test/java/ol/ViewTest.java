package ol;

import ol.View;
import ol.ViewOptions;
import ol.proj.Projection;
import ol.OLFactory;
import ol.proj.ProjectionOptions;
import ol.BaseTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ViewTest extends BaseTestCase {

    public void testView() {
        
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.code("EPSG:21781")
            .units("m");
        
        assertNotNull(projectionOptions);
        
        Projection projection = OLFactory.createProjection(projectionOptions);
        
        assertNotNull(projection);
        
        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setProjection(projection);
        View view = OLFactory.createView(viewOptions);

        Coordinate centerCoordinate = OLFactory.createCoordinate(660000, 190000);
        
        view.setCenter(centerCoordinate);
        view.setZoom(9);
        
        assertNotNull(view);
        assertTrue(view instanceof Object);
        
    }

}
