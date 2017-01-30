/*
 * Copyright (c) 2001-2017 Territorium Online Srl. All Rights Reserved.
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

package tol.j2cl.elem.global.func;

import jsinterop.annotations.JsFunction;
import tol.j2cl.elem.global.Array;

/**
 * The {@link Consumer} class.
 * 
 * @author Markus Brigl
 */
@JsFunction
public interface Consumer<T> {

	/**
	 * Function is a predicate, to test each element of the array. Return true to
	 * keep the element, false otherwise, taking three arguments:
	 *
	 * @param elem - The current element being processed in the array.
	 * @param index - The index of the current element being processed in the
	 *          array.
	 * @param array - The array filter was called upon.
	 */
	public void accept(T elem, int index, Array<T> array);
}
