package ol.format;

import com.google.gwt.core.client.js.JsType;

/**
 * Abstract base class; normally only used for creating subclasses and not instantiated in apps. Base class for feature formats. 
 * {ol.format.Feature} subclasses provide the ability to decode and encode ol.Feature objects from a variety of commonly used geospatial 
 * file formats. See the documentation for each format for more details. 
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.format.Feature")
public interface Feature {}
