package ol;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for calling {@link ol.View#fit(ol.gwt.TypedObject, ViewFitOptions)}.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewFitOptions implements Options {

    /**
     * Constrain the resolution. Default is true.
     * @param constrainResolution
     */
    @JsProperty
    public native void setConstrainResolution(boolean constrainResolution);

    /**
     * The duration of the animation in milliseconds. By default, there is no
     * animations.
     * @param duration
     */
    @JsProperty
    public native void setDuration(int duration);

    /**
     * Maximum zoom level that we zoom to. If minResolution is given, this
     * property is ignored.
     * @param maxZoom
     */
    @JsProperty
    public native void setMaxZoom(double maxZoom);

    /**
     * Minimum resolution that we zoom to. Default is 0.
     * @param minResolution
     */
    @JsProperty
    public native void setMinResolution(double minResolution);

    /**
     * Get the nearest extent. Default is false.
     * @param nearest
     */
    @JsProperty
    public native void setNearest(boolean nearest);

    /**
     * The size in pixels of the box to fit the extent into. Default is the
     * current size of the first map in the DOM that uses this view, or [100,
     * 100] if no such map is found.
     * @param size
     */
    @JsProperty
    public native void setSize(ol.Size size);

}
