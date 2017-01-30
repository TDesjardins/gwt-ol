package ol.source;

import tol.j2cl.elem.util.Constant;

/**
 * State of the source, one of 'undefined', 'loading', 'ready' or 'error'.
 * 
 * @author Peter Zanetti
 */
public enum State implements Constant<String> {
		error("error"),
		loading("loading"),
		ready("ready"),
		undefined("undefined");

	private final String value;

	/**
	 * Constructs a(n) {@link State} object.
	 *
	 * @param value
	 */
	State(final String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
}
