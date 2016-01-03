package ol.layer;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Extent;
import ol.Options;
import ol.source.Source;

/**
 * Layer options
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface LayerOptions extends Options {

    /**
     * The bounding extent for layer rendering. The layer will not be rendered
     * outside of this extent.
     * 
     * @param extent extent
     */
    @JsProperty
    void setExtent(Extent extent);

    /**
     * The maximum resolution (exclusive) below which this layer will be
     * visible.
     * 
     * @param maxResolution maximum resolution
     */
    @JsProperty
    void setMaxResolution(double maxResolution);

    /**
     * The minimum resolution (inclusive) at which this layer will be visible.
     * 
     * @param minResolution minimum resolution
     */
    @JsProperty
    void setMinResolution(double minResolution);

    /**
     * Opacity (0, 1). Default is 1.
     * 
     * @param opacity opacity
     */
    @JsProperty
    void setOpacity(double opacity);

    /**
     * Source for this layer. Required.
     * 
     * @param source {@link Source}
     */
    @JsProperty
    void setSource(Source source);

    /**
     * Visibility. Default is true (visible).
     * 
     * @param visible visible?
     */
    @JsProperty
    void setVisible(boolean visible);

    /**
     * The z-index for layer rendering. At rendering time, the layers will be
     * ordered, first by Z-index and then by position. The default Z-index is 0.
     * 
     * @param zIndex z-index
     */
    @JsProperty
    void setZIndex(int zIndex);
    
}
