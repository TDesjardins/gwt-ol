GWT-OpenLayers 3
==================

[![Build Status](https://travis-ci.org/TDesjardins/gwt-ol3.svg?branch=master)](https://travis-ci.org/TDesjardins/gwt-ol3)

A [OpenLayers 3](http://openlayers.org/ "OpenLayers 3 website") - Wrapper for GWT using the new JSInterop-Features of the [GWT-SDK 2.7.0](http://www.gwtproject.org/versions.html "Link to GWT-SDK Downloads"). There is also a [branch](https://github.com/TDesjardins/gwt-ol3/tree/gwt/2.8) for the final JSInterop Specification of GWT 2.8.0.

The project consists of two parts:
  
  * a GWT wrapper for OpenLayers 3 (gwt-ol3-client)
  * a demo module for showing wrapper functionality (gwt-ol3-demo)

You can build and run the application with Maven. If you would like to test superdev-mode you can run it on module `gwt-ol-demo` with the goal `gwt:run`. To only start the codeserver, e.g. using superdev-mode with your servlet container, use goal `gwt:run-codeserver`.

If you want to build the application without Maven please consider the following hints: 

  * Building the application with older GWT-SDK than 2.7.0 (e.g. SDK 2.6.1) will not work. You can download the latest SDK at http://www.gwtproject.org/versions.html

  * It is essential to compile the application with compiler args `-XjsInteropMode JS`.
