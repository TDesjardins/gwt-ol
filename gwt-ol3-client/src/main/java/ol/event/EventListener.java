package ol.event;

import com.google.gwt.core.client.js.JsType;

@JsType
public abstract class EventListener<E extends Event> {

    protected abstract void on(E event);
    
    public static native <E extends Event> EventListener<E> createEventListener(EventListener<E> listener) /*-{
        return function(evt){
            listener.on(evt);
        }
    }-*/;
    
}

