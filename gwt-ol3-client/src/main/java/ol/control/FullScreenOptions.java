package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * FullScreen options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface FullScreenOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-full-screen".
     * @param className
     *            class name
     * @return this instance
     */
    @JsProperty
    FullScreenOptions setClassName(String className);

    /**
     * Full keyboard access.
     * @param keys
     *            keys
     * @return this instance
     */
    @JsProperty
    FullScreenOptions setKeys(boolean keys);

    /**
     * Text label to use for the button. Default is \u2922 (NORTH EAST AND SOUTH
     * WEST ARROW). Instead of text, also a Node (e.g. a span element) can be
     * used.
     * @param label
     *            label
     * @return this instance
     */
    @JsProperty
    FullScreenOptions setLabel(String label);

    /**
     * Text label to use for the button when full-screen is active. Default is
     * \u00d7 (a cross). Instead of text, also a Node (e.g. a span element) can
     * be used.
     * @param labelActive
     *            labelActive
     * @return this instance
     */
    @JsProperty
    FullScreenOptions setLabelActive(String labelActive);

    /**
     * Text label to use for the button tip. Default is "Toggle full-screen".
     * @param tipLabel
     *            tip label
     * @return this instance
     */
    @JsProperty
    FullScreenOptions setTipLabel(String tipLabel);

}
