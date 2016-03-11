/**
 * 
 */
package ol.format;

import ol.Options;
import ol.proj.Projection;

/**
 * Options for the GeoJSON.
 * @author tlochmann
 *
 */
public interface  GeoJSONFeatureOptions extends Options
{
/**
 * @param projection
 */
void setDataProjection(Projection projection);
/**
 * @param projection
 */
void setFeatureProjection(Projection projection);	
/**
 * @param rightHanded 
 */
void setRightHanded(boolean rightHanded);		



}
