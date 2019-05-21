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
import ol.Coordinate;
import ol.MapBrowserEvent;
import ol.OLUtil;
import ol.event.EventListener;
import ol.geom.Polygon;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class DragBox extends Pointer {

    public DragBox() {}

    public DragBox(DragBoxOptions dragBoxOptions) {}

    /**
     * Returns geometry of last drawn box.
     */
    public native Polygon getGeometry();

    /**
     * Triggered upon drag box start.
     */
    @JsOverlay
    public final HandlerRegistration addBoxStartListener(final EventListener<DragBox.Event> listener) {
        return OLUtil.observe(this, "boxstart", listener);
    }

    /**
     * Triggered on drag when box is active.
     */
    @JsOverlay
    public final HandlerRegistration addBoxDragListener(final EventListener<DragBox.Event> listener) {
        return OLUtil.observe(this, "boxdrag", listener);
    }

    /**
     * Triggered upon drag box end.
     */
    @JsOverlay
    public final HandlerRegistration addBoxEndListener(final EventListener<DragBox.Event> listener) {
        return OLUtil.observe(this, "boxend", listener);
    }

    /**
     * Events emitted by {@link DragBox} instances are instances of this type.
     *
     * @author gkresic
     *
     */
    @JsType(isNative = true)
    public interface Event extends ol.events.Event {

        /**
         * The coordinate of the drag event.
         */
        @JsProperty
        public Coordinate getCoordinate();

        @JsProperty
        public MapBrowserEvent getMapBrowserEvent();
    }

}

