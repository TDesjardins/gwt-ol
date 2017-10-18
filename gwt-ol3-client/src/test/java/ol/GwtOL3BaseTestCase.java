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

/**
 *
 * @author Tino Desjardins
 *
 */
public abstract class GwtOL3BaseTestCase extends BaseTestCase {

    public GwtOL3BaseTestCase() {
        super("http://openlayers.org/en/v4.4.2/build/ol.js", "ol.GwtOL3Test", 10000);
    }

}
