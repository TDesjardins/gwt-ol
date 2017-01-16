package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Options;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class StamenOptions implements Options {

    /**
     * 
     * @param layerName
     *            watercolor, toner
     */
    @JsProperty
    public native void setLayer(String layerName);

}
