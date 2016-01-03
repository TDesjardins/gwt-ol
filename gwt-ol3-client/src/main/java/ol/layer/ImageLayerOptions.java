package ol.layer;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Map;

/**
 * Image layer options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface ImageLayerOptions extends LayerOptions {
    
    /**
     *
     * Sets the layer as overlay on a map. The map will not manage this layer in
     * its layers collection, and the layer will be rendered on top. This is
     * useful for temporary layers. The standard way to add a layer to a map and
     * have it managed by the map is to use {@link ol.Map#addLayer(Base)}.
     *
     * @param map {@link Map}
     */
    @JsProperty
    void setMap(Map map);
    
}
