package com.github.tdesjardins.ol3.demo.client;

import com.github.tdesjardins.ol3.demo.client.example.OL3ExampleType;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

/**
 * EntryPoint for playing with GwtOL3-Features.
 *
 * @author Tino Desjardins
 */
public class GwtOL3Playground implements EntryPoint {

    @Override
    public void onModuleLoad() {

        // choose your example
        TabLayoutPanel tabs = new TabLayoutPanel(27, Style.Unit.PX);
        for (OL3ExampleType example : OL3ExampleType.values()) {
            tabs.add(new LazyExampleWidget(example), example.name().replace("Example", ""));
        }
        RootLayoutPanel.get().add(tabs);
    }

    private static class LazyExampleWidget extends SimplePanel {

        private final OL3ExampleType example;
        private boolean initialized = false;

        private LazyExampleWidget(OL3ExampleType example) {
            this.example = example;
            this.setSize("100%", "100%");
            this.getElement().setId(example.getExample().toString());
            // set tabindex to "0" to make it focusable (needed for keyboard navigation)
            this.getElement().setTabIndex(0);
        }

        @Override public void setVisible(boolean visible) {
            if (visible && !initialized) {
                Scheduler.get().scheduleDeferred(() -> example.getExample().show(example.getExample().toString()));
                initialized = true;
            }
            super.setVisible(visible);
        }

    }
}
