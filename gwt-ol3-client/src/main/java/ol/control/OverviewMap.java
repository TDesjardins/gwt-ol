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
package ol.control;

import jsinterop.annotations.JsType;
import ol.PluggableMap;

/**
 * A control with a map acting as an overview map for an other defined map.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class OverviewMap extends Control {

    public OverviewMap() {}

    public OverviewMap(OverviewMapOptions overviewMapOptions) {}

    /**
     * Determine if the overview map is collapsed.
     * @return The overview map is collapsed.
     */
    public native boolean getCollapsed();

    /**
     * Return `true` if the overview map is collapsible, `false` otherwise.
     * @return True if the widget is collapsible.
     */
    public native boolean getCollapsible();

    /**
     * Return the overview map.
     * @return overview map.
     */
    public native PluggableMap getOverviewMap();

    /**
     * Collapse or expand the overview map according to the passed parameter.
     * Will not do anything if the overview map isn't collapsible or if the
     * current collapsed state is already the one requested.
     * @param collapsed
     *            True if the widget is collapsed.
     */
    public native void setCollapsed(boolean collapsed);

    /**
     * Set whether the overview map should be collapsible.
     * @param collapsible
     *            True if the widget is collapsible.
     */
    public native void setCollapsible(boolean collapsible);

}
