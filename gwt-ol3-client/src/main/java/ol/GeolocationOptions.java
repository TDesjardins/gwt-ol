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
package ol;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.proj.Projection;

/**
 * {@link ol.Geolocation} options.
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeolocationOptions implements Options {

    /**
     * The projection the position is reported in.
     *
     * @param projection projection
     */
    @JsProperty
    public native void setProjection(Projection projection);

    /**
     * Start Tracking right after instantiation.
     *
     * @param tracking tracking
     */
    @JsProperty
    public native void setTracking(boolean tracking);

    /**
     * @param positionOptions Tracking options
     */
    @JsProperty
    public native void setTrackingOptions(PositionOptions positionOptions);

}
