/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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
import ol.Feature;
import ol.GwtOL3BaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ModifyTest extends GwtOL3BaseTestCase {

    public void testModify() {

        ModifyOptions modifyOptions = new ModifyOptions();
        Collection<Feature> features = new Collection<Feature>();

        modifyOptions.setFeatures(features);
        Modify modify = new Modify(modifyOptions);
        
        assertNotNull(modify);
        assertTrue(modify instanceof Observable);
        assertTrue(modify instanceof Interaction);
        
    }

}
