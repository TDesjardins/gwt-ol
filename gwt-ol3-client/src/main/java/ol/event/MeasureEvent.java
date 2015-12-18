package ol.event;

import ol.geom.*;

/**
 * An event for measuring.
 *
 * @author sbaumhekel
 */
public class MeasureEvent {

    /**
     * Map projection code.
     */
    private static final String MAP_PROJECTION = "EPSG:3857";
    private final Geometry geom;

    /**
     * Constructs an instance.
     *
     * @param geom
     *            measure {@link Geometry}
     */
    public MeasureEvent(Geometry geom) {
	super();
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
	if (geom instanceof ol.geom.LineString) {
	    ol.geom.LineString ls = (ol.geom.LineString) geom;
	    return ls.getLength();
	} else if (geom instanceof ol.geom.Polygon) {
	    ol.geom.Polygon poly = (ol.geom.Polygon) geom;
	    return poly.getArea();
	}
	return Double.NaN;
    }

    /**
     * Gets the measurement geometry: a {@link LineString} for length
     * measurements and a {@link Polygon} for area measurements.
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
	Geometry geom2 = geom.clone().transform(MAP_PROJECTION, proj);
	return getMeasure(geom2);
    }

}
