package ol;

import com.google.gwt.dom.client.Element;

import jsinterop.annotations.JsType;

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
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Overlay extends Object {

    public Overlay() {}
    
    public Overlay(OverlayOptions options) {}
    
    /**
     * Get the DOM element of this overlay.
     * @return {Element|undefined} The Element containing the overlay.
     */
    public native Element getElement();

    /**
     * Get the overlay identifier which is set on constructor.
     * @return {number|string|undefined} Id.
     */
    public native String getId();

    /**
     * Get the map associated with this overlay.
     * @return {ol.Map|undefined} The map that the overlay is part of.
     */
    public native Map getMap();

    /**
     * Get the offset of this overlay.
     * @return {Array.<number>} The offset.
     */
    public native Pixel getOffset();

    /**
     * Get the current position of this overlay.
     * @return {ol.Coordinate|undefined} The spatial point that the overlay is
     *         anchored at.
     */
    public native Coordinate getPosition();

    /**
     * Get the current positioning of this overlay.
     * @return {ol.OverlayPositioning} How the overlay is positioned relative to
     *         its point on the map.
     */
    public native String getPositioning();

    /**
     * Set the DOM element to be associated with this overlay.
     * @param element
     *            The Element containing the overlay.
     */
    public native void setElement(Element element);

    /**
     * Set the map to be associated with this overlay.
     * @param map
     *            The map that the overlay is part of.
     */
    public native void setMap(Map map);

    /**
     * Set the offset for this overlay.
     * @param offset
     *            Offset.
     */
    public native void setOffset(Pixel offset);

    /**
     * Set the position for this overlay. If the position is `undefined` the
     * overlay is hidden.
     * @param position
     *            The spatial point that the overlay is anchored at.
     */
    public native void setPosition(Coordinate position);

    /**
     * Set the positioning for this overlay.
     * @param positioning
     *            how the overlay is positioned relative to its point on the
     *            map.
     */
    public native void setPositioning(String positioning);

}
