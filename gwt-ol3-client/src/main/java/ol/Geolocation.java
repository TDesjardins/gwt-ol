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

import jsinterop.annotations.JsType;
import ol.geom.Polygon;
import ol.proj.Projection;

/**
 * Helper class for providing HTML5 Geolocation capabilities. The
 * Geolocation API is used to locate a user's position.
 * To get notified of position changes, register a listener for the
 * generic change event on your instance of {@link ol.Geolocation}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Geolocation extends Object {

    public Geolocation() {}

    public Geolocation(GeolocationOptions options) {}

    /**
     * @return accuracy of the position in meters.
     */
    public native double getAccuracy();

    /**
     * @return geometry of the position accuracy.
     */
    public native Polygon getAccuracyGeometry();

    /**
     * @return altitude associated with the position.
     */
    public native double getAltitude();

    /**
     * @return altitude accuracy of the position.
     */
    public native double getAltitudeAccuracy();

    /**
     * @return the heading as radians clockwise from North.
     * Note: depending on the browser, the heading is only
     * defined if the enableHighAccuracy is set to true in
     * the tracking options.
     */
    public native double getHeading();

    /**
     * @return the position of the device.
     */
    public native Coordinate getPosition();

    /**
     * @return the projection the position is reported in 
     */
    public native Projection getProjection();

    /**
     * @return the instantaneous speed of the device in meters per second.
     */
    public native double getSpeed();

    /**
     * @return if the device location is being tracked.
     */
    public native boolean getTracking();

    /**
     * @return tracking options. See http://www.w3.org/TR/geolocation-API/#position-options.
     */
    public native PositionOptions getTrackingOptions();

    /**
     * @param tracking if the device location is being tracked.
     */
    public native void setTracking(boolean tracking);

}
