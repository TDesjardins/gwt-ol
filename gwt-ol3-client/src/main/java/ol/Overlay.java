package ol;

import com.google.gwt.core.client.js.JsType;
import com.google.gwt.dom.client.Element;

/**
 * An element to be displayed over the map and attached to a single map
 * location. Like {@link ol.control.Control}, Overlays are visible widgets.
 * Unlike Controls, they are not in a fixed position on the screen, but are tied
 * to a geographical coordinate, so panning the map will move an Overlay but not
 * a Control.
 *
 * Example:
 *
 * var popup = new ol.Overlay({ element: document.getElementById('popup') });
 * popup.setPosition(coordinate); map.addOverlay(popup);
 *
 *
 * @author sbaumhekel
 */
@JsType(prototype = "ol.Overlay")
public interface Overlay extends Object {

    static final String POSITIONING_BOTTOM_CENTER = "bottom-center";
    static final String POSITIONING_BOTTOM_LEFT = "bottom-left";
    static final String POSITIONING_BOTTOM_RIGHT = "bottom-right";
    static final String POSITIONING_CENTER_CENTER = "center-center";
    static final String POSITIONING_CENTER_LEFT = "center-left";
    static final String POSITIONING_CENTER_RIGHT = "center-right";
    static final String POSITIONING_TOP_CENTER = "top-center";
    static final String POSITIONING_TOP_LEFT = "top-left";
    static final String POSITIONING_TOP_RIGHT = "top-right";

    /**
     * Get the DOM element of this overlay.
     * @return {Element|undefined} The Element containing the overlay.
     */
    Element getElement();

    /**
     * Get the overlay identifier which is set on constructor.
     * @return {number|string|undefined} Id.
     */
    String getId();

    /**
     * Get the map associated with this overlay.
     * @return {ol.Map|undefined} The map that the overlay is part of.
     */
    Map getMap();

    /**
     * Get the offset of this overlay.
     * @return {Array.<number>} The offset.
     */
    Pixel getOffset();

    /**
     * Get the current position of this overlay.
     * @return {ol.Coordinate|undefined} The spatial point that the overlay is
     *         anchored at.
     */
    Coordinate getPosition();

    /**
     * Get the current positioning of this overlay.
     * @return {ol.OverlayPositioning} How the overlay is positioned relative to
     *         its point on the map.
     */
    String getPositioning();

    /**
     * Set the DOM element to be associated with this overlay.
     * @param element
     *            The Element containing the overlay.
     */
    void setElement(Element element);

    /**
     * Set the map to be associated with this overlay.
     * @param map
     *            The map that the overlay is part of.
     */
    void setMap(Map map);

    /**
     * Set the offset for this overlay.
     * @param offset
     *            Offset.
     */
    void setOffset(Pixel offset);

    /**
     * Set the position for this overlay. If the position is `undefined` the
     * overlay is hidden.
     * @param position
     *            The spatial point that the overlay is anchored at.
     */
    void setPosition(Coordinate position);

    /**
     * Set the positioning for this overlay.
     * @param positioning
     *            how the overlay is positioned relative to its point on the
     *            map.
     */
    void setPositioning(String positioning);

}
