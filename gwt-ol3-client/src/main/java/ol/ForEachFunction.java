/*******************************************************************************
 * Copyright 2014, 2022 gwt-ol
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
package ol;

import jsinterop.annotations.JsFunction;

/**
 * Callback for {@link Collection#forEach(ForEachFunction)}
 */
@FunctionalInterface
@JsFunction
public interface ForEachFunction <T> {

    /**
     * @param item current item
     * @param index current index
     * @param array array
     */
    void call(T item, int index, T[] array);

}
