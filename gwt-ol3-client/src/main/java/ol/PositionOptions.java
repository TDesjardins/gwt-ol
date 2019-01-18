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

/**
 * Geolocation API position options
 * See http://www.w3.org/TR/geolocation-API/#position_options_interface.
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PositionOptions implements Options {

    /**
     * Attribute provides a hint that the application would like to receive the best
     * possible results.
     *
     * @param enableHighAccuracy
     */
    @JsProperty
    public native void setEnableHighAccuracy(boolean enableHighAccuracy);

    /**
     * Maximum length of time (expressed in milliseconds) that is allowed to pass from
     * the call to getCurrentPosition() or watchPosition() until the corresponding
     * successCallback is invoked.
     *
     * @param timeout timeout
     */
    @JsProperty
    public native void setTimeout(double timeout);

    /**
     * The attribute indicates that the application is willing to accept a cached position
     * whose age is no greater than the specified time in milliseconds.
     *
     * @param maximumAge maximum age
     */
    @JsProperty
    public native void setMaximumAge(double maximumAge);

}
