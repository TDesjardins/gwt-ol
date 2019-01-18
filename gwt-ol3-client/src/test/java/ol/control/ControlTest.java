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
package ol.control;

import ol.Collection;
import ol.GwtOLBaseTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ControlTest extends GwtOLBaseTestCase {

    public void testControl() {

        this.injectUrlAndTest(() -> {

            Collection<Control> defaultControls = Control.defaults();
            assertNotNull(defaultControls);
            assertTrue(defaultControls.getLength() > 0);

            DefaultControlsOptions defaultControlsOptions = new DefaultControlsOptions();
            defaultControlsOptions.setAttribution(false);
            defaultControlsOptions.setRotate(false);
            defaultControlsOptions.setZoom(false);

            Collection<Control> defaultControls2 = Control.defaults(defaultControlsOptions);
            assertNotNull(defaultControls2);
            assertEquals(0, defaultControls2.getLength());

        });

    }

}
