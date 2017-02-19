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
package ol;

import ol.View;
import ol.ViewOptions;
import ol.proj.Projection;
import ol.OLFactory;
import ol.proj.ProjectionOptions;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ViewTest extends GwtOL3BaseTestCase {

    public void testView() {
        
        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                ProjectionOptions projectionOptions = new ProjectionOptions();
                projectionOptions.setCode("EPSG:21781");
                projectionOptions.setUnits("m");
                
                assertNotNull(projectionOptions);
                
                Projection projection = new Projection(projectionOptions);
                
                assertNotNull(projection);
                
                ViewOptions viewOptions = new ViewOptions();
                viewOptions.setProjection(projection);
                View view = new View(viewOptions);

                Coordinate centerCoordinate = OLFactory.createCoordinate(660000, 190000);
                
                view.setCenter(centerCoordinate);
                view.setZoom(9);
                
                assertNotNull(view);
                assertTrue(view instanceof Object);
                
            }
            
        });
        
    }

}
