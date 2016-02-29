package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Zoom control options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface ZoomOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-zoom".
     * @param className
     *            class name
     * @return this instance
     */
    @JsProperty
    ZoomOptions setClassName(String className);

    /**
     * The zoom delta applied on each click. Default is 1.
     * @param delta
     *            delta
     * @return this instance
     */
    @JsProperty
    ZoomOptions setDelta(int delta);

    /**
     * Animation duration in milliseconds. Default is 250.
     * @param duration
     *            animation duration
     * @return this instance
     */
    @JsProperty
    ZoomOptions setDuration(int duration);

    /**
     * Text label to use for the zoom-in button. Default is "+". Instead of
     * text, also a Node (e.g. a span element) can be used.
     * @param zoomInLabel
     *            label
     * @return this instance
     */
    @JsProperty
    ZoomOptions setZoomInLabel(String zoomInLabel);

    /**
     * Text label to use for the button tip. Default is "Zoom in".
     * @param zoomInTipLabel
     *            label
     * @return this instance
     */
    @JsProperty
    ZoomOptions setZoomInTipLabel(String zoomInTipLabel);

    /**
     * Text label to use for the zoom-out button. Default is "-". Instead of
     * text, also a Node (e.g. a span element) can be used.
     * @param zoomOutLabel
     *            label
     * @return this instance
     */
    @JsProperty
    ZoomOptions setZoomOutLabel(String zoomOutLabel);

    /**
     * Text label to use for the button tip. Default is "Zoom out".
     * @param zoomOutTipLabel
     *            label
     * @return this instance
     */
    @JsProperty
    ZoomOptions setZoomOutTipLabel(String zoomOutTipLabel);

}
