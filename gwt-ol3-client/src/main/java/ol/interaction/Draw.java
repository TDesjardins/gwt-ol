/*******************************************************************************
 * Copyright 2014, 2025 gwt-ol
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
package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Feature;
import ol.GeometryFunction;
import ol.geom.Geometry;

/**
 * Interaction for drawing feature geometries.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public class Draw extends Interaction {

    public Draw(DrawOptions drawOptions) {}

    /**
     * Create a geometryFunction that will create a box-shaped polygon (aligned with the
     * coordinate system axes). Use this with the draw interaction and type: 'Circle' to
     * return a box instead of a circle geometry.
     *
     * @return Function that draws a box-shaped polygon.
     */
    public static native GeometryFunction<? extends Geometry, ? extends Geometry> createBox();

    /**
     * Create a geometryFunction for type: 'Circle' that will create a regular polygon
     * with a user specified number of sides and start angle instead of a Circle geometry.
     *
     * @param sides number of sides of the regular polygon. Default is 32.
     * @param angle Angle of the first point in counter-clockwise radians. 0 means East.
     * Default is the angle defined by the heading from the center of the regular polygon
     * to the current pointer position.
     *
     * @return Function that draws a polygon.
     */
    public static native GeometryFunction<? extends Geometry, ? extends Geometry> createRegularPolygon(int sides, double angle);

    /**
     * Extend an existing geometry by adding additional points. This only works
     * on features with `LineString` geometries, where the interaction will
     * extend lines by adding points to the end of the coordinates array.
     *
     * @param feature
     *            Feature to be extended.
     */
    public native void extend(Feature feature);

    /**
     * Stop drawing and add the sketch feature to the target layer. The
     * DRAWEND event is dispatched before
     * inserting the feature.
     */
    public native void finishDrawing();

    /**
     * Remove last point of the feature currently being drawn.
     */
    public native void removeLastPoint();

    /**
     * Events emitted by {@link ol.interaction.Draw} instances are instances of this
     * type.
     *
     * @author sbaumhekel
     *
     */
    @JsType(isNative = true)
    public interface Event extends ol.events.Event {

        /**
         * The feature being drawn.
         *
         * @return feature being drawn
         */
        @JsProperty
        Feature getFeature();

    }

}
