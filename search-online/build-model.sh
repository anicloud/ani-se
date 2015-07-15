#!/bin/bash

# mvn clean
mvn install \
	-Dmaven.test.skip=true
mvn jar:jar

