package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Attribution options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface AttributionOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-attribution".
     * @param className
     *            class name
     * @return this instance
     */
    @JsProperty
    AttributionOptions setClassName(String className);

    /**
     * Specify if attributions should be collapsed at startup. Default is true.
     * @param collapsed
     *            collapsed
     * @return this instance
     */
    @JsProperty
    AttributionOptions setCollapsed(boolean collapsed);

    /**
     * Text label to use for the expanded attributions button. Default is "»".
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param collapseLabel
     *            collapseLabel
     * @return this instance
     */
    @JsProperty
    AttributionOptions setCollapseLabel(String collapseLabel);

    /**
     * Specify if attributions can be collapsed. If you use an OSM source,
     * should be set to false - see OSM Copyright - Default is true.
     * @param collapsible
     *            collapsible
     * @return this instance
     */
    @JsProperty
    AttributionOptions setCollapsible(boolean collapsible);

    /**
     * Text label to use for the collapsed attributions button. Default is "i".
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param label
     *            label
     * @return this instance
     */
    @JsProperty
    AttributionOptions setLabel(String label);

    /**
     * Text label to use for the button tip. Default is "Attributions".
     * @param tipLabel
     *            tip label
     * @return this instance
     */
    @JsProperty
    AttributionOptions setTipLabel(String tipLabel);

}
