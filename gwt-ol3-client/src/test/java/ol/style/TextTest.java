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

/**
 * Test for {@link ol.style.Text}.
 * 
 * @author Tino Desjardins
 */
public class TextTest extends GwtOL3BaseTestCase {

    private static final String FONT = "12px sans-serif";

    public void testText() {

        injectUrlAndTest(() -> {

            Text text = new Text();
            assertNotNull(text);

            TextOptions textOptions = new TextOptions();
            textOptions.setFont(FONT);
            textOptions.setRotation(0);

            Text text2 = new Text(textOptions);
            assertNotNull(text2);
            assertEquals(FONT, text2.getFont());

        });

    }
}
