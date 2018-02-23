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
package ol;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * An array with four elements, representing the color channels [rgba] of a pixel.
 *
 * @author Daniel Eggert (daniel.eggert@gfz-potsdam.de)
 */
@JsType(isNative = true, name = "Array", namespace = JsPackage.GLOBAL)
public class PixelColor implements JsArrayLike<Double> {

    /**
     * @param r red
     * @param g green
     * @param b blue
     * @param a alpha
     */
    public PixelColor(int r, int g, int b, int a) {
    }

    /**
     * Clones this object.
     *
     * @return {ol.Pixel} clone
     */
    @JsOverlay
    public final PixelColor cloneObject() {
        return this.slice(0);
    };

    private native PixelColor slice(int begin);

    /**
     * Gets the red value.
     *
     * @return red
     */
    @JsOverlay
    public final int getRed() {
        if (this.getLength() > 0) {
            return this.getAt(0).intValue();
        }
        return -1;
    }

    /**
     * Gets the green value.
     *
     * @return green
     */
    @JsOverlay
    public final int getGreen() {
        if (this.getLength() > 1) {
            return this.getAt(1).intValue();
        }
        return -1;
    }

    /**
     * Gets the blue value.
     *
     * @return blue
     */
    @JsOverlay
    public final int getBlue() {
        if (this.getLength() > 2) {
            return this.getAt(2).intValue();
        }
        return -1;
    }

    /**
     * Gets the alpha value.
     *
     * @return alhpa
     */
    @JsOverlay
    public final int getAlpha() {
        if (this.getLength() > 3) {
            return this.getAt(3).intValue();
        }
        return -1;
    }

    /**
     * Sets the red value.
     *
     * @return red
     */
    @JsOverlay
    public final void setRed(int value) {
        if (this.getLength() > 0) {
            this.setAt(0, Math.min(255.0, Math.max(0.0, value)));
        }
    }

    /**
     * Sets the green value.
     *
     * @return green
     */
    @JsOverlay
    public final void setGreen(int value) {
        if (this.getLength() > 1) {
            this.setAt(1, Math.min(255.0, Math.max(0.0, value)));
        }
    }

    /**
     * Sets the blue value.
     *
     * @return blue
     */
    @JsOverlay
    public final void setBlue(int value) {
        if (this.getLength() > 2) {
            this.setAt(2, Math.min(255.0, Math.max(0.0, value)));
        }
    }

    /**
     * Sets the alpha value.
     *
     * @return alhpa
     */
    @JsOverlay
    public final void setAlpha(int value) {
        if (this.getLength() > 3) {
            this.setAt(3, Math.min(255.0, Math.max(0.0, value)));
        }
    }

    /**
     * Returns the value of the given channel.
     * 
     * @param index
     */
    @JsOverlay
    public final int getChannel(int index) {
        if (this.getLength() > index) {
            return this.getAt(index).intValue();
        }
        return -1;
    }

    /**
     * Sets the value of the given channel.
     * 
     * @param index
     * @param value
     */
    @JsOverlay
    public final void setChannel(int index, int value) {
        if (this.getLength() > index) {
            this.setAt(index, Math.min(255.0, Math.max(0.0, value)));
        }
    }

    /**
     * Clears the pixel's color by setting all channels to 0
     */
    @JsOverlay
    public final void clear() {
        for (int i = 0; i < this.getLength(); ++i) {
            this.setAt(i, 0.0);
        }
    }

}
