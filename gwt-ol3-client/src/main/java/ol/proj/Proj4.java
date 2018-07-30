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
package ol.proj;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

/**
 * Class for Proj4 integration.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Proj4 {

    @JsOverlay
    private static final String PACKAGE_PROJ4 = "ol.proj.proj4";

    /**
     * Make projections defined in proj4 (with proj4.defs()) available in OpenLayers.
     * This function should be called whenever changes are made to the proj4 registry, e.g. after calling proj4.defs().
     * Existing transforms will not be modified by this function.
     *
     * @param proj4 Proj4 instance (not typed because of loose coupling)
     */
    @JsMethod(name = "register", namespace = PACKAGE_PROJ4)
    public static native void register(Object proj4);

}
