package ol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An array of numbers representing a size: `[width, height]`.
 *
 * @author sbaumhekel
 */
public class Size extends JavaScriptObject {

    @Deprecated
    protected Size() {
    }

    /**
     * Gets the height.
     *
     * @return height
     */
    public final native int getHeight()
    /*-{
		return this[1];
    }-*/;

    /**
     * Gets the width.
     *
     * @return width
     */
    public final native int getWidth()
    /*-{
		return this[0];
    }-*/;

}
