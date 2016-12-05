package ol.geom;

/**
 *  The geometry type. 
 *
 * @author Peter Zanetti
 * 
 * @see https://github.com/openlayers/ol3/blob/master/src/ol/geom/geometry.js
 *
 */
public enum GeometryType {

	Point,
	LineString,
	LinearRing,
	Polygon,
	MultiPoint,
	MultiLineString,
	MultiPolygon,
	GeometryCollection,
	Circle	
}
