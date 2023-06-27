/*******************************************************************************
 * Copyright 2014, 2023 gwt-ol
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
package ol.loadingstrategy;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;


@JsType(isNative = true)
public class LoadingStrategy {

    @JsOverlay
    private static final String PACKAGE_LOADING_STRATEGY = "ol.loadingstrategy";

    /**
     * @return Strategy function for loading all features with a single request.
     */
    @JsProperty(name = "all", namespace = PACKAGE_LOADING_STRATEGY)
    public static native LoadingStrategyFunction getAll();

    /**
     * @return Strategy function for loading features based on the view's extent and
     * resolution.
     */
    @JsProperty(name = "bbox", namespace = PACKAGE_LOADING_STRATEGY)
    public static native LoadingStrategyFunction getBbox();

}
