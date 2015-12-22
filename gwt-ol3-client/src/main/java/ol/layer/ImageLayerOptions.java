package ol.layer;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Map;

/**
 * Image layer options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface ImageLayerOptions extends LayerOptions {
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
    ImageLayerOptions setMap(Map map);
}
