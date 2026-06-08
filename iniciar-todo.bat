@echo off
cd jedis
start cmd /k "mvnw spring-boot:run"

cd ../sables
start cmd /k "mvnw spring-boot:run"