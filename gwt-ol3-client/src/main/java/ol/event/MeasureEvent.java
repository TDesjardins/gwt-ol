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
package ol.event;

import ol.OLUtil;
import ol.geom.Geometry;

/**
 * An event for measuring. It provides the measurment (length or area) directly
 * as well as the underlying geometry in (WGS84 coordinates).
 *
 * @author sbaumhekel
 */
public class MeasureEvent {

    private final Geometry geom;

    /**
     * Constructs an instance.
     *
     * @param geom
     *            measure {@link Geometry} (in WGS84 geographic coordinates
     *            (EPSG:4326))
     */
    public MeasureEvent(Geometry geom) {
        this.geom = geom;
    }

    /**
     * Gets the measurement geometry: a {@link ol.geom.LineString} for length
     * measurements and a {@link ol.geom.Polygon} for area measurements.
     *
     * @return measurement geometry
     */
    public Geometry getGeometry() {
        return this.geom;
    }

    /**
     * Gets the current measure (length in meters or area in square meters).
     *
     * @return measure on success, else {@link Double#NaN}
     */
    public double getMeasure() {
        if(geom instanceof ol.geom.LineString) {
            return OLUtil.geodesicLength((ol.geom.LineString)geom);
        } else if(geom instanceof ol.geom.Polygon) {
            return OLUtil.geodesicArea((ol.geom.Polygon)geom);
        }
        return Double.NaN;
    }

}
