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
package ol;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * An array of numbers representing a size: `[width, height]`.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true, name = "Array", namespace = JsPackage.GLOBAL)
public class Size implements JsArrayLike<Double> {

    /**
     * @param width width
     * @param height height
     */
    public Size(int width, int height) {
    }

    /**
     * Clones this object.
     *
     * @return {ol.Size} clone
     */
    @JsOverlay
    public final Size cloneObject() {
        return this.slice(0);
    };

    private native Size slice(int begin);

    /**
     * Gets the height.
     *
     * @return height
     */
    @JsOverlay
    public final int getHeight() {
        if (this.getLength() > 1) {
            return this.getAt(1).intValue();
        }
        return -1;
    };

    /**
     * Gets the width.
     *
     * @return width
     */
    @JsOverlay
    public final int getWidth() {
        if (this.getLength() > 0) {
            return this.getAt(0).intValue();
        }
        return -1;
    };

}
