GWT-OpenLayers 3
==================

[![Build Status](https://travis-ci.org/TDesjardins/gwt-ol3.svg?branch=master)](https://travis-ci.org/TDesjardins/gwt-ol3)

A [OpenLayers 3](http://openlayers.org/ "OpenLayers 3 website") - Wrapper for GWT using the experimental JSInterop-Features of the [GWT-SDK 2.7.0](http://www.gwtproject.org/versions.html "Link to GWT-SDK Downloads"). It is highly recommended to use the branch [master](https://github.com/TDesjardins/gwt-ol3/tree/master "GWT 2.8 branch of GWT-OpenLayers 3") which supports the final JSInterop Specification of [GWT 2.8.0](http://www.gwtproject.org/release-notes.html#Release_Notes_2_8_0_RC1 "Release Notes for 2.8.0 (RC1)").

The project consists of two parts:
  
  * a GWT wrapper for OpenLayers 3 (gwt-ol3-client)
  * a demo module for showing wrapper functionality (gwt-ol3-demo)

You can build (`mvn package`) and run (`mvn gwt:devmode`) the application using Maven.

If you want to build the application without Maven please consider the following hints: 

  * Building the application with older GWT-SDK than 2.7.0 (e.g. SDK 2.6.1) will not work. You can download the latest SDK at http://www.gwtproject.org/versions.html

  * It is essential to compile the application with compiler args `-XjsInteropMode JS`.
