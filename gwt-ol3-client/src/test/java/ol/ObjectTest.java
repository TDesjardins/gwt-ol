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

import jsinterop.base.JsPropertyMap;

/**
 * Test for {@link ol.Object}.
 *
 * @author Tino Desjardins
 *
 */
public class ObjectTest extends GwtOLBaseTestCase {

    private static final String PARAM_CUSTOM_VALUE = "customValue";

    public void testObject() {

        this.injectUrlAndTest(() -> {

            Object object = new View();
            assertNotNull(object);

            object.set(PARAM_CUSTOM_VALUE, 1d);

            assertNotNull(object.get(PARAM_CUSTOM_VALUE));
            assertEquals(1d, object.get(PARAM_CUSTOM_VALUE));
            assertNotNull(object.getProperties().get(PARAM_CUSTOM_VALUE));


            object.unset(PARAM_CUSTOM_VALUE);

            assertNull(object.get(PARAM_CUSTOM_VALUE));
            assertNull(object.getProperties().get(PARAM_CUSTOM_VALUE));

            JsPropertyMap<java.lang.Object> properties = JsPropertyMap.of();
            properties.set(PARAM_CUSTOM_VALUE, "new value");

            object.setProperties(properties);
            assertEquals("new value", object.get(PARAM_CUSTOM_VALUE));
            assertEquals("new value", object.getProperties().get(PARAM_CUSTOM_VALUE));

            object.setProperties(properties, true);

        });

    }

}
