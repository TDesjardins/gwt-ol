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
package ol;

import ol.control.Control;
import ol.event.EventListener;
import ol.events.Event;

/**
 * Test for {@link ol.Observable}.
 *
 * @author Tino Desjardins
 *
 */
public class ObservableTest extends GwtOLBaseTestCase {

    private static final String CUSTOM_EVENT_NAME = "custom";
    private boolean customEventFired = false;
    
    public void testObservable() {

        this.injectUrlAndTest(() -> {

            // test change event
            Collection<Control> controls = new Collection<Control>();

            int initialRevision = controls.getRevision();
            assertEquals(0, initialRevision);

            controls.changed();
            assertEquals(1, controls.getRevision());

            // test once
            controls.once(CUSTOM_EVENT_NAME, new EventListener<Event>() {
                @Override
                public void onEvent(Event event) {
                    customEventFired = true;
                }
            });

            assertFalse(this.customEventFired);
            controls.dispatchEvent(CUSTOM_EVENT_NAME);
            assertTrue(this.customEventFired);
            
            this.customEventFired = false;
            controls.dispatchEvent(CUSTOM_EVENT_NAME);
            assertFalse(this.customEventFired);

            // test on
            EventsKey onEventKey = controls.on(CUSTOM_EVENT_NAME, new EventListener<Event>() {
                @Override
                public void onEvent(Event event) {
                    customEventFired = true;
                }
            });

            assertFalse(this.customEventFired);
            controls.dispatchEvent(CUSTOM_EVENT_NAME);
            assertTrue(this.customEventFired);

            this.customEventFired = false;
            controls.dispatchEvent(CUSTOM_EVENT_NAME);
            assertTrue(this.customEventFired);

            this.customEventFired = false;
            Collection.unByKey(onEventKey);
            controls.dispatchEvent(CUSTOM_EVENT_NAME);
            assertFalse(this.customEventFired);

        });

    }

}
