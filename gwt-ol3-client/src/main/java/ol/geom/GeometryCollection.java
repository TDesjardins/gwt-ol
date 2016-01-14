package ol.geom;

import com.google.gwt.core.client.js.JsType;

/**
 * GeometryCollection.
 *
 * @author sbaumhekel
 */
@JsType(prototype = "ol.geom.GeometryCollection")
public interface GeometryCollection extends Geometry {
    /**
     * Return the geometries that make up this geometry collection.
     * 
     * @return {Array.<ol.geom.Geometry>} Geometries.
     */
    Geometry[] getGeometries();

    /**
     * Test if the geometry and the passed extent intersect.
     * 
     * @param extent
     *            Extent.
     * @return {boolean} `true` if the geometry and the extent intersect.
     */
    boolean intersectsExtent(ol.Extent extent);

    /**
     * Set the geometries that make up this geometry collection.
     * 
     * @param geometries
     *            Geometries.
     */
    void setGeometries(ol.geom.Geometry[] geometries);

    /**
     * Translate the geometry. This modifies the geometry coordinates in place.
     * If instead you want a new geometry, first `clone()` this geometry.
     * 
     * @param deltaX
     *            Delta X.
     * @param deltaY
     *            Delta Y.
     */
    void translate(double deltaX, double deltaY);

}
