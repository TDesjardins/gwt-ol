package ol.layer;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * Layer group options.
 *
 * @author sbaumhekel
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface LayerGroupOptions extends Options {

    /**
     * Set the {@link ol.Collection collection} of {@link ol.layer.Layer layers}
     * in this group.
     * @param layers
     *            Collection of {@link ol.layer.Base layers} that are part of
     *            this group.
     */
    @JsProperty
    void setLayers(ol.Collection<ol.layer.Base> layers);

}
