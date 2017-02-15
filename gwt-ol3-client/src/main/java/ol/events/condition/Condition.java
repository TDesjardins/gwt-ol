package ol.events.condition;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.GenericFunction;
import ol.MapBrowserEvent;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Condition {

    /**
     * @return function that returns true if the event is a click event
     */
    @JsProperty(name = "click", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getClick();
    
    /**
     * @return function that returns true if the event is a dblclick event
     */
    @JsProperty(name = "doubleClick", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getDoubleClick();
    
    /**
     * @return function that always returns false
     */
    @JsProperty(name = "never", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getNever();
    
    /**
     * @return function that returns true if the browser event is a pointermove event
     */
    @JsProperty(name = "pointerMove", namespace = "ol.events.condition")
    public static native GenericFunction<MapBrowserEvent, Boolean> getPointerMove();
    
}
