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

import ol.Collection.Event;
import ol.control.Attribution;
import ol.control.Control;
import ol.event.EventListener;

/**
 *
 * @author Tino Desjardins
 *
 */
public class CollectionTest extends GwtOLBaseTestCase {

    private boolean elementAddedEventFired = false;
    private boolean elementRemovedEventFired = false;

    public void testCollection() {

        this.injectUrlAndTest(() -> {

            Collection<Control> controls = new Collection<Control>();

            assertNotNull(controls);
            assertTrue(controls.getLength() == 0);
            assertTrue(controls.isEmpty());

            assertNotNull(controls.getArray());

            // Does not work before ol v3.20. because bug in ol3.
            int length = controls.push(new Attribution());
            assertTrue(length == 1);

            assertTrue(controls.getLength() == 1);
            assertFalse(controls.isEmpty());
            assertNotNull(controls.getArray());
            assertTrue(controls.getArray().length == 1);

            Control control = controls.pop();
            assertTrue(control instanceof Attribution);

            assertTrue(controls.getLength() == 0);
            assertTrue(controls.isEmpty());

            Attribution attribution = new Attribution();
            controls.push(attribution);
            assertTrue(controls.contains(attribution));
            assertFalse(controls.contains(new Attribution()));

        });

    }

    public void testCollectionEvents() {

        this.injectUrlAndTest(() -> {

            Collection<Control> controls = new Collection<Control>();

            assertFalse(this.elementAddedEventFired);
            assertFalse(this.elementRemovedEventFired);

            controls.addElementAddedListener(new EventListener<Collection.Event<Control>>() {
                
                @Override
                public void onEvent(Event<Control> event) {
                    elementAddedEventFired = true;
                }
            });

            controls.addElementRemovedListener(new EventListener<Collection.Event<Control>>() {
                
                @Override
                public void onEvent(Event<Control> event) {
                    elementRemovedEventFired = true;
                }
            });

            controls.push(new Attribution());

            assertTrue(this.elementAddedEventFired);
            assertFalse(this.elementRemovedEventFired);

            controls.removeAt(0);

            assertTrue(this.elementAddedEventFired);
            assertTrue(this.elementRemovedEventFired);

        });

    }

}
