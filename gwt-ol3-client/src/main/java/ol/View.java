package ol;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;

import ol.gwt.TypedObject;
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

    /**
     * Fit the given geometry or extent based on the given map size and border.
     * The size is pixel dimensions of the box to fit the extent into. In most
     * cases you will want to use the map size, that is `map.getSize()`. Takes
     * care of the map angle.
     *
     * @param geometry
     *            {ol.geom.SimpleGeometry|ol.Extent} Geometry.
     * @param size
     *            Box pixel size.
     */
    public native void fit(TypedObject<ol.geom.SimpleGeometry, ol.Extent> geometry, Size size);

    /**
     * Get the view center.
     *
     * @return {ol.Coordinate|undefined} The center of the view.
     */
    public native Coordinate getCenter();

    /**
     * Get the view projection.
     *
     * @return {ol.proj.Projection} The projection of the view.
     */
    public native Projection getProjection();

    /**
     * Get the view resolution.
     *
     * @return The resolution of the view.
     */
    public native double getResolution();

    /**
     * Get the view rotation.
     *
     * @return The rotation of the view in radians.
     */
    public native double getRotation();

    /**
     * Get the current zoom level. Return undefined if the current resolution is
     * undefined or not a "constrained resolution".
     *
     * @return Zoom.
     * @deprecated use {@link OLUtil#getZoomLevel(Map) instead}
     */
    @Deprecated
    public native int getZoom();

    /**
     * Rotate the view around a given coordinate.
     *
     * @param rotation
     *            Center for rotation and anchor.
     * @param anchor
     *            Rotation anchor.
     */
    public native void rotate(float rotation, @Nullable Coordinate anchor);

    /**
     * Set the center of the current view.
     *
     * @param center
     *            The center of the view.
     */
    public native void setCenter(Coordinate center);

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

}
