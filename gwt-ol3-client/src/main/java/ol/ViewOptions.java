package ol;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.proj.Projection;

/**
 * Options for creating a {@link ol.View}.
 * 
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewOptions implements Options {

    @JsProperty
    public native void setCenter(Coordinate coordinate);

    @JsProperty
    public native void setProjection(Projection projection);

    @JsProperty
    public native void setZoom(double zoom);

    @JsProperty
    public native void setMinZoom(double minZoom);

    @JsProperty
    public native void setMaxZoom(double maxZoom);
}
