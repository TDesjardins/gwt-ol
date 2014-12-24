package ol;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Object extends Observable {
    
    <T> ObjectAccessor bindTo(String key, T target);
    
}

