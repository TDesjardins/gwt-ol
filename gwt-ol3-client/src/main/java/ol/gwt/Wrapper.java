package ol.gwt;

import jsinterop.annotations.JsType;

/**
 * A wrapper for an underlying OpenLayers object to allow extending its
 * functionality while still allowing it to be defined as a {@link JsType}
 * interface.
 * @author sbaumhekel
 * @param <T>
 *            type of the wrapped object
 */
public abstract class Wrapper<T> {

    protected final T impl;

    /**
     * Constructs an impl.
     * @param impl
     *            wrapped object
     */
    public Wrapper(T impl) {
        this.impl = impl;
    }

    /**
     * Gets the wrapped object.
     * @return wrapped object
     */
    public T getImpl() {
        return impl;
    }

}
