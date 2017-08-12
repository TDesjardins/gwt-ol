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
package ol.source;

import jsinterop.annotations.JsFunction;
import ol.Image;

/**
 * A function that takes an ol.Image for the image and a {string} for the src as arguments. It is supposed to make it so the underlying image ol.Image#getImage
 * is assigned the content specified by the src. If not specified, the default is
 * 
 * @author Peter Zanetti
 */
@FunctionalInterface
@JsFunction
public interface ImageLoadFunction {

    public void loadImage(Image image, String src);
}
