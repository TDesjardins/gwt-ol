package ol.layer;

import jsinterop.annotations.JsType;

import ol.Map;
import ol.source.Source;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. A visual representation of raster or vector map data.
 * Layers group together those properties that pertain to how the data is to be
 * displayed, irrespective of the source of that data.
 *
 * Layers are usually added to a map with {@link ol.Map#addLayer}. Components
 * like {@link ol.interaction.Select} use unmanaged layers internally. These
 * unmanaged layers are associated with the map using
 * {@link ol.layer.Layer#setMap} instead.
 *
 * A generic `change` event is fired when the state of the source changes.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Layer extends Base {

    /**
     * Gets the source for this layer.
     *
     * @return {@link Source}
     */
    public native <T extends Source> T getSource();

    /**
     * Sets the layer to be rendered on top of other layers on a map. The map
     * will not manage this layer in its layers collection, and the callback in
     * {@link ol.Map#forEachLayerAtPixel} will receive `null` as layer. This is
     * useful for temporary layers. To remove an unmanaged layer from the map,
     * use `#setMap(null)`.
     *
     * To add the layer to a map and have it managed by the map, use
     * {@link ol.Map#addLayer} instead.
     *
     * @param map
     *            Map.
     */
    public native void setMap(Map map);

    /**
     * Sets the source for this layer. If not provided to the constructor, the
     * source can be set by calling layer.setSource(source) after construction.
     *
     * @param source
     *            {@link Source}
     */
    public native void setSource(Source source);

}
