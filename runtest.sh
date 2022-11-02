#!/bin/sh

rm test-output/*.*
java -cp "bin:lib/*" org.testng.TestNG testng.xml

