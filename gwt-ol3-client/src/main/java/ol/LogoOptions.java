package ol;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author <a href="mailto:peter.zanetti@tol.bz.it">Peter Zanetti</a>.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class LogoOptions implements Options {

    /**
     * {@link #setHref}
     *
     * @param href Link url for the logo. Will be followed when the logo is clicked
     */
    @JsProperty
    public native void setHref(String href);

    @JsProperty
    public native String getHref();

    /**
     * {@link #setSrc}
     *
     * @param src Image src for the logo.
     */
    @JsProperty
    public native void setSrc(String src);

    @JsProperty
    public native String getScr();
}
