package ol;

import ol.control.Attribution;
import ol.control.Control;

/**
 *
 * @author Tino Desjardins
 *
 */
public class CollectionTest extends GwtOL3BaseTestCase {

    public void testCollection() {

        this.injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                Collection<Control> controls = new Collection<Control>();

                assertNotNull(controls);
                assertTrue(controls.getLength() == 0);
                assertTrue(controls.isEmpty());

                assertNotNull(controls.getArray());

                // Does not work before ol v3.20. because bug in ol3.
                int length = controls.push(new Attribution());
                assertTrue(length == 1);

                assertTrue(controls.getLength() == 1);
                assertFalse(controls.isEmpty());
                //assertTrue(controls.getArray().length == 1);

                Control control = controls.pop();
                assertTrue(control instanceof Attribution);

                assertTrue(controls.getLength() == 0);
                assertTrue(controls.isEmpty());

            }
        });

    }

}
