package ol.geom;

import com.google.gwt.core.client.js.JsType;

/**
 * MultiPolygon geometry.
 *
 * @author sbaumhekel
 */
@JsType(prototype = "ol.geom.MultiPolygon")
public interface MultiPolygon extends SimpleGeometryMultiCoordinates {
    /**
     * Append the passed polygon to this multipolygon.
     * 
     * @param polygon
     *            Polygon.
     * @api stable
     */
    void appendPolygon(Polygon polygon);

    /**
     * Return the polygon at the specified index.
     * 
     * @param index
     *            Index.
     * @return {ol.geom.Polygon} Polygon.
     * @api stable
     */
    Polygon getPolygon(int index);

    /**
     * Return the polygons of this multipolygon.
     * 
     * @return {Array.<ol.geom.Polygon>} Polygons.
     * @api stable
     */
    Polygon[] getPolygons();
}
