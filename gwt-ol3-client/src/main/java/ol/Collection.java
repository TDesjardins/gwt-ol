package ol;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;

/**
 *
 * @author Tino Desjardins
 * @param <T> type of the elements
 *
 */
@JsType(isNative = true)
public class Collection<T> extends Object {

    public native void clear();

    public native T[] getArray();

    public native int getLength();

    public native void insertAt(int index, T element);

    public native T item(int index);

    public native void pop();

    public native void push(T element);

    /**
     * Remove the first occurrence of an element from the collection.
     * 
     * @param element Element.
     * @return The removed element or undefined if none found.
     * @api stable
     */
    @Nullable
    public native T remove(T element);

    /**
     * Remove the element at the provided index and return it. Return
     * `undefined` if the collection does not contain this index.
     * 
     * @param index Index.
     * @return Value.
     * @api stable
     */
    @Nullable
    public native T removeAt(int index);

    public native void setAt(int index, T element);

}
