package ol.color;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A color represented as a short array [red, green, blue, alpha]. red, green,
 * and blue should be integers in the range 0..255 inclusive. alpha should be a
 * float in the range 0..1 inclusive.
 *
 * @author sbaumhekel
 */
public class Color extends JavaScriptObject {

    @Deprecated
    protected Color() {
    }

    /**
     * Gets the alpha value.
     *
     * @return alpha value (0-1)
     */
    public final native float getAlpha() /*-{
		return this[3];
    }-*/;

    /**
     * Gets the blue value.
     *
     * @return blue value (0-255)
     */
    public final native int getBlue() /*-{
		return this[2];
    }-*/;

    /**
     * Gets the green value.
     *
     * @return green value (0-255)
     */
    public final native int getGreen() /*-{
		return this[1];
    }-*/;

    /**
     * Gets the red value.
     *
     * @return red value (0-255)
     */
    public final native int getRed() /*-{
		return this[0];
    }-*/;

}
