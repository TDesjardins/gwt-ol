/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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
package ol.interaction;

import ol.GwtOLBaseTestCase;
import ol.Observable;

/**
 *
 * @author Tino Desjardins
 *
 */
public class SelectTest extends GwtOLBaseTestCase {

    public void testSelect() {

        injectUrlAndTest(() -> {

            SelectOptions selectOptions = new SelectOptions();
            selectOptions.setHitTolerance(2);
            selectOptions.setWrapX(true);
            Select select = new Select(selectOptions);

            assertNotNull(select);
            assertTrue(select instanceof Observable);
            assertTrue(select instanceof Interaction);
            assertEquals(2, select.getHitTolerance());

            select.setHitTolerance(0);
            assertEquals(0, select.getHitTolerance());

        });

    }

}
