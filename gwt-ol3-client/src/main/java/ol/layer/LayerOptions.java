package ol.layer;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Extent;
import ol.Options;
import ol.source.Source;

/**
 * Layer options
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface LayerOptions extends Options {

    /**
     * The bounding extent for layer rendering. The layer will not be rendered
     * outside of this extent.
     * 
     * @param extent
     *            extent
     * @return this instance.
     */
    @JsProperty
    LayerOptions setExtent(Extent extent);

    /**
     * The maximum resolution (exclusive) below which this layer will be
     * visible.
     * 
     * @param maxResolution
     *            maximum resolution
     * @return this instance
     */
    @JsProperty
    LayerOptions setMaxResolution(double maxResolution);

    /**
     * The minimum resolution (inclusive) at which this layer will be visible.
     * 
     * @param minResolution
     *            minimum resolution
     * @return this instance
     */
    @JsProperty
    LayerOptions setMinResolution(double minResolution);

    /**
     * Opacity (0, 1). Default is 1.
     * 
     * @param opacity
     *            opacity
     * @return this instance
     */
    @JsProperty
    LayerOptions setOpacity(double opacity);

    /**
     * Source for this layer. Required.
     * 
     * @param source
     *            {@link Source}
     * @return this instance
     */
    @JsProperty
    LayerOptions setSource(Source source);

    /**
     * Visibility. Default is true (visible).
     * 
     * @param visible
     *            visible?
     * @return this instance
     */
    @JsProperty
    LayerOptions setVisible(boolean visible);

    /**
     * The z-index for layer rendering. At rendering time, the layers will be
     * ordered, first by Z-index and then by position. The default Z-index is 0.
     * 
     * @param zIndex
     *            z-index
     * @return this instance
     */
    @JsProperty
    LayerOptions setZIndex(int zIndex);
}
