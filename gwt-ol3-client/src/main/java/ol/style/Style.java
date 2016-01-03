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
public interface Style {
    /**
     * Get the fill style.
     *
     * @return {ol.style.Fill} Fill style.
     */
    @Nullable
    Fill getFill();

    /**
     * Get the geometry to be rendered.
     *
     * @return {string|ol.geom.Geometry|ol.style.GeometryFunction} Feature
     *         property or geometry or function that returns the geometry that
     *         will be rendered with this style.
     */
    @Nullable
    Geometry getGeometry();

    /**
     * Get the image style.
     * 
     * @return {ol.style.Image} Image style.
     */
    Image getImage();

    /**
     * Get the stroke style.
     *
     * @return {ol.style.Stroke} Stroke style.
     */
    @Nullable
    Stroke getStroke();

    /**
     * Get the text style.
     *
     * @return {ol.style.Text} Text style.
     */
    @Nullable
    Text getText();

    /**
     * Get the z-index for the style.
     *
     * @return {number|undefined} ZIndex.
     */
    int getZIndex();

    /**
     * Set a geometry that is rendered instead of the feature's geometry.
     *
     * @param geometry
     *            Feature property or geometry or function returning a geometry
     *            to render for this style.
     */
    void setGeometry(Geometry geometry);

    /**
     * Set the z-index.
     *
     * @param zIndex
     *            ZIndex.
     */
    void setZIndex(int zIndex);

}
