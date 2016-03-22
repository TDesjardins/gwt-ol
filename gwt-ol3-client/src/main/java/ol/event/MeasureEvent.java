package ol.event;

import ol.OLUtil;
import ol.geom.Geometry;
import ol.proj.Projection;

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
     * @return {@link Geometry}
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

    /**
     * Gets the current measure in the given projection (and its unit).
     *
     * @param proj
     *            projection
     * @return measure on success, else {@link Double#NaN}
     * @deprecated use {@link #getMeasure()} instead
     */
    @Deprecated
    public double getMeasure(Projection proj) {
        return getMeasure();
    }

    /**
     * Gets the current measure in the given projection (and its unit).
     *
     * @param proj
     *            projection
     * @return measure on success, else {@link Double#NaN}
     * @deprecated use {@link #getMeasure()} instead
     */
    @Deprecated
    public double getMeasure(String proj) {
        return getMeasure();
    }

    /**
     * Gets the {@link Projection} of the geometry.
     *
     * @return {@link Projection}
     * @deprecated the projection is always WGS84 geographic coordinates
     *             (EPSG:4326)
     */
    @SuppressWarnings("static-method")
    @Deprecated
    public Projection getProjection() {
        return ol.OLUtil.getProjection("EPSG:4326");
    }

}
