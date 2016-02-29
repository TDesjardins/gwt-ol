package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Rotate control options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface RotateOptions extends ControlOptions {

    /**
     * Hide the control when rotation is 0. Default is true.
     * @param autoHide
     *            auto hide
     * @return this instance
     */
    @JsProperty
    RotateOptions setAutoHide(boolean autoHide);

    /**
     * CSS class name. Default is "ol-rotate".
     * @param className
     *            class name
     * @return this instance
     */
    @JsProperty
    RotateOptions setClassName(String className);

    /**
     * Animation duration in milliseconds. Default is 250.
     * @param duration
     *            animation duration
     * @return this instance
     */
    @JsProperty
    RotateOptions setDuration(int duration);

    /**
     * Text label to use for the rotate button. Default is (arrow up). Instead
     * of text, also a Node (e.g. a span element) can be used.
     * @param label
     *            label
     * @return this instance
     */
    @JsProperty
    RotateOptions setLabel(String label);

    /**
     * Text label to use for the button tip. Default is "Reset rotation".
     * @param tipLabel
     *            tip label
     * @return this instance
     */
    @JsProperty
    RotateOptions setTipLabel(String tipLabel);

}
