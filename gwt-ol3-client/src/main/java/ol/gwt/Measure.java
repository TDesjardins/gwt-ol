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
import ol.interaction.DrawEvent;
import ol.interaction.DrawOptions;
import ol.style.Style;

/**
 * A class for measuring like the OpenLayers 2 Measure control.
 * @author sbaumhekel
 */
public class Measure {

    private com.google.gwt.user.client.EventListener chainedListener;
    private Draw draw;
    private boolean isActive;
    private MeasureListener listener;
    private final Map map;
    private Feature sketch;
    private Style style;
    private boolean eventListenerNeedsCleanup;

    /**
     * Constructs an instance.
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
            Geometry geom = sketch.getGeometry();
            if(geom != null) {
                listener.onMeasure(new MeasureEvent(geom));
            }
        }
    }

    /**
     * Get the {@link Style} to be used for drawing the measured geometry.
     * @return {@link Style}
     */
    public Style getStyle() {
        return this.style;
    }

    /**
     * Is measuring active?
     * @return true on success, else false
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Set the {@link Style} to be used for drawing the measured geometry.
     * Remember to set it before calling one of the start methods.
     * @param style
     *            {@link Style}
     */
    public void setStyle(Style style) {
        this.style = style;
    }

    /**
     * Start measuring using existing interaction.
     * @param type
     *            measure geometry type
     * @param listener
     *            {@link MeasureListener}
     * @param immediate
     *            Fire events on every change to the measured geometry? If false
     *            only one event after finishing is fired. (default is true)
     */
    private void start(String type, MeasureListener listener, boolean immediate) {
        this.listener = listener;
        // set up interaction
        DrawOptions drawOptions = OLFactory.createOptions();
        drawOptions.type(type);
        // use a special style?
        if(style != null) {
            drawOptions.style(style);
        }
        draw = OLFactory.createDraw(drawOptions);
        map.addInteraction(draw);
        // set up event handlers
        OLUtil.observe(draw, DrawEvent.DRAWSTART, new EventListener<DrawEvent>() {

            @Override
            public void onEvent(DrawEvent event) {
                // remember measure feature
                sketch = event.getFeature();
            }
        });
        OLUtil.observe(draw, DrawEvent.DRAWEND, new EventListener<DrawEvent>() {

            @Override
            public void onEvent(DrawEvent event) {
                // fire event and clean up
                fireMeasureEvent();
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
     * @param listener
     *            {@link MeasureListener}
     * @param immediate
     *            Fire events on every change to the measured geometry? If false
     *            only one event after finishing is fired. (default is true)
     */
    public void startMeasureArea(MeasureListener listener, boolean immediate) {
        start(Geometry.POLYGON, listener, immediate);
    }

    /**
     * Start measuring a length.
     * @param listener
     *            {@link MeasureListener}
     * @param immediate
     *            Fire events on every change to the measured geometry? If false
     *            only one event after finishing is fired. (default is true)
     */
    public void startMeasureLength(MeasureListener listener, boolean immediate) {
        start(Geometry.LINE_STRING, listener, immediate);
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
        // clean up interaction
        if(draw != null) {
            map.removeInteraction(draw);
            draw = null;
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
