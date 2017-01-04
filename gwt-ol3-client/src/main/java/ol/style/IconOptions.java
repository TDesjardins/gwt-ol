package ol.style;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;

/**
 * Options for the icon style.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class IconOptions implements Options {

    /**
     *
     * @param imageUri Image source URI
     */
    @JsProperty
    public native void setSrc(String imageUri);

}
