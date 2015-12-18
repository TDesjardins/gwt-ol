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
     * Clones this object.
     *
     * @return {ol.Size} clone
     */
    public final native Size cloneObject() /*-{
    	return this.slice(0);
    }-*/;

    /**
     * Gets the height.
     *
     * @return height
     */
    public final native int getHeight() /*-{
    	return this[1];
    }-*/;

    /**
     * Gets the width.
     *
     * @return width
     */
    public final native int getWidth() /*-{
    	return this[0];
    }-*/;

}
