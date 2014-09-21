package ol;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Collection<T> extends Object {
    
    void clear();
    
    int getLength();
    
    void insertAt(int index, T element);
    
    T item(int index);
    
    void pop();
    
    void push(T element);
    
    void remove(T element);
    
    void removeAt(int index);
    
    void setAt(int index, T element);
    
}

