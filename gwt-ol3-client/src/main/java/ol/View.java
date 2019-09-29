/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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
package ol;

import com.google.gwt.event.shared.HandlerRegistration;

import javax.annotation.Nullable;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import ol.animation.AnimationOptions;
import ol.event.EventListener;
import ol.proj.Projection;

/**
 * An ol.View object represents a simple 2D view of the map.
 *
 * This is the object to act upon to change the center, resolution, and rotation
 * of the map.
 *
 * ### The view states
 *
 * An `ol.View` is determined by three states: `center`, `resolution`, and
 * `rotation`. Each state has a corresponding getter and setter, e.g.
 * `getCenter` and `setCenter` for the `center` state.
 *
 * An `ol.View` has a `projection`. The projection determines the coordinate
 * system of the center, and its units determine the units of the resolution
 * (projection units per pixel). The default projection is Spherical Mercator
 * (EPSG:3857).
 *
 * ### The constraints
 *
 * `setCenter`, `setResolution` and `setRotation` can be used to change the
 * states of the view. Any value can be passed to the setters. And the value
 * that is passed to a setter will effectively be the value set in the view, and
 * returned by the corresponding getter.
 *
 * But an `ol.View` object also has a *resolution constraint*, a *rotation
 * constraint* and a *center constraint*.
 *
 * As said above, no constraints are applied when the setters are used to set
 * new states for the view. Applying constraints is done explicitly through the
 * use of the `constrain*` functions (`constrainResolution` and
 * `constrainRotation` and `constrainCenter`).
 *
 * The main users of the constraints are the interactions and the controls. For
 * example, double-clicking on the map changes the view to the "next"
 * resolution. And releasing the fingers after pinch-zooming snaps to the
 * closest resolution (with an animation).
 *
 * The *resolution constraint* snaps to specific resolutions. It is determined
 * by the following options: `resolutions`, `maxResolution`, `maxZoom`, and
 * `zoomFactor`. If `resolutions` is set, the other three options are ignored.
 * See documentation for each option for more information.
 *
 * The *rotation constraint* snaps to specific angles. It is determined by the
 * following options: `enableRotation` and `constrainRotation`. By default the
 * rotation value is snapped to zero when approaching the horizontal.
 *
 * The *center constraint* is determined by the `extent` option. By default the
 * center is not constrained at all.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public class View extends Object {

    public View() {}

    public View(ViewOptions viewOptions) {}

    @JsOverlay
    public final HandlerRegistration addCenterChangeListener(final EventListener<Event> listener) {
        return OLUtil.observe(this, "change:center", listener);
    }

    @JsOverlay
    public final HandlerRegistration addResolutionChangeListener(final EventListener<Event> listener) {
        return OLUtil.observe(this, "change:resolution", listener);
    }

    @JsOverlay
    public final HandlerRegistration addRotationChangeListener(final EventListener<Event> listener) {
        return OLUtil.observe(this, "change:rotation", listener);
    }

    /**
     * Animates the view.
     *
     * @param animationOptions
     */
    public native void animate(AnimationOptions... animationOptions);

    /**
     * Cancel any ongoing animations.
     */
    public native void cancelAnimations();

    /**
     * Center on coordinate and view position.
     *
     * @param coordinate Coordinate.
     * @param size Box pixel size.
     * @param position Position on the view to center on.
     */
    public native void centerOn(Coordinate coordinate, Size size, Pixel position);

    /**
     * Fit the given extent based on the given map size and border.
     * The size is pixel dimensions of the box to fit the extent into. In most
     * cases you will want to use the map size, that is `map.getSize()`. Takes
     * care of the map angle.
     *
     * @param extent {ol.Extent} extent.
     */
    public native void fit(ol.Extent extent);

    /**
     * Fit the given geometry based on the given map size and border.
     * The size is pixel dimensions of the box to fit the extent into. In most
     * cases you will want to use the map size, that is `map.getSize()`. Takes
     * care of the map angle.
     *
     * @param geometry {ol.geom.SimpleGeometry} geometry.
     */
    public native void fit(ol.geom.SimpleGeometry geometry);

    /**
     * Fit the given extent on the given map size and border.
     * The size is pixel dimensions of the box to fit the extent into. In most
     * cases you will want to use the map size, that is `map.getSize()`. Takes
     * care of the map angle.
     *
     * @param extent
     *            {ol.Extent} extent.
     * @param opt_options
     *            options
     */
    public native void fit(ol.Extent extent, ViewFitOptions opt_options);

    /**
     * Fit the given geometry on the given map size and border.
     * The size is pixel dimensions of the box to fit the extent into. In most
     * cases you will want to use the map size, that is `map.getSize()`. Takes
     * care of the map angle.
     *
     * @param geometry
     *            {ol.geom.SimpleGeometry} geometry.
     * @param opt_options
     *            options
     */
    public native void fit(ol.geom.SimpleGeometry geometry, ViewFitOptions opt_options);

    /**
     * @return if the view is being animated.
     */
    public native boolean getAnimating();

    /**
     * Get the view center.
     *
     * @return the center of the view.
     */
    public native Coordinate getCenter();

    /**
     * @return if the user is interacting with the view, such as panning or zooming.
     */
    public native boolean getInteracting();

    /**
     * Get the maximum resolution of the view.
     * @return The maximum resolution of the view.
     */
    public native double getMaxResolution();

    /**
     * Get the maximum zoom level for the view.
     * @return The maximum zoom level.
     */
    public native double getMaxZoom();

    /**
     * Get the minimum resolution of the view.
     * @return The minimum resolution of the view.
     */
    public native double getMinResolution();

    /**
     * Get the minimum zoom level for the view.
     * @return The minimum zoom level.
     */
    public native double getMinZoom();

    /**
     * Get the view projection.
     *
     * @return the projection of the view.
     */
    public native Projection getProjection();

    /**
     * Get the view resolution.
     *
     * @return The resolution of the view.
     */
    public native double getResolution();

    /**
     * Get the resolution for a provided extent (in map units) and size (in pixels).
     *
     * @param extent Extent.
     * @return the resolution at which the provided extent will render at the given size.
     */

    /**
     * Get the resolution for a zoom level.
     *
     * @param zoom Zoom level.
     * @return the view resolution for the provided zoom level.
     */
    public native double getResolutionForZoom(double zoom);

    /**
     * Get the resolution for a provided extent (in map units) and size (in pixels).
     *
     * @param extent Extent.
     * @return the resolution at which the provided extent will render at the given size.
     */
    public native double getResolutionForExtent(Extent extent);

    /**
     * Get the resolution for a provided extent (in map units) and size (in pixels).
     *
     * @param extent Extent.
     * @param size Box pixel size.
     * @return the resolution at which the provided extent will render at the given size.
     */
    public native double getResolutionForExtent(Extent extent, Size size);

    /**
     * Get the view rotation.
     *
     * @return The rotation of the view in radians.
     */
    public native double getRotation();

    /**
     * Get the current zoom level. Return undefined if the current resolution is
     * undefined or not within the "resolution constraints".
     * @return Zoom.
     */
    public native double getZoom();

    /**
     * Get the zoom level for a resolution.
     * @param resolution
     *            The resolution.
     * @return the zoom level for the provided resolution.
     */
    public native double getZoomForResolution(double resolution);

    /**
     * Adds a value to the view rotation. Any rotation constraint will apply.
     *
     * @param delta
     *            Relative value to add to the zoom rotation, in radians.
     */
    public native void adjustRotation(float delta);

    /**
     * Adds a value to the view rotation, optionally using an anchor. Any rotation constraint will apply.
     *
     * @param delta
     *            Relative value to add to the zoom rotation, in radians.
     * @param anchor
     *            Rotation anchor.
     */
    public native void adjustRotation(float delta, @Nullable Coordinate anchor);

    /**
     * Adds a value to the view zoom level. Any resolution constraint will apply.
     *
     * @param delta
     *            Relative value to add to the zoom level.
     */
    public native void adjustZoom(float delta);

    /**
     * Adds a value to the view zoom level, optionally using an anchor. Any resolution constraint will apply.
     *
     * @param delta
     *            Relative value to add to the zoom level.
     * @param anchor
     *            The origin of the transformation.
     */
    public native void adjustZoom(float delta, @Nullable Coordinate anchor);

    /**
     * Set the center of the current view.
     *
     * @param center
     *            The center of the view.
     */
    public native void setCenter(Coordinate center);

    /**
     * Set a new minimum zoom level for the view.
     * @param zoom
     *            The minimum zoom level.
     */
    public native void setMinZoom (double zoom);

    /**
     * Set a new maximum zoom level for the view.
     * @param zoom
     *            The maximum zoom level.
     */
    public native void setMaxZoom (double zoom);

    /**
     * Set the resolution for this view.
     *
     * @param resolution
     *            The resolution of the view.
     */
    public native void setResolution(double resolution);

    /**
     * Get the rotation for this view.
     *
     * @param rotation
     *            The rotation of the view in radians.
     */
    public native void setRotation(double rotation);

    /**
     * Zoom to a specific zoom level.
     *
     * @param zoom
     *            Zoom level
     */
    public native void setZoom(double zoom);

    /**
     * Calculate the extent for the current view state and the passed size.
     * The size is the pixel dimensions of the box into which the calculated extent should fit.
     * In most cases you want to get the extent of the entire map, that is map.getSize().
     *
     * @param size
     *            Box pixel size.
     */
    public native Extent calculateExtent(Size size);

}
