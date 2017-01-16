/**
 *
 * @author mribeiro
 * @date 07/06/16 18:05
 *
 */
package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileWMSParams {

    /**
     *
     * @param layers
     */
    @JsProperty(name = "LAYERS")
    public native void setLayers(String layers);

    /**
     *
     * @param version
     */
    @JsProperty(name = "VERSION")
    public native void setVersion(String version);

    /**
     *
     * @param tiled
     */
    @JsProperty(name = "TILED")
    public native void setTiled(boolean tiled);
}