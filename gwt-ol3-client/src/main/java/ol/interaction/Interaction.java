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
package ol.interaction;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import ol.PluggableMap;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. User actions that change the state of the map. Some are
 * similar to controls, but are not associated with a DOM element. For example,
 * {@link ol.interaction.KeyboardZoom} is functionally the same as
 * {@link ol.control.Zoom}, but triggered by a keyboard event not a button
 * element event. Although interactions do not have a DOM element, some of them
 * do render vectors and so are visible on the screen.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Interaction extends ol.Object {

    @JsOverlay
    private static final String PACKAGE_INTERACTION = "ol.interaction";

    @JsMethod(name = "defaults", namespace = PACKAGE_INTERACTION)
    public static native ol.Collection<ol.interaction.Interaction> defaults();

    /**
     * Set of interactions included in maps by default. Specific interactions
     * can be excluded by setting the appropriate option to false in the
     * constructor options, but the order of the interactions is fixed. If you
     * want to specify a different order for interactions, you will need to
     * create your own ol.interaction.Interaction instances and insert them into
     * a ol.Collection in the order you want before creating your ol.Map
     * instance.
     *
     * @param options
     *            options.
     * @return interactions
     */
    @JsMethod(name = "defaults", namespace = PACKAGE_INTERACTION)
    public static native ol.Collection<ol.interaction.Interaction> defaults(DefaultInteractionsOptions options);

    /**
     * Return whether the interaction is currently active.
     *
     * @return `true` if the interaction is active, `false` otherwise.
     */
    public native boolean getActive();

    /**
     * Get the map associated with this interaction.
     *
     * @return associated with this interaction
     */
    public native PluggableMap getMap();

    /**
     * Activate or deactivate the interaction.
     *
     * @param active
     *            Active.
     */
    public native void setActive(boolean active);

}
