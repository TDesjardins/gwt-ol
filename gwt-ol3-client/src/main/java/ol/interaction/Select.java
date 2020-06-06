/*******************************************************************************
 * Copyright 2014, 2020 gwt-ol
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

import javax.annotation.Nullable;

import com.google.gwt.event.shared.HandlerRegistration;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.MapBrowserEvent;
import ol.OLUtil;
import ol.event.EventListener;

/**
 * Interaction for selecting vector features. By default, selected features are
 * styled differently, so this interaction can be used for visual highlighting,
 * as well as selecting features for other actions, such as modification or output.
 * There are three ways of controlling which features are selected:
 * using the browser event as defined by the condition and optionally the toggle, add/remove, and multi options;
 * a layers filter;
 * and a further feature filter using the filter option.
 *
 * Selected features are added to an internal unmanaged layer.
 *
 * @author Tino Desjardins
 *          19-05-2016.
 */
@JsType(isNative = true)
public class Select extends Interaction {

    public Select() {}

    public Select(SelectOptions selectOptions) {}

    @JsProperty
    public native void setOptions(SelectOptions options);

    public native Collection<Feature> getFeatures();

    /**
     * @return hit-detection tolerance
     */
    public native int getHitTolerance();

    /**
     * Hit-detection tolerance. Pixels inside the radius around the given position
     * will be checked for features. This only works for the canvas renderer and
     * not for WebGL. Default is 0.
     *
     * @param hitTolerance hit-detection tolerance
     */
    public native void setHitTolerance(int hitTolerance);

    /**
     * Triggered when selection changes.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addSelectChangedListener(final EventListener<Select.Event> listener) {
        return OLUtil.observe(this, "select", listener);
    }

    /**
     * Events emitted by {@link Select} instances are instances of this type.
     *
     * @author Tino Desjardins
     *
     */
    @JsType(isNative = true)
    public interface Event extends ol.events.Event {

        @Nullable
        @JsProperty
        public Feature[] getSelected();

        @Nullable
        @JsProperty
        public Feature[] getDeselected();

        @JsProperty
        public MapBrowserEvent getMapBrowserEvent();
    }

}
