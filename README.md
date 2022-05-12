GWT-OpenLayers 3+
==================

[![Build Status](https://github.com/TDesjardins/gwt-ol/workflows/Build/badge.svg)](https://github.com/TDesjardins/gwt-ol/actions)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.tdesjardins/gwt-ol3.svg?colorB=44cc11)](https://search.maven.org/artifact/com.github.tdesjardins/gwt-ol3)
[![Join the chat at https://gitter.im/gwt-ol3/Lobby](https://badges.gitter.im/gwt-ol3/Lobby.svg)](https://gitter.im/gwt-ol3/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

With **gwt-ol** you can write fast mapping applications for web and mobile in pure Java. Technically speaking, it is a GWT wrapper for [OpenLayers 3+](http://openlayers.org/ "OpenLayers website") using the [JSInterop](https://docs.google.com/document/d/10fmlEYIHcyead_4R1S5wKGs1t2I7Fnp_PaNaa7XTEk0/edit)-Features of the [GWT-SDK](http://www.gwtproject.org/release-notes.html#Release_Notes_2_8_0 "Release notes"). The project consists of two parts:
  
  * a GWT wrapper for OpenLayers 3+ (gwt-ol3-client)
  * a demo module for showing wrapper functionality (gwt-ol3-demo)

You can build (`mvn package`) and run (`mvn gwt:devmode`) the application using Maven.

If you want to build the application without Maven please consider the following hints: 

  * Building the application with older GWT-SDK than 2.8.0-beta1 will not work. You can download the latest SDK [here](http://www.gwtproject.org/versions.html).

## Demo App
[GWT-OL live example](https://tdesjardins.github.io/gwt-ol-demo-site/)

## Project Setup

### Maven dependency
```xml
<dependency>
  <groupId>com.github.tdesjardins</groupId>
  <artifactId>gwt-ol3</artifactId>
  <version>[x.x.x]</version>
</dependency>
```
Replace `[x.x.x]` with the gwt-ol version you want to use.
### GWT module

```xml
  <inherits name='ol.GwtOL'/>
```
optional: add this line for proj4js support
```xml
  <inherits name="proj4.GwtProj4"/>
```

### Resources

```html
  <link href="//cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v[x.x.x]/css/ol.css" rel="stylesheet" type="text/css">
  <script src="//cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v[x.x.x]/build/ol.js" type="text/javascript"></script>
```
Replace `[x.x.x]` with the OpenLayers version you want to use.

## Download

Releases are deployed to [the Central Repository][dl].

Snapshots of the development version are available in 
[Sonatype's `snapshots` repository][snap].


 [dl]: https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.tdesjardins%22
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
 
## Projects using gwt-ol

[Running Reality](https://www.runningreality.org/)  
[Mapping of Covid19 spread in Italy](https://www.k-teq.com/covid19/)
