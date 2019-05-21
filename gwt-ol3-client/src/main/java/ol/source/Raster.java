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
package ol.source;

import javax.annotation.Nullable;

import org.gwtproject.event.shared.HandlerRegistration;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import ol.Extent;
import ol.OLUtil;
import ol.event.EventListener;

/**
 * @author Daniel Eggert (daniel.eggert@gfz-potsdam.de)
 */
@JsType(isNative = true)
public class Raster extends Image {

    public Raster() {
    }

    public Raster(RasterOptions rasterOptions) {
    }

    /**
     * Triggered after operations are run.
     */
    @JsOverlay
    public final HandlerRegistration addAfterOperationsListener(final EventListener<Raster.Event> listener) {
        return OLUtil.observe(this, "afteroperations", listener);
    }

    /**
     * Triggered before operations are run.
     */
    @JsOverlay
    public final HandlerRegistration addBeforeOperationsListener(final EventListener<Raster.Event> listener) {
        return OLUtil.observe(this, "beforeoperations", listener);
    }

    /**
     * Events emitted by ol.source.Raster instances are instances of this type.
     */
    @JsType(isNative = true)
    public interface Event extends ol.events.Event {

        @Nullable
        @JsProperty
        public JsPropertyMap<?> getData();

        @JsProperty
        public Extent getExtent();

        @JsProperty
        public int getResolution();

    }

}
