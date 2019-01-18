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
package proj4;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * see [documentation](https://github.com/proj4js/proj4js).
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Proj4 {

    @JsOverlay
    private static final String PACKAGE_PROJ4 = "proj4";

    /**
     * Registers a proj4 definition by its spatial reference code.
     *
     * @param srid spatial reference code
     * @param proj4Text proj4 definition
     */
    @JsOverlay
    public static final void defs(int srid, String proj4Text) {
        defs("EPSG:" + srid, proj4Text);
    }

    /**
     * Registers a proj4 definition by its spatial reference id.
     *
     * @param srid
     * @param proj4Text proj4 definition
     */
    @JsMethod(name = "defs", namespace = PACKAGE_PROJ4)
    public static native void defs(String srid, String proj4Text);

    /**
     * @return Proj4 instance
     */
    @JsProperty(name = "proj4", namespace = JsPackage.GLOBAL)
    public static native Proj4 get();

    /**
     * Projects from WGS84 to first projection.
     *
     * @param firstProjection
     * @param coordinate coordinate projected in WGS84
     * @return coordinate projected to first projection
     */
    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native Coordinate proj4(String firstProjection, Coordinate coordinate);

    /**
     * Projects from the first projection to the second.
     *
     * @param firstProjection
     * @param secondProjection
     * @param coordinate
     * @return coordinate projected to second projection
     */
    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native Coordinate proj4(String firstProjection, String secondProjection, Coordinate coordinate);

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native Proj4 proj4(String firstProjection);

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native Proj4 proj4(String firstProjection, String secondProjection);

    /**
     * Projects from the first projection to the second.
     *
     * @param coordinate coordinate projected in first projection
     * @return coordinate projected to second projection
     */
    public native Coordinate forward(Coordinate coordinate);

    /**
     * Projects from the second projection to the first.
     *
     * @param coordinate coordinate projected in second projection
     * @return coordinate projected to first projection
     */
    public native Coordinate inverse(Coordinate coordinate);

}
