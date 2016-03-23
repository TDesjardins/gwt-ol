package ol.geom;

import jsinterop.annotations.JsType;

/**
 * LinearRing geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class LinearRing extends SimpleGeometryCoordinates {
    
    /**
     * Return the area of the linear ring on projected plane.
     * 
     * @return {number} Area (on projected plane).
     */
    public native double getArea();

}
