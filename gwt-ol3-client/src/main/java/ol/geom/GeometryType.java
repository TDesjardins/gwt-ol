package ol.geom;

import jsinterop.annotations.JsType;

/**
 *  The geometry type enumeration representing ol.geom.GeometryType. 
 *
 * @author Peter Zanetti
 * 
 * @see https://github.com/openlayers/ol3/blob/master/src/ol/geom/geometry.js
 *
 */
@JsType
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
