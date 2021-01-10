/*******************************************************************************
 * Copyright 2014, 2020 gwt-ol
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
package ol.style;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;
import ol.Feature;
import ol.GenericFunction;
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
     * @param fill Fill style
     */
    @Nullable
    public native void setFill(Fill fill);

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
     * Set the image style.
     *
     * @param image image style
     */
    public native void setImage(Image image);

    /**
     * Get the stroke style.
     *
     * @return {ol.style.Stroke} Stroke style.
     */
    @Nullable
    public native Stroke getStroke();

    /**
     * @param stroke Stroke style
     */
    @Nullable
    public native void setStroke(Stroke stroke);

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
     * Set a geometry function which result is rendered instead of the feature's geometry.
     *
     * @param geometry function returning a geometry
     *            to render for this style.
     */
    public native void setGeometry(GenericFunction<Feature, Geometry> geometryFunction);

    /**
     * Custom renderer. When configured, fill, stroke and image will be ignored, and the
     * provided function will be called with each render frame for each geometry.
     *
     * @param renderFunction Custom renderer
     */
    public native void setRenderer(RenderFunction renderFunction);

    /**
     * @param text text style
     */
    public native void setText(Text text);

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
