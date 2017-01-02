package ol;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.geom.Geometry;

/**
 * {@link Feature} options.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FeatureOptions implements Options {

    /**
     * The default geometry for the feature.
     *
     * @param geom {@link Geometry}
     */
    @JsProperty
    public native void setGeometry(Geometry geom);
    
    /**
     * Id.
     * 
     * @param id
     */
    @JsProperty
    public native void setId(String id);
    
}
