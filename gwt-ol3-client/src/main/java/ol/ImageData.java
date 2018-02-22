/**
 * 
 */
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
