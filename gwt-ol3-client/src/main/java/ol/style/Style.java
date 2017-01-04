package ol.style;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;

import ol.geom.Geometry;

/**
 * Container for vector feature rendering styles. Any changes made to the style
 * or its children through `set*()` methods will not take effect until the
 * feature or layer that uses the style is re-rendered.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public class Style {

    public Style() {}

    public Style(StyleOptions styleOptions) {}

    /**
     * Get the fill style.
     *
     * @return {ol.style.Fill} Fill style.
     */
    @Nullable
    public native Fill getFill();

    /**
     * Get the geometry to be rendered.
     *
     * @return {string|ol.geom.Geometry|ol.style.GeometryFunction} Feature
     *         property or geometry or function that returns the geometry that
     *         will be rendered with this style.
     */
    @Nullable
    public native Geometry getGeometry();

    /**
     * Get the image style.
     *
     * @return {ol.style.Image} Image style.
     */
    public native Image getImage();

    /**
     * Get the stroke style.
     *
     * @return {ol.style.Stroke} Stroke style.
     */
    @Nullable
    public native Stroke getStroke();

    /**
     * Get the text style.
     *
     * @return {ol.style.Text} Text style.
     */
    @Nullable
    public native Text getText();

    /**
     * Get the z-index for the style.
     *
     * @return {number|undefined} ZIndex.
     */
    public native int getZIndex();

    /**
     * Set a geometry that is rendered instead of the feature's geometry.
     *
     * @param geometry
     *            Feature property or geometry or function returning a geometry
     *            to render for this style.
     */
    public native void setGeometry(Geometry geometry);

    /**
     * Set the z-index.
     *
     * @param zIndex
     *            ZIndex.
     */
    public native void setZIndex(int zIndex);

    /**
     * Clones the style.
     */
    public native Style clone();

}
