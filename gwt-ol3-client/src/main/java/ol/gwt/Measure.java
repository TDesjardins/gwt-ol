/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol.gwt;

import org.gwtproject.event.shared.HandlerRegistration;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;
import ol.Feature;
import ol.MapBrowserEvent;
import ol.OLFactory;
import ol.OLUtil;
import ol.PluggableMap;
import ol.color.Color;
import ol.event.MeasureEvent;
import ol.event.MeasureListener;
import ol.geom.Geometry;
import ol.interaction.Draw;
import ol.interaction.DrawOptions;
import ol.interaction.Interaction;
import ol.layer.Vector;
import ol.layer.VectorLayerOptions;
import ol.proj.Projection;
import ol.style.Style;

/**
 * A class for measuring like the OpenLayers 2 Measure control.
 *
 * @author sbaumhekel
 */
@JsType(isNative = false)
public class Measure extends Interaction {

    /**
     * Projection for WGS84 geographic coordinates (EPSG:4326).
     */
    private static final Projection PROJECTION_LATLON = Projection.get("EPSG:4326");

    private Draw draw;

    private HandlerRegistration clickListener;

    private MeasureListener listener;

    private HandlerRegistration pointerMoveListener;

    private ol.layer.Vector persistOverlay;

    private Projection proj;

    private Feature sketch;

    private Style style;

    private MeasureType type;

    private boolean immediate;

    private boolean persist;

    /**
     * @param type
     * @param listener {@link MeasureListener}
     */
    @JsIgnore
    public Measure(MeasureType type, MeasureListener listener) {
        this(type, listener, true, true);
    }

    /**
     * @param type
     * @param listener {@link MeasureListener}
     * @param immediate
     *            Fire events on every change to the measured geometry? If false
     *            only one event after finishing is fired. (default is true)
     * @param persist
     *            Keep the temporary measurement sketch drawn after the
     *            measurement is complete. The geometry will persist until a new
     *            measurement is started, the control is deactivated, or
     *            {@link #deactivate()} is called.
     */
    public Measure(MeasureType type, MeasureListener listener, boolean immediate, boolean persist) {
        super(OLFactory.createOptions());
        this.type = type;
        this.listener = listener;
        this.immediate = immediate;
        this.persist = persist;
    }

    @Override
    public void setMap(PluggableMap map) {

        super.setMap(map);

        if (this.getActive()) {
            this.activate();
        }

    }

    /**
     * Fires a measure event.
     */
    private void fireMeasureEvent() {

        // check if measuring is active and properly set up
        if (this.getActive() && (this.sketch != null) && (this.listener != null)) {

            // get geometry in map projection
            Geometry geom = this.sketch.getGeometry();
            if (geom != null) {
                // transform it to lat/lon and fire event
                Geometry geomLatLon = geom.clone().transform(this.proj, PROJECTION_LATLON);
                this.listener.onMeasure(new MeasureEvent(geomLatLon));
            }

        }
    }

    /**
     * Get the {@link Style} to be used for drawing the measured geometry.
     *
     * @return style
     */
    public Style getStyle() {
        return this.style;
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
     *            {@link #deactivate()} is called.
     */
    private void activate() {

        // set up interaction
        DrawOptions drawOptions = OLFactory.createOptions();
        drawOptions.setType(this.type.getValue());
 
        // use a special style?
        if (this.style != null) {
            drawOptions.setStyle(this.style);
        }
        this.draw = new Draw(drawOptions);

        // persist measured features?
        if (this.persist) {

            this.persistOverlay = this.getPersistOverlay();
            this.getMap().addLayer(this.persistOverlay);

            if (style != null) {
                this.persistOverlay.setStyle(style);
            } else {
                // create a default style resembling the default editing style,
                // but adding a border to polygons
                Style sPoly = OLFactory.createStyle(OLFactory.createFill(new Color(255, 255, 255, 0.5)));
                Style sLine1 = OLFactory.createStyle(OLFactory.createStroke(new Color(255, 255, 255, 1), 5));
                Style sLine2 = OLFactory.createStyle(OLFactory.createStroke(new Color(0, 153, 255, 1), 3));
                // combine all styles
                Style[] styles = OLUtil.combineStyles(sPoly, sLine1, sLine2);
                this.persistOverlay.setStyles(styles);
            }

        }

        // set up projection to be used
        this.proj = this.getMap().getView().getProjection();

        this.getMap().addInteraction(this.draw);
        // set up event handlers
        OLUtil.observe(this.draw, "drawstart", (Draw.Event event) -> {

            // remember measure feature
            this.sketch = event.getFeature();
            // clean up overlay
            if (this.persistOverlay != null) {
                this.persistOverlay.<ol.source.Vector> getSource().clear(false);
            }

        });

        OLUtil.observe(draw, "drawend", (Draw.Event event) -> {

                // fire event and clean up
                this.fireMeasureEvent();
                // persist feature?
                if (this.persistOverlay != null) {
                    this.persistOverlay.<ol.source.Vector> getSource().addFeature(this.sketch);
                }
                this.sketch = null;

        });

        // handle mouse move if immediate updates are requested
        if (this.immediate) {

            this.pointerMoveListener = this.getMap().addPointerMoveListener((MapBrowserEvent event) -> {

                if (this.draw.getActive()) {
                    this.fireMeasureEvent();
                }

            });
            // this handler is necessary to support mobile devices without a mouse
            this.clickListener = this.getMap().addClickListener((MapBrowserEvent event) -> {

                if (this.draw.getActive()) {
                    this.fireMeasureEvent();
                }

            });
        }

    }

    private ol.layer.Vector getPersistOverlay() {

        if (this.persistOverlay == null) {
            VectorLayerOptions voptions = OLFactory.createLayerOptionsWithSource(OLFactory.createVectorSource());
            this.persistOverlay = new Vector(voptions);
        }

        return this.persistOverlay;

    }

    @Override
    public void setActive(boolean active) {

        boolean alreadyActive = getActive();
        super.setActive(active);

        if (active) {

            if (getMap() != null && !alreadyActive) {
                this.activate();
            }

        } else {
            this.deactivate();
        }

    }

    /**
     * Stop measuring.
     */
    private void deactivate() {

        // clean up
        this.sketch = null;
        this.proj = null;

        // clean up interaction
        if (this.draw != null) {
            this.getMap().removeInteraction(this.draw);
            this.draw = null;
        }

        if (this.clickListener != null) {
            this.clickListener.removeHandler();
        }
        if (this.pointerMoveListener != null) {
            this.pointerMoveListener.removeHandler();
        }

        // clean up overlay
        if (this.persistOverlay != null) {
            this.persistOverlay.<ol.source.Vector> getSource().clear(false);
            this.getMap().removeLayer(this.persistOverlay);
        }

    }

    public enum MeasureType {

        AREA("Polygon"),
        DISTANCE("LineString");

        private String value;

        private MeasureType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
