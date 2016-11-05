package ol;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.geom.Geometry;

/**
 * {@link Feature} options.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface FeatureOptions extends Options {

    /**
     * The default geometry for the feature.
     *
     * @param geom {@link Geometry}
     */
    @JsProperty
    void setGeometry(Geometry geom);
    
    /**
     * Id.
     * 
     * @param id
     */
    @JsProperty
    void setId(String id);
    
}
