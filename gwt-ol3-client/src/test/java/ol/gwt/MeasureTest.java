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
package ol.gwt;

import ol.GwtOLBaseTestCase;
import ol.event.MeasureEvent;
import ol.event.MeasureListener;
import ol.gwt.Measure.MeasureType;

/**
 * Test class for Measure interaction
 * 
 * @author Copilot
 */
public class MeasureTest extends GwtOLBaseTestCase {

    public void testMeasureConstructorDoesNotThrowError() {

        this.injectUrlAndTest(() -> {

            // Test creating a Measure instance - this was previously failing with
            // "Class constructor Wo cannot be invoked without 'new'" error
            MeasureListener listener = new MeasureListener() {
                @Override
                public void onMeasure(MeasureEvent event) {
                    // Test listener implementation
                }
            };
            
            // This should not throw any errors with the fix
            Measure measure1 = new Measure(MeasureType.DISTANCE, listener);
            assertNotNull(measure1);
            
            // Test the overloaded constructor too
            Measure measure2 = new Measure(MeasureType.AREA, listener, true, false);
            assertNotNull(measure2);

        });

    }

}