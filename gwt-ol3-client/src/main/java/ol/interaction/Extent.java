/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol3
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

import org.gwtproject.event.shared.HandlerRegistration;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.OLUtil;
import ol.event.EventListener;

/**
 * Allows the user to draw a vector box by clicking and dragging on the map,
 * normally combined with an {@link ol.events.condition.Condition} that limits it to when the shift or other key is held down.
 * This is used, for example, for zooming to a specific area of the map
 * (see {@link ol.interaction.DragZoom} and {@link ol.interaction.DragRotateAndZoom}).
 *
 * This interaction is only supported for mouse devices.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Extent extends Pointer {

    public Extent() {}

    public Extent(ExtentOptions extentOptions) {}

    /**
     * @return current drawn extent in the view projection
     */
    public native ol.Extent getExtent();

    /**
     * Manually sets the drawn extent, using the view projection.
     *
     * @param extent Extent to set.
     */
    public native void setExtent(ol.Extent extent);

    /**
     * Triggered when extent changes.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addExtentChangedListener(final EventListener<Extent.Event> listener) {
        return OLUtil.observe(this, "extentchanged", listener);
    }

    /**
     * Events emitted by {@link Extent} instances are instances of this type.
     *
     * @author gkresic
     *
     */
    @JsType(isNative = true)
    public interface Event extends ol.events.Event {

        /**
         * @return current extent
         */
        @JsProperty
        public ol.Extent getExtent();

    }

}
