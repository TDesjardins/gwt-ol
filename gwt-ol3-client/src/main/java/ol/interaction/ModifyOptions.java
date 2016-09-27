/*
 * Copyright (c) 2001-2016 Territorium Online Srl. All Rights Reserved.
 *
 * This file contains Original Code and/or Modifications of Original Code as
 * defined in and that are subject to the Territorium Online License Version
 * 1.0. You may not use this file except in compliance with the License. Please
 * obtain a copy of the License at http://www.tol.info/license/ and read it
 * before using this file.
 *
 * The Original Code and all software distributed under the License are
 * distributed on an 'AS IS' basis, WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESS
 * OR IMPLIED, AND TERRITORIUM ONLINE HEREBY DISCLAIMS ALL SUCH WARRANTIES,
 * INCLUDING WITHOUT LIMITATION, ANY WARRANTIES OF MERCHANTABILITY, FITNESS FOR
 * A PARTICULAR PURPOSE, QUIET ENJOYMENT OR NON-INFRINGEMENT. Please see the
 * License for the specific language governing rights and limitations under the
 * License.
 */
package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.GenericFunction;
import ol.Options;

/**
 * Interaction for modifying feature geometries.
 * 
 * The {@link ModifyOptions} class
 */
@JsType(isNative = true)
public interface ModifyOptions extends Options {

	/**
	 * A function that takes an ol.MapBrowserEvent and returns a boolean to
	 * indicate whether that event will be considered to add or move a vertex to
	 * the sketch. Default is ol.events.condition.primaryAction.
	 * 
	 * @param function
	 */
	@JsProperty
	void setCondition(GenericFunction<?, ?> function);

	/**
	 * A function that takes an ol.MapBrowserEvent and returns a boolean to
	 * indicate whether that event should be handled. By default,
	 * ol.events.condition.singleClick with ol.events.condition.noModifierKeys
	 * results in a vertex deletion.
	 * 
	 * @param function
	 */
	@JsProperty
	void setDeleteCondition(GenericFunction<?, ?> function);

	/**
	 * Pixel tolerance for considering the pointer close enough to a segment or
	 * vertex for editing. Default is 10.
	 * 
	 * @param clickTolerance
	 */
	@JsProperty
	void setPixelTolerance(int clickTolerance);

	/**
	 * Style used for the features being modified. By default the default edit
	 * style is used (see ol.style).
	 * 
	 * @param styleFunction
	 */
	@JsProperty
	void setStyle(GenericFunction<?, ?> styleFunction);

	/**
	 * The features the interaction works on. Required.
	 * 
	 * @param features
	 */
	@JsProperty
	void setFeatures(Collection<Feature> features);

	/**
	 * Wrap the world horizontally on the sketch overlay. Default is false.
	 * 
	 * @param wrapX
	 */
	@JsProperty
	void setWrapX(boolean wrapX);

}
