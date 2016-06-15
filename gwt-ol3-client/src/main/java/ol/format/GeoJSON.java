/**
 *
 */
package ol.format;

import javax.annotation.Nullable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.js.JsType;

import ol.Collection;
import ol.Feature;
import ol.Options;
import ol.geom.Geometry;
import ol.proj.Projection;

/**
 * Feature format for reading and writing data in the GeoJSON format.
 * @author tlochmann
 */
@JsType(prototype = "ol.format.GeoJSON")
public interface GeoJSON extends JSONFeature {

	/**
	 * Read the projection from a GeoJSON source.
	 * @param source Document | Node | Object | string
	 * @return {@link Geometry}
	 */
	Projection readProjection(java.lang.Object source);

	/**
	 * Read a feature from a GeoJSON Feature source. Only works for Feature, use readFeatures to read FeatureCollection
	 * source.
	 * @param source Document | Node | Object | string
	 * @param opt_options Read options.
	 * @return {@link Feature}
	 */
	Feature readFeature(java.lang.Object source, @Nullable Options opt_options);

	/**
	 * Read all features from a GeoJSON source. Works with both Feature and FeatureCollection sources.
	 * @param source Document | Node | Object | string
	 * @param opt_options Read options.
	 * @return [] {@link Feature}
	 */
	Feature[] readFeatures(java.lang.Object source, @Nullable Options opt_options);

	/**
	 * Read a geometry from a GeoJSON source.
	 * @param source Document | Node | Object | string
	 * @param opt_options Read options.
	 * @return {@link Geometry}
	 */
	Geometry readGeometry(java.lang.Object source, @Nullable Options opt_options);

	/**
	 * Encode a feature as a GeoJSON Feature string.
	 * @param feature ol.Feature
	 * @param opt_options Write options.
	 * @return {@link String}
	 */
	String writeFeature(Feature feature, @Nullable Options opt_options);

	/**
	 * Encode a feature as a GeoJSON Feature object.
	 * @param feature ol.Feature
	 * @param opt_options Write options.
	 * @return {@link GeoJSON}
	 */
	JavaScriptObject writeFeatureObject(Feature feature, @Nullable Options opt_options);

	/**
	 * Encode an array of features as GeoJSON.
	 * @param feature ol.Feature
	 * @param opt_options Write options.
	 * @return {@link String}
	 */
	String writeFeatures(Feature feature, @Nullable Options opt_options);

	/**
	 * Encode an array of features as GeoJSON.
	 * @param feature ol.Feature
	 * @param opt_options Write options.
	 * @return Collection<{@link GeoJSON}>
	 */
	Collection<JavaScriptObject> writeFeaturesObject(Feature feature, @Nullable Options opt_options);

	/**
	 * Encode a geometry as a GeoJSON string.
	 * @param geometry {@link Geometry }
	 * @param opt_options Write options.
	 * @return {@link String}
	 */
	String writeGeometry(Geometry geometry, @Nullable Options opt_options);

	/**
	 * Encode a geometry as a GeoJSON object.
	 * @param geometry {@link Geometry }
	 * @param opt_options Write options.
	 * @return Collection<{@link GeoJSON}>
	 */
	Collection<GeoJSON> writeGeometryObject(Geometry geometry, @Nullable Options opt_options);

}
