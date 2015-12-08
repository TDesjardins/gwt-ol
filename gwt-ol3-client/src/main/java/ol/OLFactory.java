package ol;

import javax.annotation.Nullable;

import com.google.gwt.core.client.JsArray;

import ol.control.FullScreen;
import ol.control.MousePosition;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.control.ZoomSlider;
import ol.control.ZoomToExtent;
import ol.geom.*;
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
import ol.source.Xyz;
import ol.source.XyzOptions;

/**
 * Factory to create GWT-OL3 instances from JavaScript based on OL3-Interfaces. Can be also done with GIN. When GWT
 * supports Java 8 (hopefully in GWT 3.0) factory methods can directly created in the interfaces.
 * @author Tino Desjardins
 */
public class OLFactory
{

	/** Map **/

	public static native Map createMap(MapOptions mapOptions) /*-{
		return new $wnd.ol.Map(mapOptions);
	}-*/;

	public static native MapOptions createMapOptions() /*-{
		return {};
	}-*/;

	/** Layers **/

	public static native Image createImageLayer(LayerOptions layerOptions) /*-{
		return new $wnd.ol.layer.Image(layerOptions);
	}-*/;

	public static native Tile createTileLayer(LayerOptions layerOptions) /*-{
		return new $wnd.ol.layer.Tile(layerOptions);
	}-*/;

	public static native LayerOptions createLayerOptions() /*-{
		return {};
	}-*/;

	/** Sources **/

	public static native ImageStatic createImageStaticSource(ImageStaticOptions imageStaticOptions) /*-{
		return new $wnd.ol.source.ImageStatic(imageStaticOptions);
	}-*/;

	public static native ImageWMS createImageWMSSource(ImageWMSOptions imageWMSOptions) /*-{
		return new $wnd.ol.source.ImageWMS(imageWMSOptions);
	}-*/;

	public static native MapQuest createMapQuestSource(MapQuestOptions mapQuestOptions) /*-{
		return new $wnd.ol.source.MapQuest(mapQuestOptions);
	}-*/;

	public static native MapQuestOptions createMapQuestOptions() /*-{
		return {};
	}-*/;

	public static native Stamen createStamenSource(StamenOptions stamenOptions) /*-{
		return new $wnd.ol.source.Stamen(stamenOptions);
	}-*/;

	public static native StamenOptions createStamenOptions() /*-{
		return {};
	}-*/;

	public static native Xyz createXyz(XyzOptions xyzOptions) /*-{
		return new $wnd.ol.source.XYZ(xyzOptions);
	}-*/;

	/** Projection **/

	public static native Projection createProjection(ProjectionOptions projectionOptions) /*-{
		return new $wnd.ol.proj.Projection(projectionOptions);
	}-*/;

	/** View **/

	public static native View createView() /*-{
		return new $wnd.ol.View();
	}-*/;

	public static native View createView(ViewOptions viewOptions) /*-{
		return new $wnd.ol.View(viewOptions);
	}-*/;

	/** Controls **/

	public static native FullScreen createFullScreen() /*-{
		return new $wnd.ol.control.FullScreen();
	}-*/;

	public static native MousePosition createMousePosition() /*-{
		return new $wnd.ol.control.MousePosition();
	}-*/;

	public static native Rotate createRotate() /*-{
		return new $wnd.ol.control.Rotate();
	}-*/;

	public static native ScaleLine createScaleLine() /*-{
		return new $wnd.ol.control.ScaleLine();
	}-*/;

	public static native ZoomToExtent createZoomToExtent() /*-{
		return new $wnd.ol.control.ZoomToExtent();
	}-*/;

	public static native ZoomSlider createZoomSlider() /*-{
		return new $wnd.ol.control.ZoomSlider();
	}-*/;

	/** Interactions **/

	public static native DragAndDrop createDragAndDrop() /*-{
		return new $wnd.ol.interaction.DragAndDrop();
	}-*/;

	public static native KeyboardPan createKeyboardPan() /*-{
		return new $wnd.ol.interaction.KeyboardPan();
	}-*/;

	public static native KeyboardZoom createKeyboardZoom() /*-{
		return new $wnd.ol.interaction.KeyboardZoom();
	}-*/;

	/** Common **/

	/**
	 * Creates a common object for options.
	 * @return common options object
	 */
	public static native <T> T createOptions() /*-{
		return {};
	}-*/;

	/**
	 * Creates a common object for params.
	 * @return common params object
	 */
	public static native <T> T createParams() /*-{
		return {};
	}-*/;

	public static native <T> Collection<T> createCollection() /*-{
		return new $wnd.ol.Collection();
	}-*/;

	/**
	 * Constructs an instance.
	 * @param x X-coordinate (longitude)
	 * @param y Y-coordinate (latitude)
	 * @return {@link Coordinate}
	 */
	public static native Coordinate createCoordinate(double x, double y)
	/*-{
		return [ x, y ];
	}-*/;

	/**
	 * Constructs an instance.
	 * @param x X-coordinate (longitude)
	 * @param y Y-coordinate (latitude)
	 * @param z Z-coordinate
	 * @return {@link Coordinate}
	 */
	public static native Coordinate createCoordinate(double x, double y, double z)
	/*-{
		return [ x, y, z ];
	}-*/;

	/**
	 * Constructs an instance.
	 * @param coords coordinate array
	 * @return {@link Coordinate}
	 */
	public static Coordinate createCoordinate(double[] coords)
	{
		if (coords.length > 2)
		{
			return createCoordinate(coords[0], coords[1], coords[2]);
		}
		else
		{
			return createCoordinate(coords[0], coords[1]);
		}
	}

	/**
	 * Creates an extent.
	 * @param minX
	 * @param minY
	 * @param maxX
	 * @param maxY
	 * @return {@link Extent}
	 */
	public static native Extent createExtent(double minX, double minY, double maxX, double maxY) /*-{
		return [ minX, minY, maxX, maxY ];
	}-*/;

	/**
	 * Creates a size
	 * @param width
	 * @param height
	 * @return size
	 */
	public static native int[] createSize(int width, int height) /*-{
		return [ width, height ];
	}-*/;

	/**
	 * Constructs an instance.
	 * @param coordinates coordinates
	 * @param geometryLayout geometry layout
	 * @return {@link LineString}
	 */
	public static native LineString createLineString(@Nullable JsArray<Coordinate> coordinates,
			@Nullable String geometryLayout)
			/*-{
		return $wnd.ol.geom.LineString(coordinates, geometryLayout);
	}-*/;

	/**
	 * Constructs an instance.
	 * @param coordinates coordinates
	 * @param geometryLayout geometry layout
	 * @return {@link Point}
	 */
	public static native Point createPoint(@Nullable Coordinate coordinates, @Nullable String geometryLayout)
	/*-{
		return $wnd.ol.geom.Point(coordinates, geometryLayout);
	}-*/;

	/**
	 * Constructs an instance.
	 * @param x X-coordinate (longitude)
	 * @param y Y-coordinate (latitude)
	 * @return {@link Coordinate}
	 */
	public static Point createPoint(double x, double y)
	{
		return createPoint(createCoordinate(x, y), getGeometryLayout(2));
	}

	/**
	 * Constructs an instance.
	 * @param x X-coordinate (longitude)
	 * @param y Y-coordinate (latitude)
	 * @param z Z-coordinate
	 * @return {@link Coordinate}
	 */
	public static Point createPoint(double x, double y, double z)
	{
		return createPoint(createCoordinate(x, y, z), getGeometryLayout(3));
	}

	/**
	 * Gets the geometry layout string for the given dimension.
	 * @param dim dimension (i.e. 2 or 3)
	 * @return geometry layout string
	 */
	public static String getGeometryLayout(int dim)
	{
		if (dim > 2)
		{
			return "XYZ";
		}
		return "XY";
	}

	/**
	 * Gets the geometry layout string for the given dimension.
	 * @param dim dimension (i.e. 2 or 3)
	 * @param measure include measure 'M' coordinate?
	 * @return geometry layout string
	 */
	public static String getGeometryLayout(int dim, boolean measure)
	{
		if (measure)
		{
			if (dim > 2)
			{
				return "XYZM";
			}
			return "XYM";
		}
		else
		{
			if (dim > 2)
			{
				return "XYZ";
			}
			return "XY";
		}
	}
}
