/*******************************************************************************
 * Copyright 2014, 2023 gwt-ol
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
package ol.source;

import jsinterop.annotations.JsFunction;
import ol.Extent;
import ol.proj.Projection;

/**
 *
 *
 * {@link ol.source.Vector} sources use a function of this type to get the url to load features from.
 */
@FunctionalInterface
@JsFunction
public interface FeatureUrlFunction {

    /**
     * @param extent area to be loaded
     * @param resolution resolution (map units per pixel)
     * @param projection projection
     * @return URL
     */
    String getUrl(Extent extent, double resolution, Projection projection);
}
