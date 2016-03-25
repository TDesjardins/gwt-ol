package ol;

import jsinterop.annotations.JsType;

import ol.geom.Geometry;
import ol.style.Style;

/**
 * A vector object for geographic features with a geometry and other attribute
 * properties, similar to the features in vector file formats like GeoJSON.
 *
 * Features can be styled individually with `setStyle`; otherwise they use the
 * style of their vector layer.
 *
 * Note that attribute properties are set as {@link ol.Object} properties on the
 * feature object, so they are observable, and have get/set accessors.
 *
 * Typically, a feature has a single geometry property. You can set the geometry
 * using the `setGeometry` method and get it with `getGeometry`. It is possible
 * to store more than one geometry on a feature using attribute properties. By
 * default, the geometry used for rendering is identified by the property name
 * `geometry`. If you want to use another geometry property for rendering, use
 * the `setGeometryName` method to change the attribute property associated with
 * the geometry for the feature. For example:
 *
 * ```js var feature = new ol.Feature({ geometry: new
 * ol.geom.Polygon(polyCoords), labelPoint: new ol.geom.Point(labelCoords),
 * name: 'My Polygon' });
 *
 * // get the polygon geometry var poly = feature.getGeometry();
 *
 * // Render the feature as a point using the coordinates from labelPoint
 * feature.setGeometryName('labelPoint');
 *
 * // get the point geometry var point = feature.getGeometry(); ```
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Feature extends Object {

    
    public Feature() {}
    
    public Feature(FeatureOptions featureOptions) {}
    
    /**
     * Clone this feature. If the original feature has a geometry it is also
     * cloned. The feature id is not set in the clone.
     * 
     * @return {ol.Feature} The clone.
     */
    public native Feature clone();

    /**
     * Get the feature's default geometry. A feature may have any number of
     * named geometries. The "default" geometry (the one that is rendered by
     * default) is set when calling {@link ol.Feature#setGeometry}.
     * 
     * @return {ol.geom.Geometry|undefined} The default geometry for the
     *         feature.
     */
    public native Geometry getGeometry();

    /**
     * Get the name of the feature's default geometry. By default, the default
     * geometry is named `geometry`.
     * 
     * @return {string} Get the property name associated with the default
     *         geometry for this feature.
     */
    public native String getGeometryName();

    /**
     * Get the feature identifier. This is a stable identifier for the feature
     * and is either set when reading data from a remote source or set
     * explicitly by calling {@link ol.Feature#setId}.
     * 
     * @return {number|string|undefined} Id.
     */
    public native String getId();

    /**
     * Get the feature's style. This return for this method depends on what was
     * provided to the {@link ol.Feature#setStyle} method.
     * 
     * @return {ol.style.Style|Array.<ol.style.Style>| ol.FeatureStyleFunction}
     *         The feature style.
     */
    public native Style getStyle();

    /**
     * Set the default geometry for the feature. This will update the property
     * with the name returned by {@link ol.Feature#getGeometryName}.
     * 
     * @param geometry
     *            The new geometry.
     */
    public native void setGeometry(Geometry geometry);

    /**
     * Set the property name to be used when getting the feature's default
     * geometry. When calling {@link ol.Feature#getGeometry}, the value of the
     * property with this name will be returned.
     * 
     * @param name
     *            The property name of the default geometry.
     */
    public native void setGeometryName(String name);

    /**
     * Set the feature id. The feature id is considered stable and may be used
     * when requesting features or comparing identifiers returned from a remote
     * source. The feature id can be used with the
     * {@link ol.source.Vector#getFeatureById} method.
     * 
     * @param id
     *            The feature id.
     */
    public native void setId(String id);

    /**
     * Set the style for the feature. This can be a single style object, an
     * array of styles, or a function that takes a resolution and returns an
     * array of styles. If it is `null` the feature has no style (a `null`
     * style).
     * 
     * @param style
     *            Style for this feature.
     */
    public native void setStyle(Style style);

}
