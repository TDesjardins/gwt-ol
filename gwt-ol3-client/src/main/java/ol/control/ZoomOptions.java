package ol.control;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Zoom control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface ZoomOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-zoom".
     * @param className
     *            class name
     */
    @JsProperty
    void setClassName(String className);

    /**
     * The zoom delta applied on each click. Default is 1.
     * @param delta
     *            delta
     */
    @JsProperty
    void setDelta(int delta);

    /**
     * Animation duration in milliseconds. Default is 250.
     * @param duration
     *            animation duration
     */
    @JsProperty
    void setDuration(int duration);

    /**
     * Text label to use for the zoom-in button. Default is "+". Instead of
     * text, also a Node (e.g. a span element) can be used.
     * @param zoomInLabel
     *            label
     */
    @JsProperty
    void setZoomInLabel(String zoomInLabel);

    /**
     * Text label to use for the button tip. Default is "Zoom in".
     * @param zoomInTipLabel
     *            label
     */
    @JsProperty
    void setZoomInTipLabel(String zoomInTipLabel);

    /**
     * Text label to use for the zoom-out button. Default is "-". Instead of
     * text, also a Node (e.g. a span element) can be used.
     * @param zoomOutLabel
     *            label
     */
    @JsProperty
    void setZoomOutLabel(String zoomOutLabel);

    /**
     * Text label to use for the button tip. Default is "Zoom out".
     * @param zoomOutTipLabel
     *            label
     */
    @JsProperty
    void setZoomOutTipLabel(String zoomOutTipLabel);

}
