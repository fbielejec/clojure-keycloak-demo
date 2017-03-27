# clojure-keycloak-demo

## Usage

# start tomcat on port 8080
bin/catalina.sh run -p 8080

# start keycloak on port 8180
bin/standalone.sh -Djboss.socket.binding.port-offset=100

lein uberwar

cp target/uberjar/keycloak-demo.war ~/Programs/apache-tomcat-8.5.8/webapps

http://localhost:8080/keycloak-demo/

Got to protected user / password

## Tomcat keycloak adapter

* Copy the adapter jars inside lib/
* Inside lib/catalina.jar got to /org/apache/catalina/startup/Authenticators.properties and add there 
KEYCLOAK=org.keycloak.adapters.tomcat.KeycloakAuthenticatorValve  
* start Tomcat

Thanks to: https://blog-ungarida.rhcloud.com/keycloak-tomcat-adapter/

## Keycloak admin console

http://localhost:8180/auth/admin/

log in with admin / admin

Set root uri as:
/

Set valid redirect URIs as:
*

create a user with client role "user" in the realm e.g. filip / password

set a temp mail on https://www.guerrillamail.com/ and set the email for the user

## License

Copyright © 2017 fbielejec

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
