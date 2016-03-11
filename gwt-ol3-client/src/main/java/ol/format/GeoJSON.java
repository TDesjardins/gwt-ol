/**
 *
 */
package ol.format;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.Options;
import ol.geom.Geometry;
import ol.proj.Projection;

/**
 * Feature format for reading and writing data in the GeoJSON format.
 * @author tlochmann
 */
@JsType(isNative = true)
public class GeoJSON extends JSONFeature {

    public GeoJSON() {}

    public GeoJSON(GeoJSONOptions geoJSONOptions) {}

	/**
	 * Read the projection from a GeoJSON source.
	 * @param source Document | Node | Object | string
	 * @return {@link Geometry}
	 */
	public native Projection readProjection(java.lang.Object source);

	/**
	 * Read a feature from a GeoJSON Feature source. Only works for Feature, use readFeatures to read FeatureCollection
	 * source.
	 * @param source Document | Node | Object | string
	 * @param opt_options Read options.
	 * @return {@link Feature}
	 */
	public native Feature readFeature(java.lang.Object source, @Nullable Options opt_options);

	/**
	 * Read all features from a GeoJSON source. Works with both Feature and FeatureCollection sources.
	 * @param source Document | Node | Object | string
	 * @param opt_options Read options.
	 * @return [] {@link Feature}
	 */
	public native Feature[] readFeatures(java.lang.Object source, @Nullable Options opt_options);

	/**
	 * Read a geometry from a GeoJSON source.
	 * @param source Document | Node | Object | string
	 * @param opt_options Read options.
	 * @return {@link Geometry}
	 */
	public native Geometry readGeometry(java.lang.Object source, @Nullable Options opt_options);

	/**
	 * Encode a feature as a GeoJSON Feature string.
	 * @param feature ol.Feature
	 * @param opt_options Write options.
	 * @return {@link String}
	 */
	public native String writeFeature(Feature feature, @Nullable Options opt_options);

	/**
	 * Encode a feature as a GeoJSON Feature object.
	 * @param feature ol.Feature
	 * @param opt_options Write options.
	 * @return {@link GeoJSON}
	 */
	public native GeoJSON writeFeatureObject(Feature feature, @Nullable Options opt_options);

	/**
	 * Encode an array of features as GeoJSON.
	 * @param feature ol.Feature
	 * @param opt_options Write options.
	 * @return {@link String}
	 */
	public native String writeFeatures(Feature feature, @Nullable Options opt_options);

	/**
	 * Encode an array of features as GeoJSON.
	 * @param feature ol.Feature
	 * @param opt_options Write options.
	 * @return Collection<{@link GeoJSON}>
	 */
	public native Collection<GeoJSON> writeFeaturesObject(Feature feature, @Nullable Options opt_options);

	/**
	 * Encode a geometry as a GeoJSON string.
	 * @param geometry {@link Geometry }
	 * @param opt_options Write options.
	 * @return {@link String}
	 */
	public native String writeGeometry(Geometry geometry, @Nullable Options opt_options);

	/**
	 * Encode a geometry as a GeoJSON object.
	 * @param geometry {@link Geometry }
	 * @param opt_options Write options.
	 * @return Collection<{@link GeoJSON}>
	 */
	public native Collection<GeoJSON> writeGeometryObject(Geometry geometry, @Nullable Options opt_options);

}
