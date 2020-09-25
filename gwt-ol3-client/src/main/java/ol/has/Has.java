/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
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
package ol.has;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 */
@JsType(isNative = true)
public class Has {

    @JsOverlay
    private static final String PACKAGE_HAS = "ol.has";

    /**
     * @return The ratio between physical pixels and device-independent pixels (dips) on the device (window.devicePixelRatio).
     */
    @JsProperty(name = "DEVICE_PIXEL_RATIO", namespace = PACKAGE_HAS)
    public static native double getDevicePixelRatio();

}
