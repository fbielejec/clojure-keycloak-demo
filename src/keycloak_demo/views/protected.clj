(ns keycloak-demo.views.protected
  (:require [hiccup.form :refer :all]
            [hiccup.element :refer (link-to)]
            ))


(defn protected 
  [token]
  [:div {:id "content"}
   ;; TODO: account manage | logout
   [:h1 {:class "text-success"} "This route is protected by keycloak."]
   [:h2 {:class "text-success"} "Token: " token]
   (link-to {:class "btn btn-primary"} "/keycloak-demo" "Home")
   ])
