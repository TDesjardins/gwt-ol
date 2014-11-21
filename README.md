GWT-OL3-Playground
==================

A Playground for the new OpenLayers3-Wrapper for GWT using the new JSInterop-Features of the GWT-SDK 2.7.0.

You can build the application with Maven. If you would like to test superdev-mode you can run it on module gwt-ol-demo with the goal gwt:run-codeserver.

If you want to build the application without Maven please consider the following hints: 

Building the application with older GWT-SDK than 2.7.0 (e.g. SDK 2.6.1) will not work. You can download the latest SDK at http://www.gwtproject.org/versions.html

It is essential to compile the application with compiler args -XjsInteropMode JS.