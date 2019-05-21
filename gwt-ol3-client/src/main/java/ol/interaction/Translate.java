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
import ol.Collection;
import ol.Coordinate;
import ol.Feature;
import ol.OLUtil;
import ol.event.EventListener;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Translate extends Pointer {

    public Translate(TranslateOptions translateOptions) {}

    /** Triggered upon feature translation start. */
    @JsOverlay
    public final HandlerRegistration addTranslateStartListener(final EventListener<Translate.Event> listener) {
        return OLUtil.observe(this, "translatestart", listener);
    }

    /** Triggered upon feature translation. */
    @JsOverlay
    public final HandlerRegistration addTranslatingListener(final EventListener<Translate.Event> listener) {
        return OLUtil.observe(this, "translating", listener);
    }

    /** Triggered upon feature translation end. */
    @JsOverlay
    public final HandlerRegistration addTranslateEndListener(final EventListener<Translate.Event> listener) {
        return OLUtil.observe(this, "translateend", listener);
    }

    /**
     * Events emitted by {@link Translate} instances are instances of this type.
     *
     * @author gkresic
     */
    @JsType(isNative = true)
    public interface Event extends ol.events.Event {

        /** The coordinate of the drag event */
        @JsProperty
        public Coordinate getCoordinate();

        /** The features being translated. */
        @JsProperty
        public Collection<Feature> getFeatures();

    }

}
