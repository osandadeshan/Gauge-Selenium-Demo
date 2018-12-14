@echo off
echo Executing Gauge UI Test Automation Suite.............

cd .. 

mvn test-compile gauge:execute -DspecsDir="specs" -Denv="dev"