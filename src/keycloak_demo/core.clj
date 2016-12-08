(ns keycloak-demo.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [immutant.web :as web]
            [keycloak-demo.views.index :as index]
            [keycloak-demo.views.home :as home]
            [keycloak-demo.views.protected :as protected]
[clojure.tools.logging :as log]
            )
  (:gen-class))

(defn home-handler
  "Display home route."
  []
  (index/index "Home" (home/home)))

(defn get-token
  "Get the session token from http request."
  [request]
  (let [{servlet-request :servlet-request} request
        security-context (.getAttribute servlet-request "org.keycloak.KeycloakSecurityContext")
        id-token (.getIdToken security-context)]
    id-token))


;; {:servlet-context-path /keycloak-demo, :ssl-client-cert nil, :protocol HTTP/1.1, :remote-addr 127.0.0.1, :params {}, :servlet-context #object[org.apache.catalina.core.ApplicationContextFacade 0x1facd031 org.apache.catalina.core.ApplicationContextFacade@1facd031], :servlet-response #object[org.apache.catalina.connector.ResponseFacade 0x5759b8a3 org.apache.catalina.connector.ResponseFacade@5759b8a3], :servlet #object[keycloak_demo.servlet 0x7facc0cf keycloak_demo.servlet@7facc0cf], :route-params {}, :headers {referer http://localhost:8080/keycloak-demo, accept-language en-US,en;q=0.5, cookie JSESSIONID=C6B77571777B63A8027B067E1101280A, host localhost:8080, upgrade-insecure-requests 1, connection keep-alive, accept-encoding gzip, deflate, user-agent Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:48.0) Gecko/20100101 Firefox/48.0, accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8}, :server-port 8080, :servlet-request #object[org.apache.catalina.connector.RequestFacade 0x678ba53 org.apache.catalina.connector.RequestFacade@678ba53], :content-length nil, :compojure/route [:get /protected], :content-type nil, :path-info /protected, :character-encoding nil, :context /keycloak-demo, :uri /keycloak-demo/protected, :server-name localhost, :query-string nil, :body #object[org.apache.catalina.connector.CoyoteInputStream 0x7f740d06 org.apache.catalina.connector.CoyoteInputStream@7f740d06], :scheme :http, :request-method :get}



(defn protected-handler
  "Keycloak protected route."
  [request]

;;(log/debug (:referer (:headers request)))

  (try   
    (let [token (get-token request)] 
      (index/index "Protected" (protected/protected token)))
    (catch Exception e
      (str "<h1>" e "</h1>"))))

(defroutes app
  "The router."
  (GET "/" []
       (home-handler))
  (GET "/protected" [:as request]
       (protected-handler request ))
  (route/not-found
   "<h1>Page not found</h1>"))

