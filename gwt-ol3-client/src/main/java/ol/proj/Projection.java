package ol.proj;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Projection {
    
	public static native Projection newInstance(ProjectionOptions projectionOptions) /*-{
    	return new $wnd.ol.proj.Projection(projectionOptions);
	}-*/;
	
	public static native double[] transform(double[] coordinate, String source, String destination) /*-{
		return new $wnd.ol.proj.transform(coordinate, source, destination)
	}-*/;
	
    public abstract String getCode();
    
    public abstract double[] getExtent();
    
    public abstract void setExtent(double[] extent);
    
    public abstract double getMetersPerUnit();
    
    public abstract String getUnits();
    
    public abstract boolean isGlobal();

}

