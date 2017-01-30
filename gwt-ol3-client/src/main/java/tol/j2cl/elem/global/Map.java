/*
 * Copyright (c) 2001-2017 Territorium Online Srl. All Rights Reserved.
 *
 * This file contains Original Code and/or Modifications of Original Code as defined in and that are
 * subject to the Territorium Online License Version 1.0. You may not use this file except in
 * compliance with the License. Please obtain a copy of the License at http://www.tol.info/license/
 * and read it before using this file.
 *
 * The Original Code and all software distributed under the License are distributed on an 'AS IS'
 * basis, WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESS OR IMPLIED, AND TERRITORIUM ONLINE HEREBY
 * DISCLAIMS ALL SUCH WARRANTIES, INCLUDING WITHOUT LIMITATION, ANY WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, QUIET ENJOYMENT OR NON-INFRINGEMENT. Please see the License for
 * the specific language governing rights and limitations under the License.
 */

package tol.j2cl.elem.global;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import java.util.Iterator;

/**
 * The {@link Map} object is a simple key/value map. Any value (both objects and primitive values)
 * may be used as either a key or a value.
 * 
 * @author Markus Brigl
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Map<T> {

  /**
   * Constructs an instance of {@link Map}.
   */
  @JsConstructor
  public Map() {}

  /**
   * Get the size of the associative array.
   */
  @JsOverlay
  public final int getSize() {
    return keys().getLength();
  }

  /**
   * Get the keys of the associative array.
   */
  @JsOverlay
  public final Array<String> keys() {
    return Global.keys(this);
  }

  /**
   * Get an element by name.
   *
   * @param name - The name
   */
  @JsOverlay
  public final T get(String name) {
    return Global.get(this, name);
  }

  /**
   * Set an element by name.
   *
   * @param name - The name
   * @param value - The value
   */
  @JsOverlay
  public final void set(String name, T value) {
    Global.set(this, name, value);
  }

  /**
   * Get an element by name.
   *
   * @param name - The name
   */
  @JsOverlay
  public final void unset(String name) {
    Global.unset(this, name);
  }

  /**
   * Implementing this interface allows an object to be the target of the "for-each loop" statement.
   */
  @JsOverlay
  public final Iterable<T> iterable() {
    return new Iterable<T>() {

      @Override
      public Iterator<T> iterator() {
        return new MapIterator();
      }
    };
  }

  /**
   * The {@link MapIterator} implements an {@link Iterator} for the JavaScript {@link Map}.
   */
  private final class MapIterator implements Iterator<T> {

    private final Array<String> keys;

    private int                 index;

    /**
     * Constructs an instance of {@link MapIterator}.
     *
     * @param map - The map
     */
    public MapIterator() {
      this.keys = Global.keys(Map.this);
    }

    /**
     * <code>true</code> if another item is available.
     */
    @Override
    public final boolean hasNext() {
      return index < keys.getLength();
    }

    /**
     * Return an item if available, otherwise returns <code>null</code>.
     */
    @Override
    public final T next() {
      return hasNext() ? Map.this.get(keys.get(index++)) : null;
    }
  }
}
