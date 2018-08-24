/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 * Options for the GeoJSON
 *
 * @author tlochmann
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeoJsonOptions implements Options {

    /**
     * @param projection
     */
    @JsProperty
    public native void setDefaultDataProjection(Projection projection);

    /**
     * Projection for features read or written by the format. Options passed 
     * to read or write methods will take precedence.
     * @param projection
     */
    @JsProperty
    public native void setFeatureProjection(Projection projection);
    
    /**
     * @param geometryName
     */
    @JsProperty
    public native void setGeometryName(String geometryName);

}
