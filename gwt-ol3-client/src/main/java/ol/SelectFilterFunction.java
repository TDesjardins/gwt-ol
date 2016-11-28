/**
 *
 * @author mribeiro
 * @date 07/06/16 16:45
 *
 */
package ol;

import jsinterop.annotations.JsFunction;
import ol.layer.Layer;

/**
 * @author mribeiro
 *         25-11-2016.
 */
@JsFunction
public interface SelectFilterFunction {
    boolean call(Feature feature, Layer layer);
}