/*******************************************************************************
 * Copyright 2017, 2018 gwt-ol3
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
import jsinterop.annotations.JsType;

/**
 * @author Daniel Eggert (daniel.eggert@gfz-potsdam.de)
 */
@JsType(isNative = true)
public class ImageData extends elemental2.dom.ImageData {

    ImageData(double dataOrWidth, double widthOrHeight) {
        super(dataOrWidth, widthOrHeight);
    }

    @JsOverlay
    private static final int NUM_CHANNELS = 4;

    @JsOverlay
    public final PixelColor getPixel(int x, int y, PixelColor color) {
        if (x > -1 && x < width && y > -1 && y < height) {
            int offset = (y * width + x) * NUM_CHANNELS;
            for (int c = 0; c < NUM_CHANNELS; ++c) {
                color.setAt(c, data.getAt(offset + c));
            }
        }

        return color;
    }

    @JsOverlay
    public final void putPixel(int x, int y, PixelColor color) {
        if (x > -1 && x < width && y > -1 && y < height) {
            int offset = (y * width + x) * NUM_CHANNELS;
            for (int c = 0; c < NUM_CHANNELS; ++c) {
                data.setAt(offset + c, color.getAt(c));
            }
        }
    }

}
