(ns keycloak-demo.views.protected
  (:require [hiccup.form :refer :all]
            [hiccup.element :refer (link-to)]
            [environ.core :refer [env]]
            [clojure.tools.logging :as log]
            [cemerick.url :refer (url url-encode)]))

(defn protected
  "View displayed on the /protected route."
  []  
  [:div {:id "content"} 
   [:h1 {:class "text-success"} "Omg, omg anybody can see this!"]
   (link-to {:class "btn btn-primary"} "/keycloak-demo" "Home")])


