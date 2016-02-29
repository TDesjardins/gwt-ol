package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Zoom slider control options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface ZoomSliderOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-zoomslider".
     * @param className
     *            class name
     * @return this instance
     */
    @JsProperty
    ZoomSliderOptions setClassName(String className);

    /**
     * Animation duration in milliseconds. Default is 200.
     * @param duration
     *            animation duration
     * @return this instance
     */
    @JsProperty
    ZoomSliderOptions setDuration(int duration);

    /**
     * Maximum resolution.
     * @param maxResolution
     *            max resolution
     * @return this instance
     */
    @JsProperty
    ZoomSliderOptions setMaxResolution(double maxResolution);

    /**
     * Minimum resolution.
     * @param minResolution
     *            min resolution
     * @return this instance
     */
    @JsProperty
    ZoomSliderOptions setMinResolution(double minResolution);

}
