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
package ol.style;

import jsinterop.annotations.JsType;

/**
 * Images added to this manager will be inserted into an atlas, which will
 * be used for rendering. The size given in the constructor is the size for
 * the first atlas. After that, when new atlases are created, they will have
 * twice the size as the latest atlas (until maxSize is reached).
 * If an application uses many images or very large images, it is recommended
 * to set a higher size value to avoid the creation of too many atlases.
 *
 * @see https://openlayers.org/en/latest/apidoc/ol.style.RegularShape.html
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class AtlasManager {

    public AtlasManager(AtlasManagerOptions atlasManagerOptions) {}

}
