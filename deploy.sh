#!/bin/bash

lein clean
lein uberwar
cp target/uberjar/keycloak-demo.war ~/Programs/apache-tomcat-8.5.8/webapps

exit $?
