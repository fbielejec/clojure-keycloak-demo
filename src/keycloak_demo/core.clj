(ns keycloak-demo.core
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [immutant.web :as web]
            [keycloak-demo.views.index :as index]
            [keycloak-demo.views.home :as home]
            [keycloak-demo.views.protected :as protected]
            [clojure.tools.logging :as log]))

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

(defn protected-handler
  "Keycloak protected route."
  [request]
  (try   
    (let [token (get-token request)] 
      (index/index "Protected" (protected/protected token)))
    (catch Exception e
      (log/error e)
      (str "<h1>" e "</h1>"))))

(defroutes app
  "The router."
  (GET "/" []
       (home-handler))
  (GET "/protected" [:as request]
       (protected-handler request ))
  (route/not-found
   "<h1>Page not found</h1>"))

