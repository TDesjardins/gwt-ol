package ol;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.proj.Projection;

/**
 * Options for creating a {@link ol.View}.
 * 
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface ViewOptions extends Options {

    @JsProperty
    void setCenter(Coordinate coordinate);

    @JsProperty
    void setProjection(Projection projection);

    @JsProperty
    void setZoom(double zoom);

}
