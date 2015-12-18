package ol;

import com.google.gwt.core.client.js.*;

import ol.geom.Geometry;

/**
 * {@link Feature} options.
 *
 * @author sbaumhekel
 */
@JsType
public interface FeatureOptions extends Options {

    /**
     * The default geometry for the feature.
     *
     * @param geom
     *            {@link Geometry}
     * @return this instance
     */
    @JsProperty
    FeatureOptions setGeometry(Geometry geom);
}
