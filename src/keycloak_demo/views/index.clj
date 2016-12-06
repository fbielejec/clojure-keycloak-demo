(ns keycloak-demo.views.index
  (:require [hiccup.form :refer :all]
            ;; [hiccup.element :refer (link-to)]
            [hiccup.page :refer (html5 include-css)]
            ))

(defn index [title & content]
  (html5 {:lang "en"}
         [:head
          [:title title]
          (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
          [:body
           [:div {:class "container"} content ]]]))
