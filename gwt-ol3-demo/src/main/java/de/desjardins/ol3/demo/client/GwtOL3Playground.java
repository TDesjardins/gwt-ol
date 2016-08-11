package de.desjardins.ol3.demo.client;

import com.google.gwt.core.client.EntryPoint;
import de.desjardins.ol3.demo.client.example.OL3ExampleType;

/**
 * EntryPoint for playing with GwtOL3-Features.
 *
 * @author Tino Desjardins
 *
 */
public class GwtOL3Playground implements EntryPoint {

    @Override
    public void onModuleLoad() {

        // choose your example
        OL3ExampleType exampleType = OL3ExampleType.XyzExample;
        exampleType.getExample().show();

    }

}
