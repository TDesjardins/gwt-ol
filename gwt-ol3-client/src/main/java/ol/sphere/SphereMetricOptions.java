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
package ol.sphere;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 * Options for {@link ol.sphere.Sphere} methods.
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SphereMetricOptions implements Options {

    /**
     * @param projection Projection of the geometry. By default, the geometry is assumed to be in Web Mercator.
     */
    @JsProperty
    public native void setProjection(Projection projection);

    /**
     * @param radius Sphere radius. By default, the radius of the earth is used (Clarke 1866 Authalic Sphere).
     */
    @JsProperty
    public native void setRadius(double radius);

}
