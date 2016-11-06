package ol.gwt;

import com.google.gwt.dom.client.Element;

import ol.Feature;
import ol.Map;
import ol.OLFactory;
import ol.OLUtil;
import ol.event.EventListener;
import ol.event.MeasureEvent;
import ol.event.MeasureListener;
import ol.geom.Geometry;
import ol.interaction.Draw;
import ol.interaction.DrawOptions;
import ol.layer.VectorLayerOptions;
import ol.proj.Projection;
import ol.style.Style;

/**
 * A class for measuring like the OpenLayers 2 Measure control.
 *
 * @author sbaumhekel
 */
public class Measure {

    /**
     * Projection for WGS84 geographic coordinates (EPSG:4326).
     */
    private static final Projection PROJECTION_LATLON = Projection.get("EPSG:4326");
    private com.google.gwt.user.client.EventListener chainedListener;
    private Draw draw;
    private boolean eventListenerNeedsCleanup;
    private boolean isActive;
    private MeasureListener listener;
    private final Map map;
    private ol.layer.Vector persistOverlay;
    private Projection proj;
    private Feature sketch;
    private Style style;

    /**
     * Constructs an instance.
     *
     * @param map
     *            {@link Map} to measure on
     */
    public Measure(Map map) {
        this.map = map;
    }

    /**
     * Fires a measure event.
     */
    private void fireMeasureEvent() {
        // check if measuring is active and properly set up
        if(isActive && (sketch != null) && (listener != null)) {
            // get geometry in map projection
            Geometry geom = sketch.getGeometry();
            if(geom != null) {
                // transform it to lat/lon and fire event
                Geometry geomLatLon = OLUtil.transform(geom.clone(), proj, PROJECTION_LATLON);
                listener.onMeasure(new MeasureEvent(geomLatLon));
            }
        }
    }

    /**
     * Get the {@link Style} to be used for drawing the measured geometry.
     *
     * @return {@link Style}
     */
    public Style getStyle() {
        return this.style;
    }

    /**
     * Is measuring active?
     *
     * @return true on success, else false
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Set the {@link Style} to be used for drawing the measured geometry.
     * Remember to set it before calling one of the start methods.
     *
     * @param style
     *            {@link Style}
     */
    public void setStyle(Style style) {
        this.style = style;
    }

    /**
     * Start measuring using existing interaction.
     *
     * @param type
     *            measure geometry type
     * @param listener
     *            {@link MeasureListener}
     * @param immediate
     *            Fire events on every change to the measured geometry? If false
     *            only one event after finishing is fired. (default is true)
     * @param persist
     *            Keep the temporary measurement sketch drawn after the
     *            measurement is complete. The geometry will persist until a new
     *            measurement is started, the control is deactivated, or
     *            {@link #stop()} is called.
     */
    private void start(String type, MeasureListener listener, boolean immediate, boolean persist) {

        // clean up old instance
        stop();

        this.listener = listener;
        // set up interaction
        DrawOptions drawOptions = OLFactory.createOptions();
        drawOptions.setType(type);
        // use a special style?
        if(style != null) {
            drawOptions.setStyle(style);
        }
        draw = OLFactory.createDraw(drawOptions);

        // persist measured features?
        if(persist) {
            // set up overlay options
            VectorLayerOptions voptions = OLFactory.createLayerOptionsWithSource(OLFactory.createVectorSource());
            if(style != null) {
                Style[] styles = new Style[1];
                styles[0] = style;
                voptions.setStyle(styles);
            } else {
                // create a default style resembling the default editing style,
                // but adding a border to polygons
                Style sPoly = OLFactory.createStyle(OLFactory.createFill(OLFactory.createColor(255, 255, 255, 0.5)));
                Style sLine1 = OLFactory.createStyle(OLFactory.createStroke(OLFactory.createColor(255, 255, 255, 1), 5));
                Style sLine2 = OLFactory.createStyle(OLFactory.createStroke(OLFactory.createColor(0, 153, 255, 1), 3));
                // combine all styles
                Style[] s = OLUtil.addStyle(OLUtil.combineStyles(sPoly, sLine1), sLine2);
                voptions.setStyle(s);
            }
            // create an overlay and attach it to the map
            persistOverlay = OLFactory.createVector(voptions);
            persistOverlay.setMap(map);
        }

        // set up projection to be used
        proj = map.getView().getProjection();
        
        map.addInteraction(draw);
        // set up event handlers
        OLUtil.observe(draw, "drawstart", new EventListener<Draw.Event>() {

            @Override
            public void onEvent(Draw.Event event) {
                // remember measure feature
                sketch = event.getFeature();
                // clean up overlay
                if(persistOverlay != null) {
                    persistOverlay.<ol.source.Vector> getSource().clear(false);
                }
            }
        });
        OLUtil.observe(draw, "drawend", new EventListener<Draw.Event>() {

            @Override
            public void onEvent(Draw.Event event) {
                // fire event and clean up
                fireMeasureEvent();
                // persist feature?
                if(persistOverlay != null) {
                    persistOverlay.<ol.source.Vector> getSource().addFeature(sketch);
                }
                sketch = null;
            }
        });
        // handle mouse move if immediate updates are requested
        if(immediate) {
            // enable mouse move events on the viewport
            Element elem = map.getViewport();
            com.google.gwt.user.client.Event.sinkEvents(elem, com.google.gwt.user.client.Event.ONMOUSEMOVE);
            // remember old event listener before chaining this listener
            // in-between
            chainedListener = com.google.gwt.user.client.Event.getEventListener(elem);
            com.google.gwt.user.client.Event.setEventListener(elem, new com.google.gwt.user.client.EventListener() {

                @Override
                public void onBrowserEvent(com.google.gwt.user.client.Event event) {
                    // check for mouse move events only
                    if(event.getType() == "mousemove") {
                        // check if interaction is active and fire event
                        if(draw.getActive()) {
                            fireMeasureEvent();
                        }
                    }
                    // call chained handler
                    if(chainedListener != null) {
                        chainedListener.onBrowserEvent(event);
                    }
                }
            });
            eventListenerNeedsCleanup = true;
        }
        // set flag
        isActive = true;
    }

    /**
     * Start measuring an area.
     *
     * @param listener
     *            {@link MeasureListener}
     */
    public void startMeasureArea(MeasureListener listener) {
        start("Polygon", listener, true, true);
    }

    /**
     * Start measuring an area.
     *
     * @param listener
     *            {@link MeasureListener}
     * @param immediate
     *            Fire events on every change to the measured geometry? If false
     *            only one event after finishing is fired. (default is true)
     * @param persist
     *            Keep the temporary measurement sketch drawn after the
     *            measurement is complete. The geometry will persist until a new
     *            measurement is started, the control is deactivated, or
     *            {@link #stop()} is called.
     */
    public void startMeasureArea(MeasureListener listener, boolean immediate, boolean persist) {
        start("Polygon", listener, immediate, persist);
    }

    /**
     * Start measuring a length.
     *
     * @param listener
     *            {@link MeasureListener}
     */
    public void startMeasureLength(MeasureListener listener) {
        start("LineString", listener, true, true);
    }

    /**
     * Start measuring a length.
     *
     * @param listener
     *            {@link MeasureListener}
     * @param immediate
     *            Fire events on every change to the measured geometry? If false
     *            only one event after finishing is fired. (default is true)
     * @param persist
     *            Keep the temporary measurement sketch drawn after the
     *            measurement is complete. The geometry will persist until a new
     *            measurement is started, the control is deactivated, or
     *            {@link #stop()} is called.
     */
    public void startMeasureLength(MeasureListener listener, boolean immediate, boolean persist) {
        start("LineString", listener, immediate, persist);
    }

    /**
     * Stop measuring.
     */
    public void stop() {
        // reset flag
        isActive = false;
        // clean up
        listener = null;
        sketch = null;
        proj = null;
        // clean up interaction
        if(draw != null) {
            map.removeInteraction(draw);
            draw = null;
        }
        // clean up overlay
        if(persistOverlay != null) {
            persistOverlay.<ol.source.Vector> getSource().clear(false);
            persistOverlay.setMap(null);
            persistOverlay = null;
        }
        // clean up event listener?
        if(eventListenerNeedsCleanup) {
            // try to remove chained event listener
            Element elem = map.getViewport();
            if(elem != null) {
                com.google.gwt.user.client.Event.setEventListener(elem, chainedListener);
            }
            chainedListener = null;
            eventListenerNeedsCleanup = false;
        }
    }

}
