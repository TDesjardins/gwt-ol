/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol.format.filter;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import ol.Extent;
import ol.geom.Geometry;

/**
 * Abstract class; normally only used for creating subclasses 
 * and not instantiated in apps. Base class for WFS GetFeature filters.
 * 
 * @author hmgn
 *
 */
@JsType(isNative = true)
public abstract class Filter {
	
    @JsOverlay
    private static final String PACKAGE_FILTER = "ol.format.filter";

    /**
     * @deprecated This constructor is only to satisfy JsInterop.
     * Do not use this!
     */
    public Filter() {}
    
	/**
	 * Constructor
	 * 
	 * @param tagName The XML tag name for this filter.
	 */
	public Filter(String tagName) {}
	
	@JsMethod(name = "and", namespace = PACKAGE_FILTER)
    public static native And and(Filter... conditions);

	@JsMethod(name = "bbox", namespace = PACKAGE_FILTER)
    public static native Bbox bbox(String geometryName, Extent extent);

	@JsMethod(name = "bbox", namespace = PACKAGE_FILTER)
    public static native Bbox bbox(String geometryName, Extent extent, String srsName);

	@JsMethod(name = "between", namespace = PACKAGE_FILTER)
    public static native IsBetween between(String propertyName, double lowerBoundary, double upperBoundary);

	@JsMethod(name = "during", namespace = PACKAGE_FILTER)
    public static native During during(String propertyName, String begin, String end);

	@JsMethod(name = "equalTo", namespace = PACKAGE_FILTER)
    public static native EqualTo equalTo(String propertyName, String expression);

	@JsMethod(name = "equalTo", namespace = PACKAGE_FILTER)
    public static native EqualTo equalTo(String propertyName, String expression, boolean matchCase);

	@JsMethod(name = "equalTo", namespace = PACKAGE_FILTER)
    public static native EqualTo equalTo(String propertyName, Number expression);

	@JsMethod(name = "equalTo", namespace = PACKAGE_FILTER)
    public static native EqualTo equalTo(String propertyName, Number expression, boolean matchCase);

	@JsMethod(name = "greaterThan", namespace = PACKAGE_FILTER)
    public static native GreaterThan greaterThan(String propertyName, Number expression);

	@JsMethod(name = "greaterThanOrEqualTo", namespace = PACKAGE_FILTER)
    public static native GreaterThanOrEqualTo greaterThanOrEqualTo(String propertyName, Number expression);

	@JsMethod(name = "intersects", namespace = PACKAGE_FILTER)
    public static native Intersects intersects(String geometryName, Geometry geometry, String srsName);

	@JsMethod(name = "isNull", namespace = PACKAGE_FILTER)
    public static native IsNull isNull(String propertyName);

	@JsMethod(name = "lessThan", namespace = PACKAGE_FILTER)
    public static native LessThan lessThan(String propertyName, Number expression);

	@JsMethod(name = "lessThanOrEqualTo", namespace = PACKAGE_FILTER)
    public static native LessThanOrEqualTo lessThanOrEqualTo(String propertyName, Number expression);

	@JsMethod(name = "like", namespace = PACKAGE_FILTER)
    public static native IsLike like(String propertyName, String pattern);

	@JsMethod(name = "not", namespace = PACKAGE_FILTER)
    public static native Not not(Filter condition);

    @JsMethod(name = "notEqualTo", namespace = PACKAGE_FILTER)
    public static native NotEqualTo notEqualTo(String propertyName, String expression);

    @JsMethod(name = "notEqualTo", namespace = PACKAGE_FILTER)
    public static native NotEqualTo notEqualTo(String propertyName, String expression, boolean matchCase);

    @JsMethod(name = "notEqualTo", namespace = PACKAGE_FILTER)
    public static native NotEqualTo notEqualTo(String propertyName, Number expression);

    @JsMethod(name = "notEqualTo", namespace = PACKAGE_FILTER)
    public static native NotEqualTo notEqualTo(String propertyName, Number expression, boolean matchCase);

    @JsMethod(name = "or", namespace = PACKAGE_FILTER)
    public static native Or or(Filter... conditions);

    @JsMethod(name = "within", namespace = PACKAGE_FILTER)
    public static native Within within(String geometryName, Geometry geometry);

    @JsMethod(name = "within", namespace = PACKAGE_FILTER)
    public static native Within within(String geometryName, Geometry geometry, String srsName);

}
