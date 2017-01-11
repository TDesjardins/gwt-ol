package ol.tilegrid;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * {@link TileGrid} options.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WmtsTileGridOptions extends TileGridOptions {

    @JsProperty
    public native void setMatrixIds(String[] matrixIds);

}
