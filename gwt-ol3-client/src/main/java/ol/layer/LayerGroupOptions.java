package ol.layer;

import com.google.gwt.core.client.js.*;

import ol.Options;

/**
 * Layer group options.
 * 
 * @author sbaumhekel
 *
 */
@JsType
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
