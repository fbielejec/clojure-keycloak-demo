(ns keycloak-demo.views.home
  (:require [hiccup.form :refer :all]
            [hiccup.element :refer (link-to)]
            ))

(defn home
  "View displayed on the / route."
  []
  [:div {:id "content"}
   [:h1 {:class "text-success"} "This route is unprotected."]
   (link-to {:class "btn btn-primary"} "/keycloak-demo/protected" "Go to protected")])
