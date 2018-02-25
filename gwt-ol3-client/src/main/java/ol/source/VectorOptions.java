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
package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Collection;
import ol.Feature;

/**
 * Vector source options.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class VectorOptions extends SourceOptions {

    /**
     * Set the features. If provided as {@link ol.Collection}, the features in
     * the source and the collection will stay in sync.
     *
     * @param features features
     */
    @JsProperty
    public native void setFeatures(Feature[] features);

    @JsProperty
    public native void setUrl(String url);

    @JsProperty
    public native void setFormat(ol.format.Feature format);

    @JsProperty
    public native void setFeatures(Collection<Feature> features);

    /**
     *
     * By default, an RTree is used as spatial index. When features are removed
     * and added frequently, and the total number of features is low, setting
     * this to false may improve performance. Note that
     * ol.source.Vector#getFeaturesInExtent,
     * ol.source.Vector#getClosestFeatureToCoordinate and
     * ol.source.Vector#getExtent cannot be used when useSpatialIndex is set to
     * false, and ol.source.Vector#forEachFeatureInExtent will loop through all
     * features. When set to false, the features will be maintained in an
     * ol.Collection, which can be retrieved through
     * ol.source.Vector#getFeaturesCollection. The default is true.
     *
     * @param useSpatialIndex use spatial index?
     */
    @JsProperty
    public native void setUseSpatialIndex(boolean useSpatialIndex);

    /**
     * Wrap the world horizontally. Default is true. For vector editing across
     * the -180° and 180° meridians to work properly, this should be set to
     * false. The resulting geometry coordinates will then exceed the world
     * bounds.
     * 
     * @param wrapX wrap?
     */
    @JsProperty
    public native void setWrapX(boolean wrapX);

}
