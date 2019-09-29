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
package ol;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.control.Control;
import ol.interaction.Interaction;
import ol.layer.Base;

/**
 * Options for the map.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MapOptions implements Options {

    /**
     * @param controls Controls initially added to the map. If not specified, <code>ol.control.defaults()</code> is used.
     */
    @JsProperty
    public native void setControls(Collection<Control> controls);

    @JsProperty
    public native Collection<Control> getControls();

    /**
     * @param pixelRatio The ratio between physical pixels and device-independent pixels (dips) on the device.
     * If <code>undefined</code> then it gets set by using <code>window.devicePixelRatio</code>.
     */
    @JsProperty
    public native void setPixelRatio(double pixelRatio);

    @JsProperty
    public native double getPixelRatio();

    /**
     * Interactions that are initially added to the map. If not specified,
     * ol.interaction.defaults() is used.
     *
     * @param interactions
     */
    @JsProperty
    public native void setInteractions(Collection<Interaction> interactions);

    @JsProperty
    public native Collection<Interaction> getInteractions();

    /**
     * The element to listen to keyboard events on. This determines when the {@link ol.interaction.KeyboardPan} and {@link ol.interaction.KeyboardZoom} interactions trigger.
     * For example, if this option is set to <code>document</code> the keyboard interactions will always trigger.
     * If this option is not specified, the element the library listens to keyboard events on is the map target
     * (i.e. the user-provided div for the map). If this is not <code>document</code> the target element needs to be focused for key events to be emitted,
     * requiring that the target element has a <code>tabindex</code> attribute.
     *
     * @param target The id of the element to listen keyboard events on.
     */
    @JsProperty
    public native void setKeyboardEventTarget(String target);

    /**
     * The element to listen to keyboard events on. This determines when the {@link ol.interaction.KeyboardPan} and {@link ol.interaction.KeyboardZoom} interactions trigger.
     * For example, if this option is set to <code>document</code> the keyboard interactions will always trigger.
     * If this option is not specified, the element the library listens to keyboard events on is the map target
     * (i.e. the user-provided div for the map). If this is not <code>document</code> the target element needs to be focused for key events to be emitted,
     * requiring that the target element has a <code>tabindex</code> attribute.
     *
     * @param target The element to listen keyboard events on.
     */
    @JsProperty
    public native void setKeyboardEventTarget(Element target);

    /**
     * The element to listen to keyboard events on. This determines when the {@link ol.interaction.KeyboardPan} and {@link ol.interaction.KeyboardZoom} interactions trigger.
     * For example, if this option is set to <code>document</code> the keyboard interactions will always trigger.
     * If this option is not specified, the element the library listens to keyboard events on is the map target
     * (i.e. the user-provided div for the map). If this is not <code>document</code> the target element needs to be focused for key events to be emitted,
     * requiring that the target element has a <code>tabindex</code> attribute.
     *
     * @param target The document to listen keyboard events on.
     */
    @JsProperty
    public native void setKeyboardEventTarget(Document target);

    /**
     * Layers. If this is not defined, a map with no layers will be rendered. Note that layers are rendered in the order supplied,
     * so if you want, for example, a vector layer to appear on top of a tile layer, it must come after the tile layer.
     *
     * @param layers Layers.
     */
    @JsProperty
    public native void setLayers(Collection<Base> layers);

    @JsProperty
    public native Collection<Base> getLayers();

    /**
     * @param moveTolerance The minimum distance in pixels the cursor must move to be detected as a map move event instead of a click.
     * Increasing this value can make it easier to click on the map. Default is <code>1</code>.
     */
    @JsProperty
    public native void setMoveTolerance(int moveTolerance);

    @JsProperty
    public native int getMoveTolerance();

    /**
     * Overlays initially added to the map. By default, no overlays are added.
     */
    @JsProperty
    public native void setOverlays(Collection<Overlay> overlays);

    @JsProperty
    public native Collection<Overlay> getOverlays();

    /**
     * Defines container element for the map.
     * If not specified at construction time, {@link ol.PluggableMap#setTarget} must be called for the map to be rendered.
     *
     * @param target The id of the container element for the map.
     */
    @JsProperty
    public native void setTarget(String target);

    /**
     * Defines container element for the map.
     * If not specified at construction time, {@link ol.PluggableMap#setTarget} must be called for the map to be rendered.
     *
     * @param target The container element for the map.
     */
    @JsProperty
    public native void setTarget(Element target);

    @JsProperty
    public native View getView();

    /**
     * Set the map's view. No layer sources will be fetched unless this is
     * specified at construction time or through ol.Map#setView.
     *
     * @param view {@link View}
     */
    @JsProperty
    public native void setView(View view);

}
