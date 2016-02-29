package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * OverviewMap control options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface OverviewMapOptions extends ControlOptions {

    /**
     * Whether the control should start collapsed or not (expanded). Default to
     * true.
     * @param collapsed
     *            collapsed
     * @return this instance
     */
    @JsProperty
    OverviewMapOptions setCollapsed(boolean collapsed);

    /**
     * Text label to use for the expanded overviewmap button. Default is "«".
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param collapseLabel
     *            collapseLabel
     * @return this instance
     */
    @JsProperty
    OverviewMapOptions setCollapseLabel(String collapseLabel);

    /**
     * Whether the control can be collapsed or not. Default to true.
     * @param collapsible
     *            collapsible
     * @return this instance
     */
    @JsProperty
    OverviewMapOptions setCollapsible(boolean collapsible);

    /**
     * Text label to use for the collapsed overviewmap button. Default is ».
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param label
     *            label
     * @return this instance
     */
    @JsProperty
    OverviewMapOptions setLabel(String label);

    /**
     * Layers for the overview map. If not set, then all main map layers are
     * used instead.
     * @param layers
     *            layers
     * @return this instance
     */
    @JsProperty
    OverviewMapOptions setLayers(ol.Collection<ol.layer.Layer> layers);

    /**
     * Text label to use for the button tip. Default is "Overview map".
     * @param tipLabel
     *            tip label
     * @return this instance
     */
    @JsProperty
    OverviewMapOptions setTipLabel(String tipLabel);

    /**
     * Custom view for the overview map. If not provided, a default view with an
     * EPSG:3857 projection will be used.
     * @param view
     *            view
     * @return this instance
     */
    @JsProperty
    OverviewMapOptions setView(ol.View view);

}
