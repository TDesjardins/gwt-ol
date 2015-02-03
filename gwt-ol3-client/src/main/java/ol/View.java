package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.proj.Projection;

/**
 * @author Tino Desjardins
 */
@JsType(prototype = "View")
public interface View extends Object {

    void rotate(float rotation, double[] coordinate);

    void setCenter(double[] center);

    void setZoom(double zoom);

    Projection getProjection();

    @JsProperty
    void setProjection(Projection projection);

}

