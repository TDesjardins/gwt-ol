/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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
