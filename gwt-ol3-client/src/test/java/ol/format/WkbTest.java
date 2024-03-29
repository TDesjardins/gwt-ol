/*******************************************************************************
 * Copyright 2014, 2022 gwt-ol
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
package ol.format;

import ol.GwtOLBaseTestCase;

/**
 * Test for WKB format.
 * 
 * @author T. Desjardins
 *
 */
public class WkbTest extends GwtOLBaseTestCase {

    private Wkb wkbFormat;

    @Override
    protected void gwtSetUp() throws Exception {

        injectUrlAndTest(() -> {

            WkbOptions wkbOptions = new WkbOptions();
            assertNotNull(wkbOptions);

            wkbOptions.setSplitCollection(false);
            wkbFormat = new Wkb(wkbOptions);
            assertNotNull(wkbFormat);

            wkbOptions.setSplitCollection(true);

        });

    }

    public void testWkbFormat() {

        injectUrlAndTest(() -> {

            assertNotNull(this.wkbFormat);

        });

    }

}
