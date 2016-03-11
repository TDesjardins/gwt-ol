package ol.format;

import jsinterop.annotations.JsType;

/**
 * Abstract base class; normally only used for creating subclasses and not instantiated in apps. Base class for feature formats.
 * {ol.format.Feature} subclasses provide the ability to decode and encode ol.Feature objects from a variety of commonly used geospatial
 * file formats. See the documentation for each format for more details.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Feature {}
