/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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
package ol.style;

import jsinterop.annotations.JsFunction;
import ol.Feature;

/**
 * A function that takes an {@link ol.Feature} and a number representing the view's resolution.
 */
@FunctionalInterface
@JsFunction
public interface StyleFunction {

    /**
     * Creates a style by feature and resolution
     *
     * @param feature feature to style
     * @param resolution resolution of view
     * @return style
     */
    Style[] createStyle(Feature feature, double resolution);

}