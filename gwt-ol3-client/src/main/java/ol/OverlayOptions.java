package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import com.google.gwt.dom.client.Element;

/**
 * {@link Overlay} options.
 * @author sbaumhekel
 *
 */
@JsType
public interface OverlayOptions extends Options {

    /**
     * If set to true the map is panned when calling setPosition, so that the
     * overlay is entirely visible in the current viewport. The default is
     * false.
     * @param autoPan
     *            auto pan?
     * @return this instance
     */
    @JsProperty
    OverlayOptions setAutoPan(boolean autoPan);

    /**
     * The margin (in pixels) between the overlay and the borders of the map
     * when autopanning. The default is 20.
     * @param autoPanMargin
     *            auto pan margin
     * @return this instance
     */
    @JsProperty
    OverlayOptions setAutoPanMargin(int autoPanMargin);

    /**
     * The overlay element.
     * @param element
     *            element
     * @return this instance
     */
    @JsProperty
    OverlayOptions setElement(Element element);

    /**
     * Set the overlay id. The overlay id can be used with the
     * ol.Map#getOverlayById method.
     * @param id
     *            id
     * @return this instance
     */
    @JsProperty
    OverlayOptions setId(String id);

    /**
     * Whether the overlay is inserted first in the overlay container, or
     * appended. Default is true. If the overlay is placed in the same container
     * as that of the controls (see the stopEvent option) you will probably set
     * insertFirst to true so the overlay is displayed below the controls.
     * @param insertFirst
     *            insert first?
     * @return this instance
     */
    @JsProperty
    OverlayOptions setInsertFirst(boolean insertFirst);

    /**
     * Offsets in pixels used when positioning the overlay. The first element in
     * the array is the horizontal offset. A positive value shifts the overlay
     * right. The second element in the array is the vertical offset. A positive
     * value shifts the overlay down. Default is [0, 0].
     * @param offset
     *            offset
     * @return this instance
     */
    @JsProperty
    OverlayOptions setOffset(Pixel offset);

    /**
     * The overlay position in map projection.
     * @param position
     *            position
     * @return this instance
     */
    @JsProperty
    OverlayOptions setPosition(Coordinate position);

    /**
     * Defines how the overlay is actually positioned with respect to its
     * position property. Possible values are 'bottom-left', 'bottom-center',
     * 'bottom-right', 'center-left', 'center-center', 'center-right',
     * 'top-left', 'top-center', and 'top-right'. Default is 'top-left'.
     * @param positioning
     *            positioning
     * @return this instance
     */
    @JsProperty
    OverlayOptions setPositioning(String positioning);

    /**
     * Whether event propagation to the map viewport should be stopped. Default
     * is true. If true the overlay is placed in the same container as that of
     * the controls (CSS class name ol-overlaycontainer-stopevent); if false it
     * is placed in the container with CSS class name ol-overlaycontainer.
     * @param stopEvent
     *            stop event propagation to the map viewport?
     * @return this instance
     */
    @JsProperty
    OverlayOptions setStopEvent(boolean stopEvent);
}
