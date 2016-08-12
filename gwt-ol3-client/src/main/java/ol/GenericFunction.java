/**
 *
 * @author mribeiro
 * @date 07/06/16 16:45
 *
 */
package ol;

import jsinterop.annotations.JsFunction;

/**
 * @author mribeiro
 *         19-05-2016.
 */
@JsFunction
public interface GenericFunction<T, E> {
    E call(T object);
}