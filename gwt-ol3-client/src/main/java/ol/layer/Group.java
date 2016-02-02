package ol.layer;

import jsinterop.annotations.JsType;
import ol.Collection;

/**
 * A {@link ol.Collection} of layers that are handled together.
 *
 * A generic `change` event is triggered when the group/Collection changes.
 *
 * @author sbaumhekel
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public class Group extends Base {

    public Group() {}

    public Group(LayerGroupOptions layerGroupOptions) {}

    /**
     * Returns the {@link ol.Collection collection} of {@link ol.layer.Layer
     * layers} in this group.
     * @return {!ol.Collection.<ol.layer.Base>} Collection of
     *         {@link ol.layer.Base layers} that are part of this group.
     */
    public native Collection<Base> getLayers();

    /**
     * Set the {@link ol.Collection collection} of {@link ol.layer.Layer layers}
     * in this group.
     * @param layers
     *            Collection of {@link ol.layer.Base layers} that are part of
     *            this group.
     */
    public native void setLayers(Collection<Base> layers);

}
