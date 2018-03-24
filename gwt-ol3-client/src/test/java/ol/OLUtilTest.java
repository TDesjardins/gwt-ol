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
package ol;

import ol.style.Style;

/**
 * Test for {@link ol.OLUtil}.
 *
 * @author Tino Desjardins
 *
 */
public class OLUtilTest extends GwtOLBaseTestCase {

    public void testOLUtil() {

        injectUrlAndTest(() -> {

            Style[] styles = {new Style(), new Style()};
            Style newStyle = new Style();

            assertTrue(styles.length == 2 );

            OLUtil.pushItem(styles, newStyle);

            assertTrue(styles.length == 3);

            Style[] styles1 = {new Style(), new Style()};
            Style[] styles2 = {new Style(), new Style(), new Style()};
            assertTrue(styles1.length == 2);
            assertTrue(styles2.length == 3);
            
            Style[] combinedStyles = OLUtil.concatArrays(styles1, styles2);

            assertNotNull(combinedStyles);
            assertTrue(combinedStyles.length == 5);

        });

    }

}
