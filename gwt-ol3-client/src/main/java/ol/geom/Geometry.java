package ol.geom;

import com.google.gwt.core.client.js.JsType;

import ol.Observable;

/**
 * Base for vector geometries.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface Geometry extends Observable {

    Geometry clone();

}

