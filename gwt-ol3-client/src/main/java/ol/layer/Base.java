package ol.layer;

import jsinterop.annotations.JsType;
import ol.Extent;
import ol.Object;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. Note that with `ol.layer.Base` and all its subclasses,
 * any property set in the options is set as a {@link ol.Object} property on the
 * layer object, so is observable, and has get/set accessors.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Base extends Object {

    /**
     * Return the {@link ol.Extent extent} of the layer or `undefined` if it
     * will be visible regardless of extent.
     * @return {ol.Extent|undefined} The layer extent.
     */
    public native Extent getExtent();

    /**
     * Return the maximum resolution of the layer.
     * @return {number} The maximum resolution of the layer.
     */
    public native double getMaxResolution();

    /**
     * Return the minimum resolution of the layer.
     * @return {number} The minimum resolution of the layer.
     */
    public native double getMinResolution();

    /**
     * Return the opacity of the layer (between 0 and 1).
     * @return {number} The opacity of the layer.
     */
    public native double getOpacity();

    /**
     * Return the visibility of the layer (`true` or `false`).
     * @return {boolean} The visibility of the layer.
     */
    public native boolean getVisible();

    /**
     * Return the Z-index of the layer, which is used to order layers before
     * rendering. The default Z-index is 0.
     *
     * @return {number} The Z-index of the layer.
     */
    public native int getZIndex();

    /**
     * Set the extent at which the layer is visible. If `undefined`, the layer
     * will be visible at all extents.
     * @param extent
     *            The extent of the layer.
     */
    public native void setExtent(ol.Extent extent);

    /**
     * Set the maximum resolution at which the layer is visible.
     * @param maxResolution
     *            The maximum resolution of the layer.
     */
    public native void setMaxResolution(double maxResolution);

    /**
     * Set the minimum resolution at which the layer is visible.
     * @param minResolution
     *            The minimum resolution of the layer.
     */
    public native void setMinResolution(double minResolution);

    /**
     * Set the opacity of the layer, allowed values range from 0 to 1.
     * @param opacity
     *            The opacity of the layer.
     */
    public native void setOpacity(double opacity);

    /**
     * Set the visibility of the layer (`true` or `false`).
     * @param visible
     *            The visibility of the layer.
     */
    public native void setVisible(boolean visible);

    /**
     * Set Z-index of the layer, which is used to order layers before rendering.
     * The default Z-index is 0.
     *
     * @param zindex
     *            The z-index of the layer.
     */
    public native void setZIndex(int zindex);

}
