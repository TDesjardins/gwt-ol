package ol;

import com.google.gwt.core.client.js.*;

/**
 * Events emitted as map browser events are instances of this type. See
 * {@link ol.Map} for which events trigger a map browser event.
 *
 * @author sbaumhekel
 */
@JsType
public interface MapBrowserEvent extends MapEvent {

    /**
     * A click with no dragging. A double click will fire two of this.
     */
    static final String CLICK = "click";

    /**
     * A true double click, with no dragging.
     */
    static final String DBLCLICK = "dblclick";

    static final String POINTERCANCEL = "pointercancel";

    static final String POINTERDOWN = "pointerdown";

    /**
     * Triggered when a pointer is dragged.
     */
    static final String POINTERDRAG = "pointerdrag";

    static final String POINTERENTER = "pointerenter";

    static final String POINTERLEAVE = "pointerleave";

    /**
     * Triggered when a pointer is moved. Note that on touch devices this is
     * triggered when the map is panned, so is not the same as mousemove.
     */
    static final String POINTERMOVE = "pointermove";

    static final String POINTEROUT = "pointerout";

    static final String POINTEROVER = "pointerover";

    static final String POINTERUP = "pointerup";

    /**
     * A true single click with no dragging and no double click. Note that this
     * event is delayed by 250 ms to ensure that it is not a double click.
     */
    static final String SINGLECLICK = "singleclick";

    /**
     * The coordinate of the original browser event.
     *
     * @return {ol.Coordinate}
     */
    @JsProperty
    Coordinate getCoordinate();

    /**
     * Indicates if the map is currently being dragged. Only set for
     * `POINTERDRAG` and `POINTERMOVE` events. Default is `false`.
     *
     * @return boolean
     */
    @JsProperty
    boolean getDragging();

    /**
     * The pixel of the original browser event.
     *
     * @return {ol.Pixel}
     */
    @JsProperty
    Pixel getPixel();
}
