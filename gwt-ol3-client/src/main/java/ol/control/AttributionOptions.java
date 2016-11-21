package ol.control;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Attribution options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface AttributionOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-attribution".
     * @param className
     *            class name
     */
    @JsProperty
    void setClassName(String className);

    /**
     * Specify if attributions should be collapsed at startup. Default is true.
     * @param collapsed
     *            collapsed
     */
    @JsProperty
    void setCollapsed(boolean collapsed);

    /**
     * Text label to use for the expanded attributions button. Default is "»".
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param collapseLabel
     *            collapseLabel
     */
    @JsProperty
    void setCollapseLabel(String collapseLabel);

    /**
     * Specify if attributions can be collapsed. If you use an OSM source,
     * should be set to false - see OSM Copyright - Default is true.
     * @param collapsible
     *            collapsible
     */
    @JsProperty
    void setCollapsible(boolean collapsible);

    /**
     * Text label to use for the collapsed attributions button. Default is "i".
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param label
     *            label
     */
    @JsProperty
    void setLabel(String label);

    /**
     * Text label to use for the button tip. Default is "Attributions".
     * @param tipLabel
     *            tip label
     */
    @JsProperty
    void setTipLabel(String tipLabel);

}
