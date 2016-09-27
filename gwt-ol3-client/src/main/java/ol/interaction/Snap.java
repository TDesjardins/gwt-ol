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

import jsinterop.annotations.JsType;
import ol.Feature;
import ol.Map;

/**
 * 
 * Handles snapping of vector features while modifying or drawing them. The
 * features can come from a ol.source.Vector or ol.Collection Any interaction
 * object that allows the user to interact with the features using the mouse can
 * benefit from the snapping, as long as it is added before.
 * 
 * The snap interaction modifies map browser event coordinate and pixel
 * properties to force the snap to occur to any interaction that them.
 * 
 * The {@link Snap} class
 */
@JsType(isNative = true)
public class Snap extends Interaction {

	/**
	 * Add a feature to the collection of features that we may snap to.
	 * 
	 * @param feature
	 */
	public native void addFeature(Feature feature);

	/**
	 * Remove a feature from the collection of features that we may snap to.
	 * 
	 * @param feature
	 */
	public native void removeFeature(Feature feature);

	/**
	 * Get the map associated with this interaction.
	 * 
	 * @return
	 */
	public native Map getMap();

}
