package ol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An array with two elements, representing a pixel. The first element is the
 * x-coordinate, the second the y-coordinate of the pixel.
 *
 * @author sbaumhekel
 */
public class Pixel extends JavaScriptObject {

    @Deprecated
    protected Pixel() {
    }

    /**
     * Gets the X-coordinate.
     *
     * @return X-coordinate
     */
    public final native int getX()
    /*-{
    	return this[0];
    }-*/;

    /**
     * Gets the Y-coordinate.
     *
     * @return Y-coordinate
     */
    public final native int getY()
    /*-{
    	return this[1];
    }-*/;

}
