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
package ol.style;

import jsinterop.annotations.JsType;

/**
 * A base class used for creating subclasses and not instantiated in
 * apps. Base class for {@link ol.style.Icon}, {@link ol.style.Circle} and
 * {@link ol.style.RegularShape}.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public abstract class Image {

    /**
     * @return Opacity of the image. Default is 1.
     */
    public native double getOpacity();

    /**
     * @return Whether to rotate the icon with the view. Default is false.
     */
    public native boolean getRotateWithView();

    /**
     * @return Rotation in radians (positive rotation clockwise). Default is 0.
     */
    public native double getRotation();

    /**
     * @return Scale. Default is 1.
     */
    public native double getScale();

    /**
     * @param opacity Opacity of the image. Default is 1.
     */
    public native void setOpacity(double opacity);

    /**
     * @param rotation Rotation in radians (positive rotation clockwise).
     * Default is 0.
     */
    public native void setRotation(double rotation);

    /**
     * @param scale Scale. Default is 1.
     */
    public native void setScale(double scale);

}
