package ol.interaction;

import jsinterop.annotations.JsType;

/**
 * Base class that calls user-defined functions on `down`, `move` and `up`
 * events. This class also manages "drag sequences".
 *
 * When the `handleDownEvent` user function returns `true` a drag sequence is
 * started. During a drag sequence the `handleDragEvent` user function is called
 * on `move` events. The drag sequence ends when the `handleUpEvent` user
 * function is called and returns `false`.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Pointer extends Interaction {

}
