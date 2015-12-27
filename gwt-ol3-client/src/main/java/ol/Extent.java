package ol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An array of numbers representing an extent: `[minx, miny, maxx, maxy]`.
 *
 * @author sbaumhekel
 */
public class Extent extends JavaScriptObject {

    @Deprecated
    protected Extent() {
    }

    /**
     * Constructs an instance.
     *
     * @param minX minimum coordinate X
     * @param minY minimum coordinate Y
     * @param maxX maximum coordinate X
     * @param maxY maximum coordinate Y
     * @return {@link Extent}
     */
    public static native Extent create(double minX, double minY, double maxX, double maxY) /*-{
    	return [ minX, minY, maxX, maxY ];
    }-*/;

    /**
     * Clones this object.
     *
     * @return {ol.Extent} clone
     */
    public final native Extent cloneObject() /*-{
    	return this.slice(0);
    }-*/;

    /**
     * Gets the minimum X coordinate.
     *
     * @return minimum X coordinate.
     */
    public final native double getLowerLeftX() /*-{
    	return this[0];
    }-*/;

    /**
     * Gets the minimum Y coordinate.
     *
     * @return minimum Y coordinate.
     */
    public final native double getLowerLeftY() /*-{
    	return this[1];
    }-*/;

    /**
     * Gets the maximum X coordinate.
     *
     * @return maximum X coordinate.
     */
    public final native double getUpperRightX() /*-{
    	return this[2];
    }-*/;

    /**
     * Gets the maximum Y coordinate.
     *
     * @return maximum Y coordinate.
     */
    public final native double getUpperRightY() /*-{
    	return this[3];
    }-*/;

}
