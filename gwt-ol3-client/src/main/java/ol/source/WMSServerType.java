package ol.source;

import tol.j2cl.elem.util.Constant;

/**
 * Available server types: `'carmentaserver'`, `'geoserver'`, `'mapserver'`,
 *     `'qgis'`. These are servers that have vendor parameters beyond the WMS
 *     specification that OpenLayers can make use of.
 * 
 * @author Peter Zanetti
 */
public enum WMSServerType implements Constant<String> {
  CARMENTA_SERVER ("carmentaserver"),
  GEOSERVER ("geoserver"),
  MAPSERVER ("mapserver"),
  QGIS ("qgis");
  
  private final String value;
  
  
	/**
	 * Constructs a(n) {@link WMSServerType} object.
	 *
	 * @param value
	 */
	 WMSServerType(final String value) {
		this.value = value;
	}


	@Override
	public String getValue() {
		return value;
	}
}


