# keycloak-demo

## Usage

lein uberwar

add keycloak.json to WEB-INF/

cp target/uberjar/keycloak-demo.war ~/Programs/apache-tomcat-8.5.8/webapps

http://localhost:8080/keycloak-demo/

## Tomcat keycloak adapter

* Copy the adapter jars inside lib/
* Inside lib/catalina.jar got to /org/apache/catalina/startup/Authenticators.properties and add there 
KEYCLOAK=org.keycloak.adapters.tomcat.KeycloakAuthenticatorValve  
* start Tomcat

Thanks to: https://blog-ungarida.rhcloud.com/keycloak-tomcat-adapter/

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
