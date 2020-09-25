/*******************************************************************************
 * Copyright 2014, 2020 gwt-ol
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

import jsinterop.annotations.JsType;
import ol.color.Color;

/**
 * Set icon style for vector features.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Icon extends Image {

    public Icon() {}

    public Icon(IconOptions iconOptions) {}

    /**
     * Load not yet loaded URI. When rendering a feature with an icon style,
     * the vector renderer will automatically call this method. However, you
     * might want to call this method yourself for preloading or other purposes.
     */
    public native void load();

    /**
     * @return the icon color.
     */
    public native Color getColor();

    /**
     * @param pixelRatio Pixel ratio.
     * @return the pixel ration of the image.
     */
    public native double getPixelRatio(double pixelRatio);

    /**
     * @return the image URL.
     */
    public native String getSrc();

}
