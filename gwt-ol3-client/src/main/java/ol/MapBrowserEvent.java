package ol;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;

/**
 * Events emitted as map browser events are instances of this type. See
 * {@link ol.Map} for which events trigger a map browser event.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface MapBrowserEvent extends MapEvent {

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
