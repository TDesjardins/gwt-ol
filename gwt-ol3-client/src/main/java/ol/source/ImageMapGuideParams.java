package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * params for MapGuide-requests.
 * @author tlochmann
 */

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageMapGuideParams {

	/**
     * @param mapDefinition
     * 			MapGuide mapDefinition e.g. "Library://Samples/Sheboygan/Maps/Sheboygan.MapDefinition"
     */
    @JsProperty
    public native void setMapDefinition(String mapDefinition);

    /**
     * @param format
     * 	MapGuide image format
     *
     */
    @JsProperty
    public native void setFormat(String format);

}
