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

import org.gwtproject.event.shared.HandlerRegistration;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.OLUtil;
import ol.event.EventListener;
import ol.tilegrid.TileGrid;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. Base class for sources providing images divided into a
 * tile grid.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Tile extends Source {

    /**
     * Return the tile grid of the tile source.
     *
     * @return tile grid.
     */
    public native TileGrid getTileGrid();

    /**
     * Triggered when a tile starts loading.
     */
    @JsOverlay
    public final HandlerRegistration addTileLoadStartListener(final EventListener<Tile.Event> listener) {
        return OLUtil.observe(this, "tileloadstart", listener);
    }

    /**
     * Triggered when a tile finishes loading.
     */
    @JsOverlay
    public final HandlerRegistration addTileLoadEndListener(final EventListener<Tile.Event> listener) {
        return OLUtil.observe(this, "tileloadend", listener);
    }

    /**
     * Triggered if tile loading results in an error.
     */
    @JsOverlay
    public final HandlerRegistration addTileLoadErrorListener(final EventListener<Tile.Event> listener) {
        return OLUtil.observe(this, "tileloaderror", listener);
    }

    /**
     * Events emitted by {@link ol.source.Tile} instances are instances of this
     * type.
     *
     * @author sbaumhekel
     *
     */
    @JsType(isNative = true)
    public interface Event extends ol.events.Event {

        /**
         * The tile related to the event.
         */
        @JsProperty
        ol.Tile getTile();

    }

}
