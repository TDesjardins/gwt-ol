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

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;
import ol.Feature;
import ol.Options;
import ol.proj.Projection;

/**
 * XML feature format.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, name = "XMLFeature")
public abstract class XmlFeature extends ol.format.Feature {

    /**
     * Read a single feature.
     *
     * @param source Document | Node | Object | string
     * @param readOptions Read options.
     * @return feature
     */
    public native Feature readFeature(java.lang.Object source, @Nullable Options readOptions);

    /**
     * Read all features from a feature collection.
     *
     * @param source  source Document | Node | Object | string
     * @return features
     */
    public native Feature[] readFeatures(java.lang.Object source);

    /**
     * Read all features from a feature collection.
     *
     * @param source Document | Node | Object | string
     * @param readOptions Read options.
     * @return features
     */
    public native Feature[] readFeatures(java.lang.Object source, @Nullable Options readOptions);

    /**
     * Read the projection from the source.
     *
     * @param source Document | Node | Object | string
     * @return projection
     */
    public native Projection readProjection(java.lang.Object source);

    /**
     * Encode an array of features as string.
     *
     * @param features features to encode
     * @return features as string
     */
    public native String writeFeatures(Feature[] features);

    /**
     * Encode an array of features as string.
     *
     * @param features features to encode
     * @param options write options
     * @return features as string
     */
    public native String writeFeatures(Feature[] features, Options options);

}
