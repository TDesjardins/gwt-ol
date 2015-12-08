package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.proj.Projection;

/**
 * @author Tino Desjardins
 */
@JsType(prototype = "View")
public interface View extends Object {
    
    Coordinate getCenter();

    void rotate(float rotation, double[] coordinate);

    void setCenter(Coordinate center);

    void setZoom(double zoom);

    Projection getProjection();

    @JsProperty
    void setProjection(Projection projection);

    /**
     * Get the current zoom level. Return undefined if the current resolution is undefined or not a "constrained resolution".
     * @return Zoom.
     */
    int getZoom();
}

