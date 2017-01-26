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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import tol.j2cl.elem.global.func.Accumulator;
import tol.j2cl.elem.global.func.Consumer;
import tol.j2cl.elem.global.func.Filter;
import tol.j2cl.elem.global.func.Mapper;

import java.util.Iterator;

/**
 * The JavaScript Array object is a global object that is used in the
 * construction of arrays; which are high-level, list-like objects.
 *
 * @author Markus Brigl
 * 
 * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Array<T> {

	/**
	 * Constructs an instance of {@link Array}.
	 *
	 * @param size - The size of the array
	 */
	@JsConstructor
	public Array(int size) {}

	/**
	 * Constructs an instance of {@link Array}.
	 *
	 * @param values - The array values
	 */
	@SafeVarargs
	@JsConstructor
	public Array(T... values) {}

	/**
	 * The array length property sets or returns the number of elements in an
	 * array. It represents an unsigned, 32-bit integer that is always numerically
	 * greater than the highest index in the array.
	 */
	@JsProperty
	public native int getLength();

	/**
	 * Get an element from array at index.
	 *
	 * @param index - The index of a value
	 */
	@JsOverlay
	public final T get(int index) {
		return Global.at(this, index);
	}

	/**
	 * The concat() method is used to merge two or more arrays. This method does
	 * not change the existing arrays, but instead returns a new array.
	 */
	@JsMethod
	public native Array<T> concat(Array<T> array);

	/**
	 * The entries() method returns a new Array Iterator object that contains the
	 * key/value pairs for each index in the array. {@link #entries}.
	 */
	@JsMethod
	public native Array<T> entries();

	/**
	 * The every() method tests whether all elements in the array pass the test
	 * implemented by the provided function. {@link #every}.
	 *
	 * @param filter - The filter to apply
	 */
	public native boolean every(Filter<T> filter);

	/**
	 * The fill() method fills all the elements of an array from a start index to
	 * an end index with a static value.
	 *
	 * @param value - The value to fill
	 */
	@JsMethod
	public native void fill(T value);

	/**
	 * The filter() method creates a new array with all elements that pass the
	 * test implemented by the provided function.
	 *
	 * @param filter - The filter to apply
	 */
	@JsMethod
	public native Array<T> filter(Filter<T> filter);

	/**
	 * The find() method returns a value of the first element in the array that
	 * satisfies the provided testing function. Otherwise undefined is returned.
	 * {@link #find}.
	 *
	 * @param filter - The filter to apply
	 */
	@JsMethod
	public native boolean find(Filter<T> filter);

	/**
	 * The findIndex() method returns an index of the first element in the array
	 * that satisfies the provided testing function. Otherwise -1 is returned.
	 * {@link #find}.
	 *
	 * @param filter - The filter to apply
	 */
	@JsMethod
	public native int findIndex(Filter<T> filter);

	/**
	 * The forEach() method executes a provided function once per array element.
	 *
	 * @param callback - The callback function
	 */
	@JsMethod
	public native void forEach(Consumer<T> callback);

	/**
	 * The includes() method determines whether an array includes a certain
	 * element, returning true or false as appropriate. {@link #indexOf}.
	 *
	 * @param value - The value to search
	 */
	@JsMethod
	public native boolean includes(T value);

	/**
	 * The indexOf() method returns the first index at which a given element can
	 * be found in the array, or -1 if it is not present. {@link #findIndex}.
	 *
	 * @param value - The value to search
	 */
	@JsMethod
	public native int indexOf(T value);

	/**
	 * The join() method joins all elements of an array into a string.
	 */
	@JsOverlay
	public final String join() {
		return join(",");
	}

	/**
	 * The join() method joins all elements of an array into a string.
	 *
	 * @param seperator - The seperator string
	 */
	@JsMethod
	public native String join(String seperator);

	/**
	 * The keys() method returns a new Array Iterator that contains the keys for
	 * each index in the array. {@link #keys}.
	 */
	@JsMethod
	public native Array<String> keys();

	/**
	 * The lastIndexOf() method returns the last index at which a given element
	 * can be found in the array, or -1 if it is not present. The array is
	 * searched backwards, starting at fromIndex. {@link #lastIndexOf}.
	 *
	 * @param value - The value to search
	 */
	@JsMethod
	public native int lastIndexOf(T value);

	/**
	 * The map() method creates a new array with the results of calling a provided
	 * function on every element in this array. {@link #lastIndexOf}.
	 *
	 * @param map - The mapper
	 */
	@JsMethod
	public native <V> Array<V> map(Mapper<T, V> map);

	/**
	 * The pop() method removes the last element from an array and returns that
	 * element. This method changes the length of the array.
	 */
	@JsMethod
	public native T pop();

	/**
	 * The push() method adds one or more elements to the end of an array and
	 * returns the new length of the array.
	 *
	 * @param values - The values to push
	 */
	@JsMethod
	@SuppressWarnings("unchecked")
	public native void push(T... values);

	/**
	 * The reduce() method applies a function against an accumulator and each
	 * value of the array (from left-to-right) to reduce it to a single value.
	 *
	 * @param reduce - The reduce function
	 * @param initialValue - The initial value
	 */
	@JsMethod
	public native <R> R reduce(Accumulator<T, R> reduce, R initialValue);

	@JsOverlay
	public final <R> R reduce(Accumulator<T, R> reduce) {
		return reduce(reduce, null);
	}

	/**
	 * The reduceRight() method applies a function against an accumulator and each
	 * value of the array (from right-to-left) has to reduce it to a single value.
	 *
	 * @param reduce - The reduce function
	 * @param initialValue - The initial value
	 */
	@JsMethod
	public native <R> R reduceRight(Accumulator<T, R> reduce, R initialValue);

	@JsOverlay
	public final <R> R reduceRight(Accumulator<T, R> reduce) {
		return reduceRight(reduce, null);
	}

	/**
	 * The reverse() method reverses an array in place. The first array element
	 * becomes the last, and the last array element becomes the first.
	 * {@link #push}.
	 */
	@JsMethod
	public native Array<T> reverse();

	/**
	 * The shift() method removes the first element from an array and returns that
	 * element. This method changes the length of the array.
	 */
	@JsMethod
	public native T shift();

	/**
	 * The slice() method returns a shallow copy of a portion of an array into a
	 * new array object selected from begin to end (end not included). The
	 * original array will not be modified. {@link #slice}.
	 *
	 * @param begin - The start index
	 * @param end - The end index
	 */
	@JsMethod
	public native Array<T> slice(int begin, int end);

	@JsOverlay
	public final Array<T> slice(int begin) {
		return slice(begin, getLength());
	}

	@JsOverlay
	public final Array<T> slice() {
		return slice(0, getLength());
	}

	/**
	 * The some() method tests whether some element in the array passes the test
	 * implemented by the provided function.
	 *
	 * @param filter - The filter to apply
	 */
	@JsMethod
	public native boolean some(Filter<T> filter);

	/**
	 * The sort() method sorts the elements of an array in place and returns the
	 * array. The sort is not necessarily stable. The default sort order is
	 * according to string Unicode code points. {@link #sort}.
	 */
	@JsMethod
	public native Array<T> sort();

	/**
	 * The splice() method changes the content of an array by removing existing
	 * elements and/or adding new elements.
	 *
	 * @param start - The index where to start
	 * @param deleteCount - The number of elements to delete
	 * @param items - The items to append
	 */
	@JsMethod
	@SuppressWarnings("unchecked")
	public native Array<T> splice(int start, int deleteCount, T... items);

	/**
	 * The unshift() method adds one or more elements to the beginning of an array
	 * and returns the new length of the array. {@link #unshift}.
	 *
	 * @param items - The items to unshift
	 */
	@JsMethod
	@SuppressWarnings("unchecked")
	public native int unshift(T... items);

	/**
	 * The values() method returns a new Array Iterator object that contains the
	 * values for each index in the array.
	 */
	@JsMethod
	public native <V> Array<V> values();

	/**
	 * The Array.of() method creates a new Array instance with a variable number
	 * of arguments, regardless of number or type of the arguments.
	 *
	 * <p>
	 * The difference between Array.of() and the Array constructor is in the
	 * handling of integer arguments: Array.of(7) creates an array with a single
	 * element, 7, whereas Array(7) creates an array with 7 elements, each of
	 * which is undefined.
	 */
	@JsOverlay
	@SafeVarargs
	public static final <T> Array<T> of(T... values) {
		return new Array<>(values);
	}

	/**
	 * Implementing this interface allows an object to be the target of the
	 * "for-each loop" statement.
	 */
	@JsOverlay
	public final Iterable<T> iterable() {
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				return new ArrayIterator();
			}
		};
	}


	/**
	 * The {@link ArrayIterator} implements an {@link Iterator} for the JavaScript
	 * {@link Array}.
	 */
	private final class ArrayIterator implements Iterator<T> {

		private int index;

		/**
		 * <code>true</code> if another item is available.
		 */
		@Override
		public final boolean hasNext() {
			return index < getLength();
		}

		/**
		 * Return an item if available, otherwise returns <code>null</code>.
		 */
		@Override
		public final T next() {
			return hasNext() ? Array.this.get(index++) : null;
		}
	}
}