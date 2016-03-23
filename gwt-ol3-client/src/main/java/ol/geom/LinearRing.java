package ol.geom;

import com.google.gwt.core.client.js.JsType;

/**
 * LinearRing geometry.
 *
 * @author sbaumhekel
 */
@JsType(prototype = "ol.geom.LinearRing")
public interface LinearRing extends SimpleGeometryCoordinates {
    /**
     * Return the area of the linear ring on projected plane.
     * 
     * @return {number} Area (on projected plane).
     */
    double getArea();

}
