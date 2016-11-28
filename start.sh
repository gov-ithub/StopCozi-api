#!/bin/sh

mvn clean install
java -jar target/StopCozi-api-1.0.0-SNAPSHOT.jar server server.yml
