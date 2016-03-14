package ol.format;

import com.google.gwt.core.client.js.JsType;

/**
 * Abstract base class; normally only used for creating subclasses and not instantiated in apps. Base class for JSON feature formats.
 *
 * @author tlochmann
 *
 */
@JsType(prototype = "ol.format.JSONFeature")
public interface JSONFeature extends Feature {}
