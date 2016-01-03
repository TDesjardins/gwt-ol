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
public interface Collection<T> extends Object {

    public void clear();

    public T[] getArray();

    public int getLength();

    public void insertAt(int index, T element);

    public T item(int index);

    public void pop();

    public void push(T element);

    /**
     * Remove the first occurrence of an element from the collection.
     * 
     * @param element Element.
     * @return The removed element or undefined if none found.
     * @api stable
     */
    @Nullable
    public T remove(T element);

    /**
     * Remove the element at the provided index and return it. Return
     * `undefined` if the collection does not contain this index.
     * 
     * @param index Index.
     * @return Value.
     * @api stable
     */
    @Nullable
    public T removeAt(int index);

    public void setAt(int index, T element);

}
