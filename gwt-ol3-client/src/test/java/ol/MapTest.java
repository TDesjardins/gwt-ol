package ol;

import ol.View;
import ol.MapOptions;
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
public class MapTest extends BaseTestCase {

    public void testMapCreation() {
        
        // TODO Add OL3-script.
        
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.code("EPSG:21781")
            .units("m");
        
        Projection projection = Projection.newInstance(projectionOptions);
        
        ViewOptions viewOptions = OLFactory.createOptions();
        viewOptions.setProjection(projection);
        View view = OLFactory.createView(viewOptions);

        Coordinate centerCoordinate = OLFactory.createCoordinate(660000, 190000);
        
        view.setCenter(centerCoordinate);
        view.setZoom(9);
        
        final MapOptions mapOptions = OLFactory.createMapOptions();
        mapOptions.setTarget("map");
        mapOptions.setView(view);
        
        /*Map map = Map.newInstance(mapOptions);
        assertNotNull(map);*/
        
    }

}
