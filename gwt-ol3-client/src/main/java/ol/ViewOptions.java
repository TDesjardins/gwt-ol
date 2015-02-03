package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.proj.Projection;

/**
 * Options for creating a {@link ol.View}.
 * 
 * @author Tino Desjardins
 */
@JsType
public interface ViewOptions {

    @JsProperty
    void setCenter(double[] center);

    @JsProperty
    void setProjection(Projection projection);

    @JsProperty
    void setZoom(double zoom);

}
