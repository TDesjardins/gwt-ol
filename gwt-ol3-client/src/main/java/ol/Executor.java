/**
 *
 * @author mribeiro
 * @date 08/06/16 10:30
 *
 */
package ol;

import com.google.gwt.core.client.JavaScriptObject;
import jsinterop.annotations.JsType;

/**
 *
 */
@JsType
public class Executor {

    private final GenericFunction<JavaScriptObject, Void> function;

    public Executor(GenericFunction<JavaScriptObject, Void> function) {
        this.function = function;
    }

    public void action(JavaScriptObject object){
        function.call(object);
    }
}