package ol.source;

import java.util.Objects;

/**
 * Available server types: `'carmentaserver'`, `'geoserver'`, `'mapserver'`,
 *     `'qgis'`. These are servers that have vendor parameters beyond the WMS
 *     specification that OpenLayers can make use of.
 * 
 * @author Peter Zanetti
 */
public enum WMSServerType  {
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


	public String getValue() {
		return value;
	}
	
	public static final WMSServerType getInstance(String value){
    for (WMSServerType wmsServerType : WMSServerType.class.getEnumConstants()) {
      if (Objects.equals(wmsServerType.getValue(), value)) {
        return wmsServerType;
      }
    }
    return null;
	}
}


