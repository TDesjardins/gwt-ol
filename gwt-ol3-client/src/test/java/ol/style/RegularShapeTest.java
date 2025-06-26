/*******************************************************************************
 * Copyright 2014, 2025 gwt-ol
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

import ol.GwtOLBaseTestCase;
import ol.style.RegularShape;
import ol.style.RegularShapeOptions;

/**
 *
 * @author mribeiro
 */
public class RegularShapeTest extends GwtOLBaseTestCase {

    public void testRegularShape() {

        injectUrlAndTest(() -> {
            RegularShapeOptions regularShapeOptions = new RegularShapeOptions();
            regularShapeOptions.setAngle(Math.PI / 4);
            regularShapeOptions.setRadius(4);
            regularShapeOptions.setRadius2(3);
            regularShapeOptions.setRotation(Math.PI / 3);
            regularShapeOptions.setRotateWithView(false);
            assertNotNull(regularShapeOptions);

            RegularShape regularShape = new RegularShape(regularShapeOptions);
            assertNotNull(regularShape);
            assertEquals(4d, regularShape.getRadius());
            assertEquals(3d, regularShape.getRadius2());

            regularShape.setOpacity(0.5);
            regularShape.setRotation(Math.PI);
            regularShape.setScale(1.2);

            assertEquals(0.5, regularShape.getOpacity());
            assertEquals(Math.PI, regularShape.getRotation());
            assertEquals(1.2, regularShape.getScale());
        });

    }
}
