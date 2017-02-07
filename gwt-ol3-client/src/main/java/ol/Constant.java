/*
 * Copyright (c) 2001-2017 Territorium Online Srl / TOL GmbH. All Rights Reserved.
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

package ol;

import java.util.Objects;

/**
 * This helper class provides a framework for converting to and from web value constants.
 */
public interface Constant<V> {

  /**
   * Retrieves the web value for this item.
   */
  public V getValue();

  /**
   * Convert a value into its web value.
   *
   * @param value - The value
   */
  public static <W, V extends Constant<W>> W of(final V value) {
    return value != null ? value.getValue() : null;
  }

  /**
   * Convert a literal back into its matching value.
   *
   * @param clazz - The class
   * @param literal - The literal
   */
  public static <W, V extends Enum<V> & Constant<W>> V of(final Class<V> clazz, final W literal) {
    for (V value : clazz.getEnumConstants()) {
      if (Objects.equals(value.getValue(), literal)) {
        return value;
      }
    }
    return null;
  }
}
