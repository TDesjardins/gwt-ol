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
    public native void setExtent(Extent extent);

    @JsProperty
    public native void setMaxResolution(double maxResolution);

    @JsProperty
    public native void setMinResolution(double minResolution);

    @JsProperty
    public native void setMaxZoom(double maxZoom);

    @JsProperty
    public native void setMinZoom(double minZoom);

    @JsProperty
    public native void setProjection(Projection projection);

    /**
     * {@link #setProjection}
     *
     * @param srsCode combination of authority and identifier such as "EPSG:4326"
     */
    @JsProperty
    public native void setProjection(String srsCode);

    @JsProperty
    public native void setResolutions(double[] resolutions);

    @JsProperty
    public native void setZoom(double zoom);

    @JsProperty
    public native void setZoomFactor(double zoomFactor);
}
