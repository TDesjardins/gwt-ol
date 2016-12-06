package ol.style;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.style.RegularShape;
import ol.style.RegularShapeOptions;

/**
 *
 * @author mribeiro
 * @date 22/11/16.
 */
public class RegularShapeTest extends GwtOL3BaseTestCase {

    public void testPoint() {

        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                RegularShapeOptions regularShapeOptions = OLFactory.createOptions();
                regularShapeOptions.setAngle(Math.PI / 4);
                regularShapeOptions.setRadius1(4);
                regularShapeOptions.setRadius2(4);
                regularShapeOptions.setRotation(Math.PI / 3);
                regularShapeOptions.setRotateWithView(false);
                assertNotNull(regularShapeOptions);
                RegularShape regularShape = OLFactory.createRegularShape(regularShapeOptions);
                assertNotNull(regularShape);
            }

        });

    }
}
