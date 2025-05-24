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
package ol;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.control.Control;
import ol.event.EventListener;
import ol.interaction.Interaction;
import ol.layer.Base;
import ol.layer.Group;

/**
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public abstract class PluggableMap extends Object {

    /**
     * Add the given control to the map.
     *
     * @param control Control.
     */
    public native void addControl(Control control);

    /**
     * Add the given interaction to the map.
     *
     * @param interaction Interaction to add.
     */
    public native void addInteraction(Interaction interaction);

    /**
     * Adds the given layer to the top of this map. If you want to add a layer
     * elsewhere in the stack, use `getLayers()` and the methods available on
     * {@link ol.Collection}.
     *
     * @param layer Layer.
     */
    public native void addLayer(Base layer);

    /**
     * Add the given overlay to the map.
     * @param overlay
     *            Overlay.
     */
    public native void addOverlay(Overlay overlay);

    /**
     * Get the map controls. Modifying this collection changes the controls
     * associated with the map.
     *
     * @return controls.
     */
    public native Collection<Control> getControls();

    /**
     * Get the coordinate for a given pixel. This returns a coordinate in the
     * map view projection.
     *
     * @param pixel
     *            Pixel position in the map viewport.
     * @return The coordinate for the pixel position.
     */
    public native Coordinate getCoordinateFromPixel(Pixel pixel);

    /**
     * Returns the geographical coordinate for a browser event.
     *
     * @param event
     *            Event.
     * @return coordinate.
     */
    public native Coordinate getEventCoordinate(Event event);

    /**
     * Returns the map pixel position for a browser event relative to the
     * viewport.
     *
     * @param event
     *            Event.
     * @return map pixel position.
     */
    public native Pixel getEventPixel(Event event);

    /**
     * Get the map interactions. Modifying this collection changes the interactions associated with the map.
     * Interactions are used for e.g. pan, zoom and rotate.
     *
     * @return map interactions
     */
    public native Collection<Interaction> getInteractions();

    /**
     * Get the layergroup associated with this map.
     *
     * @return layergroup associated with this map
     */
    public native Group getLayerGroup();

    /**
     * Get the collection of layers associated with this map.
     *
     * @return layers.
     */
    public native Collection<Base> getLayers();

    /**
     * Get an overlay by its identifier (the value returned by overlay.getId()).
     * Note that the index treats string and numeric identifiers as the same. So
     * `map.getOverlayById(2)` will return an overlay with id `'2'` or `2`.
     * @param id
     *            Overlay identifier.
     * @return overlay.
     */
    public native Overlay getOverlayById(String id);

    /**
     * Get the map overlays. Modifying this collection changes the overlays
     * associated with the map.
     * @return overlays.
     */
    public native Collection<Overlay> getOverlays();

    /**
     * Get the pixel for a coordinate. This takes a coordinate in the map view
     * projection and returns the corresponding pixel.
     *
     * @param coordinate
     *            A map coordinate.
     * @return A pixel position in the map viewport.
     */
    public native Pixel getPixelFromCoordinate(Coordinate coordinate);

    /**
     * The ratio between physical pixels and device-independent pixels (dips) on
     * the device. If undefined then it gets set by using
     * window.devicePixelRatio.
     *
     * @return pixel ratio
     */
    @JsProperty
    public native double getPixelRatio();

    /**
     * Get the size of this map.
     *
     * @return The size in pixels of the map in the DOM.
     */
    public native Size getSize();

    /**
     * Get the target in which this map is rendered. Note that this returns what
     * is entered as an option or in setTarget: if that was an element, it
     * returns an element; if a string, it returns that.
     *
     * @return The Element or id of the Element that
     *         the map is rendered in.
     */
    public native String getTarget();

    /**
     * Get the DOM element into which this map is rendered. In contrast to
     * `getTarget` this method always return an `Element`, or `null` if the map
     * has no target.
     *
     * @return The element that the map is rendered in.
     */
    public native Element getTargetElement();

    /**
     * Get the view associated with this map. A view manages properties such as
     * center and resolution.
     *
     * @return The view that controls this map.
     */
    public native View getView();

    /**
     * Get the element that serves as the map viewport.
     *
     * @return Viewport.
     */
    public native Element getViewport();

    /**
     * Detect if features intersect a pixel on the viewport.
     *
     * @param pixel Pixel.
     * @return if features intersect a pixel
     */
    public native boolean hasFeatureAtPixel(Pixel pixel);

    /**
     * Detect if features intersect a pixel on the viewport. Layers included in the detection
     * can be configured through {@link FeatureAtPixelOptions#setLayerFilter(GenericFunction)}.
     *
     * @param pixel Pixel.
     * @param options Optional options.
     * @return if features intersect a pixel
     */
    public native boolean hasFeatureAtPixel(Pixel pixel, AtPixelOptions options);

    /**
     * Detect features that intersect a pixel on the viewport, and execute a
     * callback with each intersecting feature.
     *
     * @param pixel
     * @param callback
     */
    public native boolean forEachFeatureAtPixel(Pixel pixel, FeatureAtPixelFunction callback);

    /**
     * Detect features that intersect a pixel on the viewport, and execute a
     * callback with each intersecting feature. Layers included in the detection
     * can be configured through {@link AtPixelOptions#setLayerFilter(GenericFunction)}.
     *
     * @param pixel Pixel.
     * @param callback Feature callback. The callback will be called with two arguments. The first argument is one feature or render feature at the pixel, the second is the layer of the feature and will be null for unmanaged layers. To stop detection, callback functions can return a truthy value.
     * @param options options.
     */
    public native boolean forEachFeatureAtPixel(Pixel pixel, FeatureAtPixelFunction callback, AtPixelOptions options);

    /**
     * Detect layers that have a color value at a pixel on the viewport, and execute a
     * callback with each matching layer. Layers included in the detection can be configured
     * through {@link AtPixelOptions#setLayerFilter(GenericFunction)}.
     *
     * Note: this may give false positives unless the map layers have had different className properties assigned to them.
     *
     * @param pixel Pixel.
     * @param callback Layer callback. This callback will receive two arguments: first is the layer, second argument is an array representing [R, G, B, A] pixel values (0 - 255) and will be null for layer types that do not currently support this argument. To stop detection, callback functions can return a truthy value.
     */
    public native boolean forEachLayerAtPixel(Pixel pixel, LayerAtPixelFunction callback);

    /**
     * Detect layers that have a color value at a pixel on the viewport, and execute a
     * callback with each matching layer. Layers included in the detection can be configured
     * through {@link AtPixelOptions#setLayerFilter(GenericFunction)}.
     *
     * Note: this may give false positives unless the map layers have had different className properties assigned to them.
     *
     * @param pixel Pixel.
     * @param callback Layer callback. This callback will receive two arguments: first is the layer, second argument is an array representing [R, G, B, A] pixel values (0 - 255) and will be null for layer types that do not currently support this argument. To stop detection, callback functions can return a truthy value.
     * @param options options.
     */
    public native boolean forEachLayerAtPixel(Pixel pixel, LayerAtPixelFunction callback, AtPixelOptions options);

    /**
     * Remove the given control from the map.
     *
     * @param control
     *            Control.
     * @return The removed control (or undefined
     *         if the control was not found).
     */
    public native Control removeControl(Control control);

    /**
     * Remove the given interaction from the map.
     *
     * @param interaction
     *            Interaction to remove.
     * @return The removed interaction
     *         (or undefined if the interaction was not found).
     */
    public native Interaction removeInteraction(Interaction interaction);

    /**
     * Removes the given layer from the map.
     *
     * @param layer
     *            Layer.
     * @return The removed layer (or undefined if the
     *         layer was not found).
     */
    public native Base removeLayer(Base layer);

    /**
     * Remove the given overlay from the map.
     * @param overlay
     *            Overlay.
     * @return The removed overlay (or undefined if the
     *         overlay was not found).
     */
    public native Overlay removeOverlay(Overlay overlay);

    /**
     * Requests a render frame; rendering will effectively occur at the next
     * browser animation frame.
     */
    public native void render();

    /**
     * Requests an immediate render in a synchronous manner.
     */
    public native void renderSync();

    /**
     * Set the size of this map.
     *
     * @param size
     *            The size in pixels of the map in the DOM.
     */
    public native void setSize(Size size);

    /**
     * The id of the container for the map. If not specified at construction time,
     * ol.Map#setTarget must be called for the map to be rendered.
     *
     * @param targetId id
     */
    public native void setTarget(String targetId);

    /**
     * The container element for the map. If not specified at construction time,
     * ol.Map#setTarget must be called for the map to be rendered.
     *
     * @param targetElement target element
     */
    public native void setTarget(Element targetElement);

    /**
     * Set the view for this map.
     *
     * @param view
     *            The view that controls this map.
     */
    public native void setView(View view);

    /**
     * Force a recalculation of the map viewport size. This should be called
     * when third-party code changes the size of the map viewport.
     */
    public native void updateSize();

    /**
     * A click with no dragging. A double click will fire two of this.
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addClickListener(final EventListener<MapBrowserEvent> listener) {
        return OLUtil.observe(this, "click", listener);
    }

    /**
     * A true double click, with no dragging.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addDoubleClickListener(final EventListener<MapBrowserEvent> listener) {
        return OLUtil.observe(this, "dblclick", listener);
    }

    /**
     * Triggered after the map is moved.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addMoveEndListener(final EventListener<MapEvent> listener) {
        return OLUtil.observe(this, "moveend", listener);
    }

    /**
     * Triggered when the map starts moving.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addMoveStartListener(final EventListener<MapEvent> listener) {
        return OLUtil.observe(this, "movestart", listener);
    }

    /**
     * Triggered when a pointer is dragged.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addPointerDragListener(final EventListener<MapBrowserEvent> listener) {
        return OLUtil.observe(this, "pointerdrag", listener);
    }

    /**
     * Triggered when a pointer is moved.
     * Note that on touch devices this is triggered when the map is panned, so is not the same as <code>mousemove</code>.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addPointerMoveListener(final EventListener<MapBrowserEvent> listener) {
        return OLUtil.observe(this, "pointermove", listener);
    }

    /**
     * Triggered after a map frame is rendered.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addPostRenderListener(final EventListener<MapEvent> listener) {
        return OLUtil.observe(this, "postrender", listener);
    }

    /**
     * prerender
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addPreRenderListener(final EventListener<ol.render.Event> listener) {
        return OLUtil.observe(this, "prerender", listener);
    }

    /**
     * A true single click with no dragging and no double click.
     * Note that this event is delayed by 250 ms to ensure that it is not a double click.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addSingleClickListener(final EventListener<MapBrowserEvent> listener) {
        return OLUtil.observe(this, "singleclick", listener);
    }

    /**
     * Adds a map move listener for the given map.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addMapMoveListener(final EventListener<MapEvent> listener) {

        final HandlerRegistration handlerMap = OLUtil.observe(this, "moveend", listener);

        View view = getView();

        if (view == null)
            return handlerMap;

        // if we have a view, fire events while the map is moving
        // try to set up an event handler for the change of the view center
        // as "moveend" will be only fired when the map stops moving

        final HandlerRegistration handlerView = OLUtil.observe(view, "change:center", event -> {
            // create an artificial move event
            ol.events.Event e2 = OLUtil.createLinkedEvent(event, "move", PluggableMap.this);
            MapEvent mapEvent = OLUtil.initMapEvent(e2, PluggableMap.this);
            listener.onEvent(mapEvent);
        });

        // return a handler registration, which detaches both event handlers
        return () -> {
            handlerMap.removeHandler();
            handlerView.removeHandler();
        };

    }

    /**
     * Adds a map zoom listener for the given map.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addMapZoomListener(final EventListener<MapEvent> listener) {
        return OLUtil.observe(getView(), "change:resolution", event -> {
            ol.events.Event zoomEvent = OLUtil.createLinkedEvent(event, "zoom", PluggableMap.this);
            MapEvent mapEvent = OLUtil.initMapEvent(zoomEvent, PluggableMap.this);
            listener.onEvent(mapEvent);
        });
    }

    /**
     * Adds a map zoom end listener for the given map.
     *
     * @param listener listener
     * @return handler registration
     */
    @JsOverlay
    public final HandlerRegistration addMapZoomEndListener(final EventListener<MapEvent> listener) {
        return addMoveEndListener(new EventListener<MapEvent>() {
            private double zoomLevel = PluggableMap.this.getView().getZoom();
            @Override
            public void onEvent(MapEvent event) {
                double newZoomLevel = PluggableMap.this.getView().getZoom();
                if(newZoomLevel != this.zoomLevel) {
                    this.zoomLevel = newZoomLevel;
                    ol.events.Event zoomEndEvent = OLUtil.createLinkedEvent(event, "zoomend", PluggableMap.this);
                    MapEvent mapEvent = OLUtil.initMapEvent(zoomEndEvent, PluggableMap.this);
                    listener.onEvent(mapEvent);
                }
            }
        });
    }

}
