/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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

import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.Options;
import ol.geom.Geometry;
import ol.proj.Projection;

import javax.annotation.Nullable;

/**
 * Feature format for reading and writing data in the GeoJSON format.
 * @author tlochmann
 */
@JsType(isNative = true, name = "GeoJSON")
public class GeoJson extends JsonFeature {

    public GeoJson() {}

    public GeoJson(GeoJsonOptions geoJsonOptions) {}

    /**
     * Read the projection from a GeoJSON source.
     * @param source Document | Node | Object | string
     * @return projection
     */
    public native Projection readProjection(java.lang.Object source);

    /**
     * Read a feature from a GeoJSON Feature source. Only works for Feature, use readFeatures to read FeatureCollection
     * source.
     * @param source Document | Node | Object | string
     * @param readOptions Read options.
     * @return feature
     */
    public native Feature readFeature(java.lang.Object source, @Nullable Options readOptions);

    public native Feature[] readFeatures(java.lang.Object source);

    /**
     * Read all features from a GeoJSON source. Works with both Feature and FeatureCollection sources.
     * @param source Document | Node | Object | string
     * @param readOptions Read options.
     * @return features
     */
    public native Feature[] readFeatures(java.lang.Object source, @Nullable Options readOptions);

    /**
     * Read a geometry from a GeoJSON source.
     * @param source Document | Node | Object | string
     * @param readOptions Read options.
     * @return geometry
     */
    public native Geometry readGeometry(java.lang.Object source, @Nullable Options readOptions);

    /**
     * Encode a feature as a GeoJSON Feature string.
     * @param feature ol.Feature
     * @param writeOptions Write options.
     * @return GeoJSON Feature string
     */
    public native String writeFeature(Feature feature, @Nullable Options writeOptions);

    /**
     * Encode a feature as a GeoJSON Feature object.
     * @param feature ol.Feature
     * @param writeOptions Write options.
     * @return GeoJSON feature object
     */
    public native java.lang.Object writeFeatureObject(Feature feature, @Nullable Options writeOptions);

    /**
     * Encode an array of features as GeoJSON.
     * @param feature ol.Feature
     * @param writeOptions Write options.
     * @return GeoJSON string
     */
    public native String writeFeatures(Feature feature, @Nullable Options writeOptions);

    /**
     * Encode an array of features as GeoJSON.
     * @param feature ol.Feature
     * @param writeOptions Write options.
     * @return GeoJSON objects
     */
    public native Collection<java.lang.Object> writeFeaturesObject(Feature feature, @Nullable Options writeOptions);

    /**
     * Encode a geometry as a GeoJSON string.
     * @param geometry {@link Geometry }
     * @param writeOptions Write options.
     * @return GeoJSON string
     */
    public native String writeGeometry(Geometry geometry, @Nullable Options writeOptions);

    /**
     * Encode a geometry as a GeoJSON object.
     * @param geometry {@link Geometry }
     * @param writeOptions Write options.
     * @return GeoJSON objects
     */
    public native Collection<GeoJson> writeGeometryObject(Geometry geometry, @Nullable Options writeOptions);

}
