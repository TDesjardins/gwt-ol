package ol.format;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 * Options for the GeoJSON.
 *
 * @author tlochmann
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeoJSONFeatureOptions implements Options {

    /**
     * @param projection
     */
    public native void setDataProjection(Projection projection);

    /**
     * @param projection
     */
    public native void setFeatureProjection(Projection projection);

    /**
     * @param rightHanded
     */
    public native void setRightHanded(boolean rightHanded);

}
