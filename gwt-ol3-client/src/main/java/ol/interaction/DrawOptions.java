package ol.interaction;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Collection;
import ol.Feature;
import ol.Options;
import ol.source.Vector;
import ol.style.Style;

/**
 * Options for {@link Draw}.
 * 
 * @author sbaumhekel
 *
 */
@JsType
public interface DrawOptions extends Options {
    /**
     * The maximum distance in pixels between "down" and "up" for a "up" event
     * to be considered a "click" event and actually add a point/vertex to the
     * geometry being drawn. Default is 6 pixels. That value was chosen for the
     * draw interaction to behave correctly on mouse as well as on touch
     * devices.
     *
     * @param clickTolerance
     *            clickTolerance
     * @return this instance
     */
    @JsProperty
    void setClickTolerance(int clickTolerance);

    /**
     * Destination collection for the drawn features.
     *
     * @param features
     *            features
     * @return this instance
     */
    @JsProperty
    void setFeatures(Collection<Feature> features);

    /**
     * The number of points that can be drawn before a polygon ring or line
     * string is finished. The default is no restriction.
     *
     * @param maxPoints
     *            maxPoints
     * @return this instance
     */
    @JsProperty
    void setMaxPoints(Integer maxPoints);

    /**
     * The number of points that must be drawn before a polygon ring or line
     * string can be finished. Default is 3 for polygon rings and 2 for line
     * strings.
     *
     * @param minPoints
     *            minPoints
     * @return this instance
     */
    @JsProperty
    void setMinPoints(int minPoints);

    /**
     * Pixel distance for snapping to the drawing finish. Default is 12.
     *
     * @param snapTolerance
     *            snapTolerance
     * @return this instance
     */
    @JsProperty
    void setSnapTolerance(int snapTolerance);

    /**
     * Destination source for the drawn features.
     *
     * @param source
     *            source
     * @return this instance
     */
    @JsProperty
    void setSource(Vector source);

    /**
     * Style for sketch features.
     *
     * @param style
     *            style
     * @return this instance
     */
    @JsProperty
    void setStyle(Style style);

    /**
     * Drawing type ('Point', 'LineString', 'Polygon', 'MultiPoint',
     * 'MultiLineString', 'MultiPolygon' or 'Circle'). Required.
     *
     * @param type
     *            type
     * @return this instance
     */
    @JsProperty
    void setType(String type);

    /**
     * Wrap the world horizontally on the sketch overlay. Default is false.
     *
     * @param wrapX
     *            wrapX
     * @return this instance
     */
    @JsProperty
    void setWrapX(boolean wrapX);

}
