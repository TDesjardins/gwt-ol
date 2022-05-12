/*******************************************************************************
 * Copyright 2014, 2022 gwt-ol
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
import ol.Feature;
import ol.Options;
import ol.geom.Geometry;
import ol.proj.Projection;

import javax.annotation.Nullable;

/**
 * Geometry format for reading and writing data in the Well-Known Binary (WKB) format. Also supports
 * Extended Well-Known Binary (EWKB) format, used in PostGIS for example.
 *
 * @author T. Desjardins
 */
@JsType(isNative = true, name = "WKB")
public class Wkb extends ol.format.Feature {

    public Wkb() {}

    public Wkb(WkbOptions wkbOptions) {}

    /**
     * Read the projection from a WKB source.
     * @param source Document | Node | Object | string
     * @return projection
     */
    public native Projection readProjection(java.lang.Object source);

    /**
     * Read a feature from a WKB Feature source. Only works for Feature, use readFeatures to read FeatureCollection
     * source.
     *
     * @param source Document | Node | Object | string
     * @return feature
     */
    public native Feature readFeature(java.lang.Object source);

    /**
     * Read a feature from a WKB Feature source. Only works for Feature, use readFeatures to read FeatureCollection
     * source.
     *
     * @param source Document | Node | Object | string
     * @param readOptions Read options.
     * @return feature
     */
    public native Feature readFeature(java.lang.Object source, @Nullable Options readOptions);

    /**
     * Read all features from a source.
     * 
     * @param source string | ArrayBuffer | ArrayBufferView
     * @return features
     */
    public native Feature[] readFeatures(java.lang.Object source);

    /**
     * Read all features from a source.
     * 
     * @param source string | ArrayBuffer | ArrayBufferView
     * @param readOptions Read options.
     * @return features
     */
    public native Feature[] readFeatures(java.lang.Object source, @Nullable Options readOptions);

    /**
     * Read a single geometry from a source.
     *
     * @param source string | ArrayBuffer | ArrayBufferView
     * @param readOptions Read options.
     * @return geometry
     */
    public native Geometry readGeometry(java.lang.Object source, @Nullable Options readOptions);

    /**
     * Encode a feature in this format.
     *
     * @param feature ol.Feature
     * @return encoded feature
     */
    public native String writeFeature(Feature feature);

    /**
     * Encode a feature in this format.
     *
     * @param feature ol.Feature
     * @param writeOptions Write options.
     * @return encoded feature
     */
    public native String writeFeature(Feature feature, @Nullable Options writeOptions);

    /**
     * Encode an array of features in this format.
     *
     * @param feature ol.Feature
     * @param writeOptions Write options.
     * @return WKB string
     */
    public native String writeFeatures(Feature[] feature, @Nullable Options writeOptions);

    /**
     * Write a single geometry in this format.
     *
     * @param geometry {@link Geometry }
     * @return encoded geometry
     */
    public native String writeGeometry(Geometry geometry);

    /**
     * Write a single geometry in this format.
     *
     * @param geometry {@link Geometry }
     * @param writeOptions Write options.
     * @return encoded geometry
     */
    public native String writeGeometry(Geometry geometry, @Nullable Options writeOptions);

}
