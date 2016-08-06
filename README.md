GWT-OpenLayers 3
==================

[![Build Status](https://travis-ci.org/TDesjardins/gwt-ol3.svg?branch=gwt%2F2.8)](https://travis-ci.org/TDesjardins/gwt-ol3)

A [OpenLayers 3](http://openlayers.org/ "OpenLayers 3 website") - Wrapper for GWT using the new [JSInterop](https://docs.google.com/document/d/10fmlEYIHcyead_4R1S5wKGs1t2I7Fnp_PaNaa7XTEk0/edit)-Features of the [GWT-SDK 2.8.0](http://www.gwtproject.org/release-notes.html#Release_Notes_2_8_0_BETA1 "Release notes"). The project consists of two parts:
  
  * a GWT wrapper for OpenLayers 3 (gwt-ol3-client)
  * a demo module for showing wrapper functionality (gwt-ol3-demo)

You can build (`mvn package`) and run (`mvn gwt:devmode`) the application using Maven.

If you want to build the application without Maven please consider the following hints: 

  * Building the application with older GWT-SDK than 2.8.0-beta1 (e.g. SDK 2.7.0) will not work. You can download the SDK 2.8.0-beta1 [here](http://goo.gl/62SeR5).
