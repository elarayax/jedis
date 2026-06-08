#!/bin/bash
cd jedis
./mvnw spring-boot:run > /dev/null 2>&1 &

cd ../sables
./mvnw spring-boot:run > /dev/null 2>&1 &