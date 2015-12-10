package ol.gwt;

import com.google.gwt.core.client.JavaScriptObject;

import ol.*;
import ol.event.Event;

/**
 * Wrapper for creating a {@link MapEvent} out of an {@link Event} while still
 * forwarding all methods to the underlying event.
 * 
 * @author sbaumhekel
 */
public class MapEventWrapper extends Wrapper<Event> implements MapEvent {

    private final Map map;
    private final String type;

    /**
     * Constructs an instance.
     * 
     * @param map
     *            {@link Map}
     * @param type
     *            event type
     * @param event
     *            {@link Event}
     */
    public MapEventWrapper(Map map, String type, Event event) {
	super(event);
	this.type = type;
	this.map = map;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ol.event.Event#defaultPrevented()
     */
    @Override
    public boolean defaultPrevented() {
	return impl.defaultPrevented();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ol.event.Event#getCurrentTarget()
     */
    @Override
    public JavaScriptObject getCurrentTarget() {
	return (JavaScriptObject) map;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ol.MapEvent#getMap()
     */
    @Override
    public Map getMap() {
	return this.map;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ol.event.Event#getTarget()
     */
    @Override
    public JavaScriptObject getTarget() {
	return impl.getTarget();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ol.event.Event#getType()
     */
    @Override
    public String getType() {
	return this.type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ol.event.Event#preventDefault()
     */
    @Override
    public void preventDefault() {
	impl.preventDefault();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ol.event.Event#stopPropagation()
     */
    @Override
    public void stopPropagation() {
	impl.stopPropagation();
    }

}
