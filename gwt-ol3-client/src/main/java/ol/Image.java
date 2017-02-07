package ol;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * @author Peter Zanetti
 */
@JsType(isNative = true)
public class Image {

    @JsMethod
    public native void load();
}
