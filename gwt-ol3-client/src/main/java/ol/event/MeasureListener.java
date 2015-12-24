package ol.event;

/**
 * A listener for map movements.
 * 
 * @author sbaumhekel
 */
public interface MeasureListener {

    /**
     * Fired on a change and the end of a measuring.
     * 
     * @param evt
     *            {@link MeasureEvent}
     */
    void onMeasure(MeasureEvent evt);

}
