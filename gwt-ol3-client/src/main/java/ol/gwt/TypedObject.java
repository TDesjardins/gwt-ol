package ol.gwt;

import com.google.gwt.core.client.JavaScriptObject;

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
 */
public class TypedObject<T, U> extends JavaScriptObject {

    @Deprecated
    protected TypedObject() {
    }
    
}
