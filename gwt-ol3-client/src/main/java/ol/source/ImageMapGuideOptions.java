package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for source for images from Mapguide servers.
 *
 * @author tlochmann
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface ImageMapGuideOptions extends SourceOptions {

    /**
     *
     * @param imageMapGuideParams
     *            params for MapGuide-requests
     */
    @JsProperty
    void setParams(ImageMapGuideParams imageMapGuideParams);

    /**
     *
     * @param ratio
     * 				ratio. 1 means image requests are the size of the map viewport, 2 means twice the width and height of the map viewport, and so on. Must be 1 or higher. Default is 1
     */
    @JsProperty
    void setRatio(float ratio);

    /**
     *
     * @param url
     *            The mapagent url
     */
    @JsProperty
    void setUrl(String url);

    /**
     * @param useOverlay
     *  	If true, will use GETDYNAMICMAPOVERLAYIMAGE otherwise GETMAPIMAGE
     */
    @JsProperty
    void setUseOverlay(boolean useOverlay);

    /**
     * @param metersPerUnit
     * The meters-per-unit value. Default is 1. value returned from MapGuide
     */
    @JsProperty
    void setMetersPerUnit(double  metersPerUnit);

}
