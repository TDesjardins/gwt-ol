/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.geom.LineString;

/**
 *
 * @author Tino Desjardins
 *
 */
public class GeoJSONTest extends GwtOL3BaseTestCase {

	private GeoJSON geoJSONFormat;
	
	
	
	@Override
	protected void gwtSetUp() throws Exception {
	    injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                geoJSONFormat = new GeoJSON();
            }
	        
	    });
	}
	
	public void testFeatureToGeoJSON() {

	    injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                assertNotNull(geoJSONFormat);

                JavaScriptObject geoJSON = geoJSONFormat.writeFeatureObject(createTestFeature(), null);
                assertNotNull(geoJSON);
                
            }
            
        });

	}

    public void testGeoJSONToFeature() {
        
        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                JavaScriptObject geoJSON = geoJSONFormat.writeFeatureObject(createTestFeature(), null);

                // Convert Features from GeoJSON
                Feature featureGeoJSON = geoJSONFormat.readFeature(geoJSON, null);
                assertNotNull(featureGeoJSON);
            }

        });

    }
	
    public void testWriteGeoJSON() {
        
        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                String geoJSON = geoJSONFormat.writeFeatures(createTestFeature(), null);
                assertNotNull(geoJSON);

                JavaScriptObject javaScriptObject = JsonUtils.safeEval(geoJSON);
                assertNotNull(javaScriptObject);
            }
        });

    }
	
    public void testReadFeatureFromGeoJSON() {
        
        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                String geoJSON = geoJSONFormat.writeFeature(createTestFeature(), null);
                assertNotNull(geoJSON);
                Feature feature = geoJSONFormat.readFeature(geoJSON, null);

                assertNotNull(feature);
                //assertTrue(features.length > 0);
            }
        });

    }
    
    public void testReadFeatureCollectionFromGeoJSON() {
        
        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                String geoJSON = geoJSONFormat.writeFeatures(createTestFeature(), null);
                assertNotNull(geoJSON);
                //JavaScriptObject javaScriptObject = JsonUtils.safeEval(geoJSON);
                Feature[] features = geoJSONFormat.readFeatures(geoJSON, null);

                assertNotNull(features);
                //assertTrue(features.length > 0);
            }
        });

    }
	
	private Feature createTestFeature() {
		
		Coordinate coordinate1 = OLFactory.createCoordinate(1, 1);
		Coordinate coordinate2 = OLFactory.createCoordinate(5, 5);
		Coordinate[] coordinates = { coordinate1, coordinate2 };
		LineString lineString = new LineString(coordinates);

		// Create feature
		FeatureOptions featureOptions = OLFactory.createOptions();
		featureOptions.setGeometry(lineString);
		return new Feature(featureOptions);
		
	}

}
