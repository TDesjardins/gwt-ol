package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * params for MapGuide-requests.
 * @author tlochmann
 */

@JsType(isNative = true)
public interface ImageMapGuideParams {

	/**
     * @param mapDefinition
     * 			MapGuide mapDefinition e.g. "Library://Samples/Sheboygan/Maps/Sheboygan.MapDefinition"
     */
    @JsProperty
    void setMapDefinition(String mapDefinition);

    /**
     * @param format
     * 	MapGuide image format
     *
     */
    @JsProperty
    void setFormat(String format);

}
