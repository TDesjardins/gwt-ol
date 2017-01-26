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

package tol.j2cl.elem.global;

/**
 * The Document Object Model (DOM) is a programming interface for HTML, XML and
 * SVG documents. It provides a structured representation of the document as a
 * tree. The DOM defines methods that allow access to the tree, so that they can
 * change the document structure, style and content. The DOM provides a
 * representation of the document as a structured group of nodes and objects,
 * possessing various properties and methods. Nodes can also have event handlers
 * attached to them, and once an event is triggered, the event handlers get
 * executed. Essentially, it connects web pages to scripts or programming
 * languages.
 *
 * <p>
 * Although the DOM is often accessed using JavaScript, it is not a part of the
 * JavaScript language. It can also be accessed by other languages.
 *
 * @author Markus Brigl
 * 
 * @see https://www.w3.org/TR/dom/
 * @see https://dom.spec.whatwg.org/
 * @see https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model
 */
public abstract class Global {

	private Global() {}

	/**
	 * Get a value at index from array.
	 *
	 * @param array - The array
	 * @param index - The index
	 */
	protected static final native <T> T at(Array<T> array, int index) /*-{
		return array[index];
	}-*/;

	/**
	 * Get the keys from an associative array.
	 *
	 * @param map - The map
	 */
	protected static final native <T> Array<String> keys(Map<T> map) /*-{
		return Object.keys(map);
	}-*/;

	/**
	 * Get an item from an associative array.
	 *
	 * @param map - The map
	 * @param name - The named index
	 */
	protected static final native <T> T get(Map<T> map, String name) /*-{
		return map[name];
	}-*/;

	/**
	 * Set an item to an associative array.
	 *
	 * @param map - The map
	 * @param name - The named index
	 * @param value - The value
	 */
	protected static final native <T> void set(Map<T> map, String name, T value) /*-{
		map[name] = value;
	}-*/;

	/**
	 * Unset an item from an associative array.
	 *
	 * @param map - The map
	 * @param name - The named index
	 */
	protected static final native <T> void unset(Map<T> map, String name) /*-{
		delete map[name];
	}-*/;
}
