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
import ol.Options;
import ol.Feature;
import ol.proj.Projection;
import javax.annotation.Nullable;

/**
 * GPX feature format.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, name = "GPX")
public class Gpx extends XmlFeature {

    public Gpx() {}

    /**
     * Read the projection from a GPX source.
     * @param source Document | Node | Object | string
     * @return projection
     */
    public native Projection readProjection(java.lang.Object source);

    /**
     * Read a feature from a GPX Feature source. Only works for Feature, use readFeatures to read FeatureCollection
     * source.
     * @param source Document | Node | Object | string
     * @param readOptions Read options.
     * @return feature
     */
    public native Feature readFeature(java.lang.Object source, @Nullable Options readOptions);

    public native Feature[] readFeatures(java.lang.Object source);

    /**
     * Read all features from a GPX source. Works with both Feature and FeatureCollection sources.
     * @param source Document | Node | Object | string
     * @param readOptions Read options.
     * @return [] {@link Feature}
     */
    public native Feature[] readFeatures(java.lang.Object source, @Nullable Options readOptions);

}
