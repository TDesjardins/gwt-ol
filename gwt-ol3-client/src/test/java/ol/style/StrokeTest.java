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

import ol.GwtOLBaseTestCase;
import ol.color.Color;

/**
 * Test for {@link ol.style.Stroke}.
 * 
 * @author Tino Desjardins
 */
public class StrokeTest extends GwtOLBaseTestCase {

    public void testStroke() {

        injectUrlAndTest(() -> {

            Stroke stroke = new Stroke();
            assertNotNull(stroke);

            StrokeOptions strokeOptions = new StrokeOptions();
            strokeOptions.setColor(new Color(0, 0, 0, 1));

            Stroke stroke2 = new Stroke(strokeOptions);
            assertNotNull(stroke2);
            assertNotNull(stroke2.getColor());

        });

    }
}
