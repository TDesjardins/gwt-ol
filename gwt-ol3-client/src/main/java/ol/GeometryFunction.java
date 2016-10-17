package ol;

import jsinterop.annotations.JsFunction;
import ol.geom.Geometry;

/**
 * The {@link GeometryFunction} class
 * 
 * @author elena guandalini
 */
@JsFunction
public interface GeometryFunction<R extends Geometry, C, G extends Geometry> {

	R call(C coordinates, G geometry);
}