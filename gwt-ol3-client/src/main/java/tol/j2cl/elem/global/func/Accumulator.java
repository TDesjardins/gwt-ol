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
 * The {@link Accumulator} class.
 * 
 * @author Markus Brigl
 */
@JsFunction
public interface Accumulator<T, R> {

	/**
	 * Function to execute on each value in the array, taking four arguments:
	 *
	 * @param accumulator - The accumulated value previously returned in the last
	 *          invocation of the callback, or initialValue, if supplied.
	 * @param elem - The current element being processed in the array.
	 * @param index - The index of the current element being processed in the
	 *          array. Starts at index 0, if an initialValue is provided, and at
	 *          index 1 otherwise.
	 * @param array - The array reduce was called upon.
	 */
	public R accept(R accumulator, T elem, int index, Array<T> array);
}
