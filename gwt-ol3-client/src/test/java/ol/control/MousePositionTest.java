package ol.control;

import ol.Coordinate;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.Object;
import ol.proj.Projection;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class MousePositionTest extends GwtOL3BaseTestCase {

    public void testMousePosition() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                MousePosition mousePosition = new MousePosition();
                
                assertNotNull(mousePosition);
                assertTrue(mousePosition instanceof Object);
                assertTrue(mousePosition instanceof Control);
            }
        });
  
    }
    
	public void testMousePositionWithOptions() {

		injectUrlAndTest(new TestWithInjection() {

			@Override
			public void test() {

				Projection projection = Projection.get("EPSG:4326");
				String undefinedHtml = "no coordinates";

				MousePositionOptions mousePositionOptions = OLFactory
						.createOptions();
				mousePositionOptions.setCoordinateFormat(Coordinate
						.createStringXY(5));
				mousePositionOptions.setProjection(projection);
				mousePositionOptions.setUndefinedHTML(undefinedHtml);

				MousePosition mousePosition = new MousePosition(mousePositionOptions);

				assertNotNull(mousePosition);
				assertTrue(mousePosition instanceof Object);
				assertTrue(mousePosition instanceof Control);

				assertNotNull(mousePosition.getProjection());
				assertEquals(projection, mousePosition.getProjection());
			}
		});

	}

}
