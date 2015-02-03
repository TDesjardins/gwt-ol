package ol;

import ol.control.FullScreen;
import ol.control.MousePosition;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.control.ZoomSlider;
import ol.control.ZoomToExtent;
import ol.interaction.DragAndDrop;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.ImageWMS;
import ol.source.ImageWMSOptions;
import ol.source.MapQuest;
import ol.source.MapQuestOptions;
import ol.source.Stamen;
import ol.source.StamenOptions;
import ol.source.ImageStatic;
import ol.source.ImageStaticOptions;

/**
 * Factory to create GWT-OL3 instances from JavaScript based on OL3-Interfaces.
 * Can be also done with GIN.
 * When GWT supports Java 8 (hopefully in GWT 3.0) factory methods can directly created in the interfaces.
 *
 * @author Tino Desjardins
 *
 */
public class OLFactory {

    /** Map **/

    public static native <T> Map createMap(MapOptions mapOptions) /*-{
		return new $wnd.ol.Map(mapOptions);
    }-*/;

    public static native <T> MapOptions createMapOptions() /*-{
        return {};
    }-*/;

    /** Layers **/

    public static native <T> Image createImageLayer(LayerOptions layerOptions) /*-{
        return new $wnd.ol.layer.Image(layerOptions);
    }-*/;
    
    public static native <T> Tile createTileLayer(LayerOptions layerOptions) /*-{
		return new $wnd.ol.layer.Tile(layerOptions);
    }-*/;

    public static native <T> LayerOptions createLayerOptions() /*-{
        return {};
    }-*/;

    /** Sources **/

    public static native <T> ImageStatic createImageStaticSource(ImageStaticOptions imageStaticOptions) /*-{
		return new $wnd.ol.source.ImageStatic(imageStaticOptions);
	}-*/;
    
    public static native <T> ImageWMS createImageWMSSource(ImageWMSOptions imageWMSOptions) /*-{
        return new $wnd.ol.source.ImageWMS(imageWMSOptions);
    }-*/;
    
    public static native <T> MapQuest createMapQuestSource(MapQuestOptions mapQuestOptions) /*-{
		return new $wnd.ol.source.MapQuest(mapQuestOptions);
    }-*/;

    public static native <T> MapQuestOptions createMapQuestOptions() /*-{
		return {};
    }-*/;

    public static native <T> Stamen createStamenSource(StamenOptions stamenOptions) /*-{
        return new $wnd.ol.source.Stamen(stamenOptions);
    }-*/;

    public static native <T> StamenOptions createStamenOptions() /*-{
        return {};
    }-*/;

    /** Projection **/
    
    public static native <T> Projection createProjection(ProjectionOptions projectionOptions) /*-{
        return new $wnd.ol.proj.Projection(projectionOptions);
    }-*/;
    
    /** View **/

    public static native <T> View createView() /*-{
		return new $wnd.ol.View();
    }-*/;
    
    public static native <T> View createView(ViewOptions viewOptions) /*-{
        return new $wnd.ol.View(viewOptions);
    }-*/;

    /** Controls **/

    public static native <T> FullScreen createFullScreen() /*-{
		return new $wnd.ol.control.FullScreen();
    }-*/;

    public static native <T> MousePosition createMousePosition() /*-{
		return new $wnd.ol.control.MousePosition();
    }-*/;

    public static native <T> Rotate createRotate() /*-{
		return new $wnd.ol.control.Rotate();
    }-*/;

    public static native <T> ScaleLine createScaleLine() /*-{
		return new $wnd.ol.control.ScaleLine();
    }-*/;

    public static native <T> ZoomToExtent createZoomToExtent() /*-{
        return new $wnd.ol.control.ZoomToExtent();
    }-*/;

    public static native <T> ZoomSlider createZoomSlider() /*-{
		return new $wnd.ol.control.ZoomSlider();
    }-*/;

    /** Interactions **/

    public static native <T> DragAndDrop createDragAndDrop() /*-{
        return new $wnd.ol.interaction.DragAndDrop();
    }-*/;
    
    public static native <T> KeyboardPan createKeyboardPan() /*-{
        return new $wnd.ol.interaction.KeyboardPan();
    }-*/;

    public static native <T> KeyboardZoom createKeyboardZoom() /*-{
        return new $wnd.ol.interaction.KeyboardZoom();
    }-*/;

    /** Common **/

    /**
     * Creates a common object for options.
     *
     * @return common options object
     */
    public static native <T> T createOptions() /*-{
        return {};
    }-*/;
    
    /**
     * Creates a common object for params.
     *
     * @return common params object
     */
    public static native <T> T createParams() /*-{
        return {};
    }-*/;
    
    public static native <T> Collection<T> createCollection() /*-{
        return new $wnd.ol.Collection();
    }-*/; 
    
    /**
     * Creates a coordinate.
     *
     * @return coordParams coordinate params
     */
    public static double[] createCoordinate(double... coordParams) {
        return coordParams;
    };
    
    /**
     * Creates an extent.
     * 
     * @param minX
     * @param minY
     * @param maxX
     * @param maxY
     * @return
     */
    public static native double[] createExtent(double minX, double minY, double maxX, double maxY) /*-{
        return [minX, minY, maxX, maxY];
	}-*/;
    
    /**
     * Creates a size
     * 
     * @param width
     * @param height
     * @return size
     */
    public static native int[] createSize(int width, int height) /*-{
        return [width, height];
    }-*/;

}
