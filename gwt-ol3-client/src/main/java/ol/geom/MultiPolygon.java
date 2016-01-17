package ol.geom;

import jsinterop.annotations.JsType;

/**
 * MultiPolygon geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class MultiPolygon extends SimpleGeometryMultiCoordinates {
    
    /**
     * Append the passed polygon to this multipolygon.
     * 
     * @param polygon
     *            Polygon.
     * @api stable
     */
    public native void appendPolygon(Polygon polygon);

    /**
     * Return the polygon at the specified index.
     * 
     * @param index
     *            Index.
     * @return {ol.geom.Polygon} Polygon.
     * @api stable
     */
    public native Polygon getPolygon(int index);

    /**
     * Return the polygons of this multipolygon.
     * 
     * @return {Array.<ol.geom.Polygon>} Polygons.
     * @api stable
     */
    public native Polygon[] getPolygons();
    
}
