package ol.control;

import com.google.gwt.core.client.js.JsType;

import ol.Map;

/**
 * A control with a map acting as an overview map for an other defined map.
 *
 * @author sbaumhekel
 */
@JsType(prototype = "ol.control.OverviewMap")
public interface OverviewMap extends Control {

    /**
     * Determine if the overview map is collapsed.
     * @return {boolean} The overview map is collapsed.
     * @api stable
     */
    boolean getCollapsed();

    /**
     * Return `true` if the overview map is collapsible, `false` otherwise.
     * @return {boolean} True if the widget is collapsible.
     * @api stable
     */
    boolean getCollapsible();

    /**
     * Return the overview map.
     * @return {ol.Map} Overview map.
     */
    Map getOverviewMap();

    /**
     * Collapse or expand the overview map according to the passed parameter.
     * Will not do anything if the overview map isn't collapsible or if the
     * current collapsed state is already the one requested.
     * @param collapsed
     *            True if the widget is collapsed.
     * @api stable
     */
    void setCollapsed(boolean collapsed);

    /**
     * Set whether the overview map should be collapsible.
     * @param collapsible
     *            True if the widget is collapsible.
     * @api stable
     */
    void setCollapsible(boolean collapsible);

}
