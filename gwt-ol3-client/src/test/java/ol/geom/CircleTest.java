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
package ol.geom;

import ol.Coordinate;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;

/**
 * A test case for {@link Circle}.
 *
 * @author Tino Desjardins
 */
public class CircleTest extends GwtOL3BaseTestCase {

    public void testCircle() {

    	injectUrlAndTest(new TestWithInjection() {

			@Override
			public void test() {
				
				double radius = 5;
		        
		        Circle circle = OLFactory.createCircle(OLFactory.createCoordinate(10, 10), radius);
		        assertNotNull(circle);
		        assertTrue(circle instanceof Geometry);

		        Coordinate coordinate = circle.getCenter();
		        assertNotNull(coordinate);
		        assert(10 == coordinate.getX());
		        assert(10 == coordinate.getY());
		        
		        assert(radius == circle.getRadius());

			}});  	
                
    }

}
