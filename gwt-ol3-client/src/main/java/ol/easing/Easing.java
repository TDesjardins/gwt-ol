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
package ol.easing;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Markus Brigl (markus.brigl@tol.info)
 */
@JsType(isNative = true)
public class Easing {

    @JsOverlay
    private static final String PACKAGE_EASING = "ol.easing";

    @JsProperty(name = "easeIn", namespace = PACKAGE_EASING)
    public static native EasingOperation easeIn();

    @JsProperty(name = "easeOut", namespace = PACKAGE_EASING)
    public static native EasingOperation easeOut();

    @JsProperty(name = "inAndOut", namespace = PACKAGE_EASING)
    public static native EasingOperation inAndOut();

    @JsProperty(name = "linear", namespace = PACKAGE_EASING)
    public static native EasingOperation linear();

    @JsProperty(name = "upAndDown", namespace = PACKAGE_EASING)
    public static native EasingOperation upAndDown();
}
