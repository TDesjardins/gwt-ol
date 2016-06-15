package ol.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;

import ol.BaseTestCase;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.OLFactory;
import ol.geom.LineString;

/**
 *
 * @author Tino Desjardins
 *
 */
public class GeoJSONTest extends BaseTestCase {

	private GeoJSON geoJSONFormat;
	
	@Override
	protected void gwtSetUp() throws Exception {
		this.geoJSONFormat = OLFactory.createGeoJSON();
	}
	
	public void testFeatureToGeoJSON() {

		assertNotNull(this.geoJSONFormat);

		JavaScriptObject geoJSON = this.geoJSONFormat.writeFeatureObject(this.createTestFeature(), null);
		assertNotNull(geoJSON);

	}

	public void testGeoJSONToFeature() {

		JavaScriptObject geoJSON = this.geoJSONFormat.writeFeatureObject(this.createTestFeature(), null);
		
		// Convert Features from GeoJSON
		Feature featureGeoJSON = this.geoJSONFormat.readFeature(geoJSON, null);
		assertNotNull(featureGeoJSON);

	}
	
	public void testWriteGeoJSON() {
		
		String geoJSON = this.geoJSONFormat.writeFeatures(createTestFeature(), null);
		assertNotNull(geoJSON);
		
		JavaScriptObject javaScriptObject = JsonUtils.safeEval(geoJSON);
		assertNotNull(javaScriptObject);
		
	}
	
	public void testReadGeoJSON() {
		
		String geoJSON = this.geoJSONFormat.writeFeatures(createTestFeature(), null);
		assertNotNull(geoJSON);

		Feature feature = this.geoJSONFormat.readFeature(geoJSON, null);
		
		assertNotNull(feature);
		//assertTrue(features.length > 0);
		
	}
	
	private Feature createTestFeature() {
		
		Coordinate coordinate1 = OLFactory.createCoordinate(1, 1);
		Coordinate coordinate2 = OLFactory.createCoordinate(5, 5);
		Coordinate[] coordinates = { coordinate1, coordinate2 };
		LineString lineString = OLFactory.createLineString(coordinates);

		// Create feature
		FeatureOptions featureOptions = OLFactory.createOptions();
		featureOptions.setGeometry(lineString);
		return OLFactory.createFeature(featureOptions);
		
	}

}
