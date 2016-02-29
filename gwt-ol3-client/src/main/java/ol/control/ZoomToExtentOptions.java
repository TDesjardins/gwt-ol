package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * ZoomToExtent control options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface ZoomToExtentOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-zoom-extent".
     * @param className
     *            class name
     * @return this instance
     */
    @JsProperty
    ZoomToExtentOptions setClassName(String className);

    /**
     * The extent to zoom to. If undefined the validity extent of the view
     * projection is used.
     * @param extent
     *            extent
     * @return this instance
     */
    @JsProperty
    ZoomToExtentOptions setExtent(ol.Extent extent);

    /**
     * Text label to use for the button. Default is "E". Instead of text, also a
     * Node (e.g. a span element) can be used.
     * @param label
     *            label
     * @return this instance
     */
    @JsProperty
    ZoomToExtentOptions setLabel(String label);

    /**
     * Text label to use for the button tip. Default is "Zoom to extent".
     * @param tipLabel
     *            tip label
     * @return this instance
     */
    @JsProperty
    ZoomToExtentOptions setTipLabel(String tipLabel);

}
