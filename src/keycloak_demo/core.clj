(ns keycloak-demo.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [immutant.web :as web]
            
            )
  (:gen-class))

(defn root-handler
  "Display token information from a http request."
  []
  (str "<h1>This is an unprotected route. Try the protected/ route to see keycloak authentication in action.</h1>"))

(defn get-token
  "Gets the session for the user"
  [request]
  (let [{servlet-request :servlet-request} request
        security-context (.getAttribute servlet-request "org.keycloak.KeycloakSecurityContext")
        id-token (.getIdToken security-context)]
    id-token))

(defn protected-handler
  "Keycloak protected route"
  [request]
  (try   
    (let [token (get-token request)] 
      (str "<h1>This route is protected by Keycloak."  "<h1>Token: " token "</h1>"))
    (catch Exception e
      (str "<h1>" e "</h1>"))))

(defroutes app
  "The router."
  (GET "/" []
       (root-handler))
  (GET "/protected" [:as request]
       (protected-handler request ))
  (route/not-found
   "<h1>Page not found</h1>"))

