package ol.layer;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Map;
import ol.style.Style;

/**
 * Vector layer options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface VectorLayerOptions extends LayerOptions {
    /**
     *
     * Sets the layer as overlay on a map. The map will not manage this layer in
     * its layers collection, and the layer will be rendered on top. This is
     * useful for temporary layers. The standard way to add a layer to a map and
     * have it managed by the map is to use {@link ol.Map#addLayer(Base)}.
     *
     * @param map
     *            {@link Map}
     * @return this instance
     */
    @JsProperty
    VectorLayerOptions setMap(Map map);

    /**
     * The buffer around the viewport extent used by the renderer when getting
     * features from the vector source for the rendering or hit-detection.
     * Recommended value: the size of the largest symbol, line width or label.
     * Default is 100 pixels.
     *
     * @param renderBuffer
     *            render buffer
     * @return this instance
     */
    @JsProperty
    VectorLayerOptions setRenderBuffer(double renderBuffer);

    /**
     * Layer style. See ol.style for default style which will be used if this is
     * not defined.
     *
     * @param style
     *            {@link Style}
     * @return this instance
     */
    @JsProperty
    VectorLayerOptions setStyle(Style style);

    /**
     * Layer style. See ol.style for default style which will be used if this is
     * not defined.
     *
     * @param style
     *            {@link Style}
     * @return this instance
     */
    @JsProperty
    VectorLayerOptions setStyle(Style[] style);

    /**
     * When set to true, feature batches will be recreated during animations.
     * This means that no vectors will be shown clipped, but the setting will
     * have a performance impact for large amounts of vector data. When set to
     * false, batches will be recreated when no animation is active. Default is
     * false.
     *
     * @param updateWhileAnimating
     *            update while animating?
     * @return this instance
     */
    @JsProperty
    VectorLayerOptions setUpdateWhileAnimating(boolean updateWhileAnimating);

    /**
     * When set to true, feature batches will be recreated during interactions.
     * See also updateWhileAnimating. Default is false.
     *
     * @param updateWhileInteracting
     *            update while interacting?
     * @return this instance
     */
    @JsProperty
    VectorLayerOptions setUpdateWhileInteracting(boolean updateWhileInteracting);

}
