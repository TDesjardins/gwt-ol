/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol.format;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;
import ol.Feature;
import ol.geom.Geometry;

/**
 * Geometry format for reading and writing data in the WellKnownText (WKT)
 * format.
 *
 * @author Elena Guandalini
 *
 */

/**
 * The {@link Wkt} class is used
 * 
 * for reading and writing data in the WellKnownText (WKT) format.
 * 
 */
@JsType(isNative = true, name = "WKT")
public class Wkt extends TextFeature {

	/**
	 * Constructs a(n) {@link Wkt} object.
	 */
	public Wkt() {};

    public Wkt(WktOptions wktOptions) {}

	/**
	 * Read a feature from a WKT source.
	 * 
	 * @param source
	 * @return feature
	 */
	public native Feature readFeature(java.lang.Object source);
	
	/**
	 * Read a feature from a WKT source.
	 * 
	 * @param source
	 * @param readOptions
	 * @return feature
	 */
	public native Feature readFeature(java.lang.Object source, @Nullable WktReadOptions readOptions);

	/**
	 * Read all features from a WKT source.
	 * 
	 * @param source
	 * @return features
	 */
	public native Feature[] readFeatures(java.lang.Object source);

	/**
	 * Read all features from a WKT source.
	 * 
	 * @param source
	 * @param readOptions
	 * @return features
	 */
	public native Feature[] readFeatures(java.lang.Object source, @Nullable WktReadOptions readOptions);

	/**
	 * Read a single geometry from a WKT source.
	 * 
	 * @param source
	 * @return geometry
	 */
	public native Geometry readGeometry(java.lang.Object source);
	
	/**
	 * Read a single geometry from a WKT source.
	 * 
	 * @param source
	 * @param readOptions
	 * @return geometry
	 */
	public native Geometry readGeometry(java.lang.Object source, @Nullable WktReadOptions readOptions);
	
	/**
	 * Encode a feature as a WKT string.
	 * 
	 * @param feature Feature.
	 * @return WKT string.
	 */
	public native String writeFeature(Feature feature);

	/**
	 * Encode a feature as a WKT string.
	 * 
	 * @param feature Feature.
	 * @param writeOptions Write options.
	 * @return WKT string.
	 */
	public native String writeFeature(Feature feature, @Nullable WktWriteOptions writeOptions);

	/**
	 * Encode an array of features as a WKT string.
	 * 
	 * @param features Features.
	 * @return WKT string.
	 */
	public native String writeFeatures(Feature[] features);

	/**
	 * Encode an array of features as a WKT string.
	 * 
	 * @param features Features.
	 * @param writeOptions Write options.
	 * @return WKT string.
	 */
	public native String writeFeatures(Feature[] features, @Nullable WktWriteOptions writeOptions);

	/**
	 * Write a single geometry as a WKT string.
	 * 
	 * @param geometry Geometry.
	 * @return WKT string.
	 */
	public native String writeGeometry(Geometry geometry);

	/**
	 * Write a single geometry as a WKT string.
	 * 
	 * @param geometry Geometry.
	 * @param writeOptions Write options.
	 * @return WKT string.
	 */
	public native String writeGeometry(Geometry geometry, @Nullable WktWriteOptions writeOptions);

}
