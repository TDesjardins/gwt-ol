package ol.event;

import ol.OLUtil;
import ol.geom.Geometry;
import ol.proj.Projection;

/**
 * An event for measuring.
 *
 * @author sbaumhekel
 */
public class MeasureEvent {

    private final Geometry geom;
    private final Projection projGeom;

    /**
     * Constructs an instance.
     * 
     * @param projGeom
     *            {@link Projection} of the geometry
     *
     * @param geom
     *            measure {@link Geometry}
     */
    public MeasureEvent(Projection projGeom, Geometry geom) {
        super();
        this.projGeom = projGeom;
        this.geom = geom;
    }

    /**
     * Gets the measure for the given {@link Geometry}.
     *
     * @param geom
     *            measure {@link Geometry}
     * @return measure on success, else {@link Double#NaN}
     */
    private static double getMeasure(ol.geom.Geometry geom) {
        if(geom instanceof ol.geom.LineString) {
            ol.geom.LineString ls = (ol.geom.LineString)geom;
            return ls.getLength();
        } else if(geom instanceof ol.geom.Polygon) {
            ol.geom.Polygon poly = (ol.geom.Polygon)geom;
            return poly.getArea();
        }
        return Double.NaN;
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
     * Gets the current measure.
     *
     * @return measure on success, else {@link Double#NaN}
     */
    public double getMeasure() {
        return getMeasure(geom);
    }

    /**
     * Gets the current measure in the given projection (and its unit).
     *
     * @param proj
     *            projection
     * @return measure on success, else {@link Double#NaN}
     */
    public double getMeasure(String proj) {
        Geometry geom = this.geom.clone().transform(this.projGeom.getCode(), proj);
        return getMeasure(geom);
    }

    /**
     * Gets the current measure in the given projection (and its unit).
     *
     * @param proj
     *            projection
     * @return measure on success, else {@link Double#NaN}
     */
    public double getMeasure(Projection proj) {
        Geometry geom = OLUtil.transform(this.geom.clone(), this.projGeom, proj);
        return getMeasure(geom);
    }

    /**
     * Gets the {@link Projection} of the geometry.
     * 
     * @return {@link Projection}
     */
    public Projection getProjection() {
        return this.projGeom;
    }

}
