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
package ol.interaction;

import ol.Collection;
import ol.GwtOL3BaseTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class InteractionTest extends GwtOL3BaseTestCase {

    public void testInteraction() {

        this.injectUrlAndTest(() -> {

            Collection<Interaction> defaultInteractions = Interaction.defaults();
            assertNotNull(defaultInteractions);
            assertTrue(defaultInteractions.getLength() > 0);

            DefaultInteractionsOptions defaultInteractionsOptions = new DefaultInteractionsOptions();
            defaultInteractionsOptions.setAltShiftDragRotate(true);

            Collection<Interaction> defaultInteractions2 = Interaction.defaults(defaultInteractionsOptions);
            assertNotNull(defaultInteractions2);

        });

    }

}
