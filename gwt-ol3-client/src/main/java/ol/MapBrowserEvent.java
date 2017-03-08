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
package ol;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.events.Event;

/**
 * Events emitted as map browser events are instances of this type. See
 * {@link ol.Map} for which events trigger a map browser event.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface MapBrowserEvent extends MapEvent {

    /**
     * The coordinate of the original browser event.
     *
     * @return {ol.Coordinate}
     */
    @JsProperty
    Coordinate getCoordinate();

    /**
     * Indicates if the map is currently being dragged. Only set for
     * `POINTERDRAG` and `POINTERMOVE` events. Default is `false`.
     *
     * @return boolean
     */
    @JsProperty
    boolean getDragging();

    /**
     * The pixel of the original browser event.
     *
     * @return {ol.Pixel}
     */
    @JsProperty
    Pixel getPixel();
    
    /**
     * The original browser event.
     *
     * @return {ol.event.Event}
     */
    @JsProperty
    Event getOriginalEvent();
}
