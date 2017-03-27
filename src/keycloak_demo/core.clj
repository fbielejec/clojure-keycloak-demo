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

(defn protected-handler
  "Keycloak protected route."
  []
  (index/index "Protected" (protected/protected)))

(defroutes app
  "The router."
  (GET "/" []
       (home-handler))
  (GET "/protected" []
       (protected-handler))
  (route/not-found
   "<h1>Page not found</h1>"))

