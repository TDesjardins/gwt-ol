package ol.layer;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

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
     * Opacity (0, 1). Default is 1.
     * 
     * @param opacity
     *            opacity
     * @return this instance
     */
    @JsProperty
    LayerOptions setOpacity(float opacity);

    @JsProperty
    LayerOptions setSaturation(float saturation);

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

}
