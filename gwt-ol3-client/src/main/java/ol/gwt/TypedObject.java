/*******************************************************************************
 * Copyright 2014, 2015 gwt-ol3
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
package ol.gwt;

import com.google.gwt.core.client.JavaScriptObject;

import jsinterop.annotations.JsType;
import ol.OLFactory;

/**
 * A typed object, which could contain one of two types. This class is meant to
 * provide a type checking on function calls to OpenLayers native JavaScript
 * functions. Use {@link OLFactory#createObject1(Object)} or
 * {@link OLFactory#createObject2(Object)} to convert the function parameter.
 *
 * @author sbaumhekel
 * @param <T>
 *            first type
 * @param <U>
 *            second type
  * @deprecated use method overloading on {@link JsType} instead
 */
@Deprecated
public class TypedObject<T, U> extends JavaScriptObject {

    @Deprecated
    protected TypedObject() {
    }
    
}
