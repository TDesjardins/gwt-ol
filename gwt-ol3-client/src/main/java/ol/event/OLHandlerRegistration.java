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
package ol.event;

import com.google.gwt.event.shared.HandlerRegistration;

import ol.EventsKey;
import ol.Observable;

/**
 * A {@link HandlerRegistration} for OpenLayers event handlers.
 * 
 * @author sbaumhekel
 */
public class OLHandlerRegistration implements HandlerRegistration {

    private EventsKey key;
    private Observable o;

    /**
     * Constructs an instance.
     * 
     * @param o
     *            {@link Observable}
     * @param key
     *            key
     */
    public OLHandlerRegistration(Observable o, EventsKey key) {
        this.o = o;
        this.key = key;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.google.web.bindery.event.shared.HandlerRegistration#removeHandler()
     */
    @Override
    public void removeHandler() {
        // unregister handler and remove all references
        if(o != null) {
            Observable.unByKey(key);
            o = null;
            key = null;
        }
    }

}
