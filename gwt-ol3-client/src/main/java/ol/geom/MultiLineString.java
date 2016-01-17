package ol.geom;

import jsinterop.annotations.JsType;

/**
 * MultiLineString geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class MultiLineString extends SimpleGeometryMultiCoordinates {
    
    /**
     * Append the passed linestring to the multilinestring.
     * 
     * @param lineString LineString.
     */
    public native void appendLineString(LineString lineString);

    /**
     * Return the linestring at the specified index.
     * 
     * @param index
     *            Index.
     * @return {ol.geom.LineString} LineString.
     */
    public native LineString getLineString(int index);

    /**
     * Return the linestrings of this multilinestring.
     * 
     * @return {Array.<ol.geom.LineString>} LineStrings.
     */
    public native LineString[] getLineStrings();
    
}
