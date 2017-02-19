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
package ol.gwt;

import jsinterop.annotations.JsType;

/**
 * A wrapper for an underlying OpenLayers object to allow extending its
 * functionality while still allowing it to be defined as a {@link JsType}
 * interface.
 * @author sbaumhekel
 * @param <T>
 *            type of the wrapped object
 */
public abstract class Wrapper<T> {

    protected final T impl;

    /**
     * Constructs an impl.
     * @param impl
     *            wrapped object
     */
    public Wrapper(T impl) {
        this.impl = impl;
    }

    /**
     * Gets the wrapped object.
     * @return wrapped object
     */
    public T getImpl() {
        return impl;
    }

}
