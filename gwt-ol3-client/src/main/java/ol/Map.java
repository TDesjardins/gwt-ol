package ol;

import com.google.gwt.dom.client.Element;
import com.google.web.bindery.event.shared.HandlerRegistration;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.control.Control;
import ol.event.DoubleClickListener;
import ol.event.Event;
import ol.event.EventListener;
import ol.gwt.TypedObject;
import ol.interaction.Interaction;
import ol.layer.Base;
import ol.layer.Group;

/**
 * The map is the core component of OpenLayers. For a map to render, a view, one
 * or more layers, and a target container are needed:
 *
 * var map = new ol.Map({ view: new ol.View({ center: [0, 0], zoom: 1 }),
 * layers: [ new ol.layer.Tile({ source: new ol.source.MapQuest({layer: 'osm'})
 * }) ], target: 'map' });
 *
 * The above snippet creates a map using a {@link ol.layer.Tile} to display
 * OSM data and render it to a DOM element with the id `map`.
 *
 * The constructor places a viewport container (with CSS class name
 * `ol-viewport`) in the target element (see `getViewport()`), and then two
 * further elements within the viewport: one with CSS class name
 * `ol-overlaycontainer-stopevent` for controls and some overlays, and one with
 * CSS class name `ol-overlaycontainer` for other overlays (see the `stopEvent`
 * option of {@link ol.Overlay} for the difference). The map itself is placed in
 * a further element within the viewport, either DOM or Canvas, depending on the
 * renderer.
 *
 * Layers are stored as a `ol.Collection` in layerGroups. A top-level group is
 * provided by the library. This is what is accessed by `getLayerGroup` and
 * `setLayerGroup`. Layers entered in the options are added to this group, and
 * `addLayer` and `removeLayer` change the layer collection in the group.
 * `getLayers` is a convenience function for `getLayerGroup().getLayers()`. Note
 * that `ol.layer.Group` is a subclass of `ol.layer.Base`, so layers entered in
 * the options or added with `addLayer` can be groups, which can contain further
 * groups, and so on.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public class Map extends Object {

    public Map(MapOptions mapOptions) {}

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
     * @return {ol.Collection.<ol.control.Control>} Controls.
     */
    public native Collection<Control> getControls();

    /**
     * Get the coordinate for a given pixel. This returns a coordinate in the
     * map view projection.
     *
     * @param pixel
     *            Pixel position in the map viewport.
     * @return {ol.Coordinate} The coordinate for the pixel position.
     */
    public native Coordinate getCoordinateFromPixel(Pixel pixel);

    /**
     * Returns the geographical coordinate for a browser event.
     *
     * @param event
     *            Event.
     * @return {ol.Coordinate} Coordinate.
     */
    public native Coordinate getEventCoordinate(Event event);

    /**
     * Returns the map pixel position for a browser event relative to the
     * viewport.
     *
     * @param event
     *            Event.
     * @return {ol.Pixel} Pixel.
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
     * @return {!ol.Collection.<ol.layer.Base>} Layers.
     */
    public native Collection<Base> getLayers();

    /**
     * Get an overlay by its identifier (the value returned by overlay.getId()).
     * Note that the index treats string and numeric identifiers as the same. So
     * `map.getOverlayById(2)` will return an overlay with id `'2'` or `2`.
     * @param id
     *            Overlay identifier.
     * @return {ol.Overlay} Overlay.
     */
    public native Overlay getOverlayById(String id);

    /**
     * Get the map overlays. Modifying this collection changes the overlays
     * associated with the map.
     * @return {ol.Collection.<ol.Overlay>} Overlays.
     */
    public native Collection<Overlay> getOverlays();

    /**
     * Get the pixel for a coordinate. This takes a coordinate in the map view
     * projection and returns the corresponding pixel.
     *
     * @param coordinate
     *            A map coordinate.
     * @return {ol.Pixel} A pixel position in the map viewport.
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
     * @return {ol.Size|undefined} The size in pixels of the map in the DOM.
     */
    public native Size getSize();

    /**
     * Get the target in which this map is rendered. Note that this returns what
     * is entered as an option or in setTarget: if that was an element, it
     * returns an element; if a string, it returns that.
     *
     * @return {Element|string|undefined} The Element or id of the Element that
     *         the map is rendered in.
     */
    public native String getTarget();

    /**
     * Get the DOM element into which this map is rendered. In contrast to
     * `getTarget` this method always return an `Element`, or `null` if the map
     * has no target.
     *
     * @return {Element} The element that the map is rendered in.
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
     * @return {Element} Viewport.
     */
    public native Element getViewport();

	/**
	 * Detect features that intersect a pixel on the viewport, and execute a
	 * callback with each intersecting feature. Layers included in the detection
	 * can be configured through opt_layerFilter.
	 *
	 * @param pixel
	 * @param callback
	 */
	public native Feature forEachFeatureAtPixel(Pixel pixel, GenericFunction<Feature, ?> callback);

    /**
     * Remove the given control from the map.
     *
     * @param control
     *            Control.
     * @return {ol.control.Control|undefined} The removed control (or undefined
     *         if the control was not found).
     */
    public native Control removeControl(Control control);

    /**
     * Remove the given interaction from the map.
     *
     * @param interaction
     *            Interaction to remove.
     * @return {ol.interaction.Interaction|undefined} The removed interaction
     *         (or undefined if the interaction was not found).
     */
    public native Interaction removeInteraction(Interaction interaction);

    /**
     * Removes the given layer from the map.
     *
     * @param layer
     *            Layer.
     * @return {ol.layer.Base|undefined} The removed layer (or undefined if the
     *         layer was not found).
     */
    public native Base removeLayer(Base layer);

    /**
     * Remove the given overlay from the map.
     * @param overlay
     *            Overlay.
     * @return {ol.Overlay|undefined} The removed overlay (or undefined if the
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
     * The container for the map, either the element itself or the id of the
     * element. If not specified at construction time, ol.Map#setTarget must be
     * called for the map to be rendered.
     *
     * @param o
     *            id or element
     */
    public native void setTarget(TypedObject<Element, String> o);

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

    @JsOverlay
    public final HandlerRegistration addDoubleClickListener(final DoubleClickListener listener) {
        return OLUtil.observe(this, "dblclick", new EventListener<MapBrowserEvent>() {

            @Override
            public void onEvent(MapBrowserEvent event) {
                listener.onDoubleClick(event);
            }
        });
    }

}
