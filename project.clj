(defproject keycloak-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha12"]
                 [compojure "1.4.0"]                                    
                 [org.immutant/web "2.1.5"]
                 [environ "1.1.0"]

                 ]
  :plugins [
            [lein-uberwar "0.1.0"]
            ]
  :target-path "target/%s"
  :profiles {
             :uberjar {:aot :all}            
             :test {:dependencies [
                                   [ring/ring-mock "0.3.0"]
                                   ]}
             }
  :main ^:skip-aot keycloak-demo.core
  :ring {:handler keycloak-demo.core/app}
  :uberwar {:handler keycloak-demo.core/app
            :web-xml "web.xml" 
            :name "keycloak-demo.war"}
 ; :servlet-resources-path "keycloak.json"

  )
