/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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
