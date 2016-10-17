package ol.format;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 * The {@link WKTFeatureOptions} class represents the options for reading or
 * writing a feature from or to wkt
 */
@JsType(isNative = true)
public interface WKTFeatureOptions extends Options {

	/**
	 * Projection of the data we are reading. If not provided, the projection will
	 * be derived from the data (where possible) or the defaultDataProjection of
	 * the format is assigned (where set). If the projection can not be derived
	 * from the data and if no defaultDataProjection is set for a format, the
	 * features will not be reprojected.
	 * 
	 * @param projection
	 */
	@JsProperty
	void setDataProjection(Projection projection);

	/**
	 * Projection of the feature geometries created by the format reader. If not
	 * provided, features will be returned in the dataProjection.
	 * 
	 * @param projection
	 */
	@JsProperty
	void setFeatureProjection(Projection projection);
}