/*******************************************************************************
 * Copyright 2014, 2020 gwt-ol
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
import ol.OLFactory;

/**
 * Test for {@link ol.style.Icon}.
 *
 * @author Tino Desjardins
 */
public class IconTest extends GwtOLBaseTestCase {

    private static final String IMAGE_SRC_ICON = "https://openlayers.org/en/v3.20.1/examples/data/icon.png";

    public void testIcon() {

        injectUrlAndTest(() -> {

            IconOptions iconOptions = OLFactory.createOptions();
            iconOptions.setOpacity(1d);
            iconOptions.setSrc(IMAGE_SRC_ICON);

            Icon icon = new Icon(iconOptions);

            assertNotNull(icon);
            assertEquals(1d, icon.getOpacity());
            assertEquals(IMAGE_SRC_ICON, icon.getSrc());

            icon.load();

        });

    }
}
