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
package ol.control;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Attribution options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class AttributionOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-attribution".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * Specify if attributions should be collapsed at startup. Default is true.
     * @param collapsed
     *            collapsed
     */
    @JsProperty
    public native void setCollapsed(boolean collapsed);

    /**
     * Text label to use for the expanded attributions button. Default is "»".
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param collapseLabel
     *            collapseLabel
     */
    @JsProperty
    public native void setCollapseLabel(String collapseLabel);

    /**
     * Specify if attributions can be collapsed. If you use an OSM source,
     * should be set to false - see OSM Copyright - Default is true.
     * @param collapsible
     *            collapsible
     */
    @JsProperty
    public native void setCollapsible(boolean collapsible);

    /**
     * Text label to use for the collapsed attributions button. Default is "i".
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param label
     *            label
     */
    @JsProperty
    public native void setLabel(String label);

    /**
     * Text label to use for the button tip. Default is "Attributions".
     * @param tipLabel
     *            tip label
     */
    @JsProperty
    public native void setTipLabel(String tipLabel);

}
