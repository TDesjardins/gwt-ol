package ol.geom;

import jsinterop.annotations.JsType;

/**
 * MultiLineString geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface MultiLineString extends SimpleGeometryMultiCoordinates {
    /**
     * Append the passed linestring to the multilinestring.
     * 
     * @param lineString LineString.
     */
    void appendLineString(LineString lineString);

    /**
     * Return the linestring at the specified index.
     * 
     * @param index
     *            Index.
     * @return {ol.geom.LineString} LineString.
     */
    LineString getLineString(int index);

    /**
     * Return the linestrings of this multilinestring.
     * 
     * @return {Array.<ol.geom.LineString>} LineStrings.
     */
    LineString[] getLineStrings();
}
