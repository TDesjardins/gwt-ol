package ol.format;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 * Options for the GeoJSON
 *
 * @author tlochmann
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeoJSONOptions implements Options {

    /**
     * @param projection
     */
    public native void setDefaultDataProjection(Projection projection);

    /**
     * @param geometryName
     */
    public native void setGeometryName(String geometryName);

}
