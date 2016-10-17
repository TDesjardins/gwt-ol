package ol.format;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;
import ol.Feature;
import ol.Options;

/**
 * Geometry format for reading and writing data in the WellKnownText (WKT)
 * format.
 *
 * @author Elena Guandalini
 *
 */

/**
 * The {@link WKT} class is used
 * 
 * for reading and writing data in the WellKnownText (WKT) format.
 * 
 */
@JsType(isNative = true)
public class WKT extends Feature {

	/**
	 * 
	 * Constructs a(n) {@link WKT} object.
	 * 
	 */
	public WKT() {};

	/**
	 * 
	 * Read a feature from a WKT source.
	 * 
	 * @param source
	 * @param opt_options
	 * @return
	 */
	public native Feature readFeature(java.lang.Object source, @Nullable Options opt_options);
}
