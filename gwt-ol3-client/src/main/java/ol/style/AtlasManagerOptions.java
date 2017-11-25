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
package ol.style;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * Options for the atlas manager.
 *
 * @author  Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class AtlasManagerOptions implements Options {


    /**
     * The size in pixels of the first atlas image. If no value is given
     * the ol.INITIAL_ATLAS_SIZE compile-time constant will be used.
     *
     * @param initialSize size in pixels of the first atlas image
     */
    @JsProperty
    public native void setInitialSize(int initialSize);

    /**
     * The maximum size in pixels of atlas images. If no value is given
     * then the ol.MAX_ATLAS_SIZE compile-time constant will be used.
     * And if ol.MAX_ATLAS_SIZE is set to -1 (the default) then
     * ol.WEBGL_MAX_TEXTURE_SIZE will used if WebGL is supported.
     * Otherwise 2048 is used.
     * 
     * @param maxSize maximum size in pixels of atlas images
     */
    @JsProperty
    public native void setMaxSize(int maxSize);

    /**
     * The space in pixels between images (default: 1).
     *
     * @param space space in pixels
     */
    @JsProperty
    public native void setSpace(int space);

}
