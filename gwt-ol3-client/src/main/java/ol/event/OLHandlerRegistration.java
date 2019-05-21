/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
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

import org.gwtproject.event.shared.HandlerRegistration;

import ol.EventsKey;
import ol.Observable;

/**
 * A {@link HandlerRegistration} for OpenLayers event handlers.
 *
 * @author sbaumhekel
 */
public class OLHandlerRegistration implements HandlerRegistration {

    private EventsKey key;
    private Observable observable;

    /**
     * Constructs an instance.
     *
     * @param observable
     *            {@link Observable}
     * @param key
     *            key
     */
    public OLHandlerRegistration(Observable observable, EventsKey key) {
        this.observable = observable;
        this.key = key;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.google.web.bindery.event.shared.HandlerRegistration#removeHandler()
     */
    @Override
    public void removeHandler() {
        // unregister handler and remove all references
        if(observable != null) {
            Observable.unByKey(key);
            observable = null;
            key = null;
        }
    }

}
