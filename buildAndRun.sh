#!/bin/sh
mvn clean package && docker build -t com.airhacks/jug_workshop .
docker rm -f jug_workshop || true && docker run -d -p 8080:8080 -p 4848:4848 --name jug_workshop com.airhacks/jug_workshop 
