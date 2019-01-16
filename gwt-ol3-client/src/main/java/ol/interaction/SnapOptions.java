/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol3
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

package ol.interaction;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.Options;
import ol.source.Vector;

/**
 * @author guandalini
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SnapOptions implements Options {

    /**
     * Snap to these features. Either this option or source should be provided.
     *
     * @param features
     */
    @JsProperty
    public native void setFeatures(Collection<Feature> features);

    /**
     * Snap to edges. Default is true.
     *
     * @param edge
     */
    @JsProperty
    public native void setEdge(boolean edge);

    /**
     * Snap to vertices. Default is true.
     *
     * @param vertex
     */
    @JsProperty
    public native void setVertex(boolean vertex);

    /**
     * Pixel tolerance for considering the pointer close enough to a segment or
     * vertex for snapping. Default is 10 pixels.
     *
     * @param tolerance
     */
    @JsProperty
    public native void setPixelTolerance(double tolerance);

    /**
     * Snap to features from this source. Either this option or features should be
     * provided
     *
     * @param source
     */
    @JsProperty
    public native void setSource(Vector source);

}
