#!/bin/sh
set -e
mvn clean package
mvn --non-recursive com.github.github:site-maven-plugin:site
