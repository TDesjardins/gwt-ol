package ol;

/**
 *
 * @author Tino Desjardins
 *
 */
public class AttributionTest extends BaseTestCase {

    public void testAttribution() {

	AttributionOptions attributionOptions = OLFactory.createOptions();

	assertNotNull(attributionOptions);

	Attribution attribution = OLFactory.createAttribution(attributionOptions);

	assertNotNull(attribution);

    }

}
