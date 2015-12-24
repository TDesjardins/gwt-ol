package ol.gwt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ol.Collection;

/**
 * Wrapper for a {@link Collection}
 *
 * @author sbaumhekel
 * @param <T>
 *            type of the elements
 *
 */
public class CollectionWrapper<T> extends Wrapper<Collection<T>> implements java.util.Collection<T> {

    /**
     * Constructs an instance.
     *
     * @param impl
     *            {@link Collection}
     */
    public CollectionWrapper(Collection<T> impl) {
        super(impl);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#add(java.lang.Object)
     */
    @Override
    public boolean add(T e) {
        impl.push(e);
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#addAll(java.util.Collection)
     */
    @Override
    public boolean addAll(java.util.Collection<? extends T> c) {
        for (T e : c) {
            add(e);
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#clear()
     */
    @Override
    public void clear() {
        impl.clear();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#contains(java.lang.Object)
     */
    @Override
    public boolean contains(Object o) {
        int size = impl.getLength();
        for (int i = 0; i < size; i++) {
            T e = impl.item(i);
            if (e == null) {
                return (o == null);
            }
            if (e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#containsAll(java.util.Collection)
     */
    @Override
    public boolean containsAll(java.util.Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return impl.getLength() == 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#iterator()
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < impl.getLength();
            }

            @Override
            public T next() {
                if(hasNext()) {
                    T e = impl.item(current);
                    current++;
                    return e;
                }
                throw new NoSuchElementException();
            }

            /*
             * (non-Javadoc)
             * @see java.util.Iterator#remove()
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#remove(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object o) {
        return impl.remove((T)o) != null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.Collection#removeAll(java.util.Collection)
     */
    @Override
    public boolean removeAll(java.util.Collection<?> c) {
        boolean b = false;
        for(Object e : c) {
            b |= remove(e);
        }
        return b;
    }

    /*
     * (non-Javadoc)
     * @see java.util.Collection#retainAll(java.util.Collection)
     */
    @Override
    public boolean retainAll(java.util.Collection<?> c) {
        ArrayList<Object> lRemove = new ArrayList<Object>();
        // collect all elements to be removed
        for(Object e : this) {
            if(!c.contains(e)) {
                lRemove.add(e);
            }
        }
        boolean b = false;
        // remove them
        for(Object e : lRemove) {
            b |= remove(e);
        }
        return b;
    }

    /*
     * (non-Javadoc)
     * @see java.util.Collection#size()
     */
    @Override
    public int size() {
        return impl.getLength();
    }

    /*
     * (non-Javadoc)
     * @see java.util.Collection#toArray()
     */
    @Override
    public Object[] toArray() {
        return impl.getArray();
    }

    /*
     * (non-Javadoc)
     * @see java.util.Collection#toArray(java.lang.Object[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> E[] toArray(E[] a) {
        return (E[])impl.getArray();
    }

}
