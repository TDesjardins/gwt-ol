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
package ol.layer;

import jsinterop.annotations.JsType;
import ol.Collection;

/**
 * A {@link ol.Collection} of layers that are handled together.
 *
 * A generic `change` event is triggered when the group/Collection changes.
 *
 * @author sbaumhekel
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public class Group extends Base {

    public Group() {}

    public Group(LayerGroupOptions layerGroupOptions) {}

    /**
     * Returns the {@link ol.Collection collection} of {@link ol.layer.Layer
     * layers} in this group.
     * @return collection of {@link ol.layer.Base} layers that are part of this group.
     */
    public native Collection<Base> getLayers();

    /**
     * Set the {@link ol.Collection collection} of {@link ol.layer.Layer layers}
     * in this group.
     * @param layers
     *            Collection of {@link ol.layer.Base layers} that are part of
     *            this group.
     */
    public native void setLayers(Collection<Base> layers);

}
