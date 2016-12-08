(ns keycloak-demo.views.protected
  (:require [hiccup.form :refer :all]
            [hiccup.element :refer (link-to)]
            [environ.core :refer [env]]
[clojure.tools.logging :as log]
            ))

     ; TODO: account manage | logout
(defn protected
  "View displayed on the /protected route."
  [token]
  (let [AUTH_URL "http://localhost:8180" BASE_URL "http://localhost:8080" REALM "4clojure"]

    [:div {:id "content"}

    [:a {:href (str AUTH_URL "/auth/realms/" REALM "/protocol/openid-connect/logout?redirect_uri=" BASE_URL "/keycloak-demo") } "Logout"]

     [:h1 {:class "text-success"} "This route is protected by keycloak."]
     [:h2 {:class "text-success"} "Token: " token]
     (link-to {:class "btn btn-primary"} "/keycloak-demo" "Home")
     ]))
