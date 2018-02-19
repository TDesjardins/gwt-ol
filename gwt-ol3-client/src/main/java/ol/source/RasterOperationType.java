/**
 * 
 */
package ol.source;

/**
 * Raster operation type. Supported values are 'pixel' and 'image'.
 * 
 * @author Daniel Eggert (daniel.eggert@gfz-potsdam.de)
 *
 */
public enum RasterOperationType {

	/**
	 * operations will be called with an array of pixels from input sources
	 */
	PIXEL,
	/**
	 * operations will be called with an array of ImageData objects from input sources
	 */
	IMAGE;

	/**
	 * Returns the value of this type as a lower case string.
	 * 
	 * @return
	 */
	public String getValue() {
		return this.toString().toLowerCase();
	}

	/**
	 * Returns the enum value for the given string value.
	 * 
	 * @param type
	 * @return
	 */
	public static RasterOperationType fromString(String type) {
		for (RasterOperationType roType : values()) {
			if (roType.getValue().equals(type)) {
				return roType;
			}
		}

		return null;
	}
}
