# clojure-keycloak-demo

## Usage

# start tomcat on port 8080
bin/catalina.sh run -p 8080

# start keycloak on port 8180
bin/standalone.sh -Djboss.socket.binding.port-offset=100

lein uberwar

cp target/uberjar/keycloak-demo.war ~/Programs/apache-tomcat-8.5.8/webapps

http://localhost:8080/keycloak-demo/

Got to protected 
 
## License

Copyright © 2017 fbielejec

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
