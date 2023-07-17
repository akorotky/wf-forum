#!/bin/sh

# build a Docker image
mvn clean spring-boot:build-image -D skipTests

# push the image to Docker Hub repository
docker tag forum:0.0.1-SNAPSHOT akorotky/webforum:forum
docker push akorotky/webforum:forum
