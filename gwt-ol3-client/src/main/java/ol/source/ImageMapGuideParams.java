package ol.source;

import com.google.gwt.core.client.js.*;

/**
 * params for MapGuide-requests.
 * @author tlochmann
 */

@JsType
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