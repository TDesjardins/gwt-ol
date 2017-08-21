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

        injectUrlAndTest(() -> {
            MousePosition mousePosition = new MousePosition();
            
            assertNotNull(mousePosition);
            assertTrue(mousePosition instanceof Object);
            assertTrue(mousePosition instanceof Control);
        });
  
    }
    
	public void testMousePositionWithOptions() {

		injectUrlAndTest(() -> {

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
        });

	}

}
