(ns keycloak-demo.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [immutant.web :as web]
            [keycloak-demo.views.home :as home]
            )
  (:gen-class))

(defn home-handler
  "Display home route"
  []
(home/index "Home" (home/home)))

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
       (home-handler))
  (GET "/protected" [:as request]
       (protected-handler request ))
  (route/not-found
   "<h1>Page not found</h1>"))

