package ol.format;

import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 * Options for the GeoJSON
 *
 * @author tlochmann
 */
@JsType(isNative = true)
public interface GeoJSONOptions extends Options {

    /**
     * @param projection
     */
    void setDefaultDataProjection(Projection projection);

    /**
     * @param geometryName
     */
    void setGeometryName(String geometryName);

}
