package de.desjardins.ol3.demo.client.utils;

import ol.Collection;
import ol.OLFactory;
import ol.control.Control;

/**
 * 
 * @author Tino Desjardins
 *
 */
public final class DemoUtils {
    
    private DemoUtils() {
        throw new AssertionError();
    }
    
    /**
     * Creates some default controls.
     * 
     * @param controls
     */
    public static void addDefaultControls(final Collection<Control> controls) {

        controls.push(OLFactory.createFullScreen());
        controls.push(OLFactory.createZoomSlider());
        controls.push(OLFactory.createMousePosition());
        controls.push(OLFactory.createZoomToExtent());

    }
    
}
