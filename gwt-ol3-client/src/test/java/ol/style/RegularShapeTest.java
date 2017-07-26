/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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
package ol.style;

import ol.GwtOL3BaseTestCase;
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
                RegularShapeOptions regularShapeOptions = new RegularShapeOptions();
                regularShapeOptions.setAngle(Math.PI / 4);
                regularShapeOptions.setRadius1(4);
                regularShapeOptions.setRadius2(3);
                regularShapeOptions.setRotation(Math.PI / 3);
                regularShapeOptions.setRotateWithView(false);
                assertNotNull(regularShapeOptions);
                
                RegularShape regularShape = new RegularShape(regularShapeOptions);
                assertNotNull(regularShape);
                assertEquals(regularShape.getRadius(), 4);
                assertEquals(regularShape.getRadius2(), 3);
            }

        });

    }
}
