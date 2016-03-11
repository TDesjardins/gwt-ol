/**
 * 
 */
package ol.format;

import ol.Options;
import ol.proj.Projection;

/**
 * Options for the GeoJSON
 * @author tlochmann
 *
 */
public interface  GeoJSONOptions extends Options
{
/**
 * @param projection
 */
void setDefaultDataProjection(Projection projection);
/**
 * @param geometryName 
 */
void setGeometryName(String geometryName);	



}
