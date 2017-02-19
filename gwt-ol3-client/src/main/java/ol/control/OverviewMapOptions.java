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
package ol.control;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * OverviewMap control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class OverviewMapOptions extends ControlOptions {

    /**
     * Whether the control should start collapsed or not (expanded). Default to
     * true.
     * @param collapsed
     *            collapsed
     */
    @JsProperty
    public native void setCollapsed(boolean collapsed);

    /**
     * Text label to use for the expanded overviewmap button. Default is "«".
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param collapseLabel
     *            collapseLabel
     */
    @JsProperty
    public native void setCollapseLabel(String collapseLabel);

    /**
     * Whether the control can be collapsed or not. Default to true.
     * @param collapsible
     *            collapsible
     */
    @JsProperty
    public native void setCollapsible(boolean collapsible);

    /**
     * Text label to use for the collapsed overviewmap button. Default is ».
     * Instead of text, also a Node (e.g. a span element) can be used.
     * @param label
     *            label
     */
    @JsProperty
    public native void setLabel(String label);

    /**
     * Layers for the overview map. If not set, then all main map layers are
     * used instead.
     * @param layers
     *            layers
     */
    @JsProperty
    public native void setLayers(ol.Collection<ol.layer.Layer> layers);

    /**
     * Text label to use for the button tip. Default is "Overview map".
     * @param tipLabel
     *            tip label
     */
    @JsProperty
    public native void setTipLabel(String tipLabel);

    /**
     * Custom view for the overview map. If not provided, a default view with an
     * EPSG:3857 projection will be used.
     * @param view
     *            view
     */
    @JsProperty
    public native void setView(ol.View view);

}
