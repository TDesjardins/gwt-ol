package ol.layer;

import com.google.gwt.core.client.js.JsType;

/**
 * A {@link ol.Collection} of layers that are handled together.
 *
 * A generic `change` event is triggered when the group/Collection changes.
 * 
 * @author sbaumhekel
 */
@JsType(prototype = "ol.layer.Group")
public interface Group extends Base {

    /**
     * Returns the {@link ol.Collection collection} of {@link ol.layer.Layer
     * layers} in this group.
     * @return {!ol.Collection.<ol.layer.Base>} Collection of
     *         {@link ol.layer.Base layers} that are part of this group.
     */
    ol.Collection<ol.layer.Base> getLayers();

    /**
     * Set the {@link ol.Collection collection} of {@link ol.layer.Layer layers}
     * in this group.
     * @param layers
     *            Collection of {@link ol.layer.Base layers} that are part of
     *            this group.
     */
    void setLayers(ol.Collection<ol.layer.Base> layers);

}
