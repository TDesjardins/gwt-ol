/*******************************************************************************
 * Copyright 2014, 2015 gwt-ol3
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
package ol.event;

import ol.MapBrowserEvent;

/**
 * A listener for clicks.
 * 
 * @author sbaumhekel
 */
public interface ClickListener {

    /**
     * Fired on a click.
     * 
     * @param evt
     *            {@link MapBrowserEvent}
     */
    void onClick(MapBrowserEvent evt);

}
