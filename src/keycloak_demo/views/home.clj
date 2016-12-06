(ns keycloak-demo.views.home
  (:require [hiccup.form :refer :all]
            [hiccup.element :refer (link-to)]
           ; [hiccup.page :refer (html5 include-css)]
            ))

;; (defn index [title & content]
;;   (html5 {:lang "en"}
;;          [:head
;;           [:title title]
;;           (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
;;           [:body
;;            [:div {:class "container"} content ]]]))

(defn home []
  [:div {:id "content"}
   [:h1 {:class "text-success"} "This route is unprotected."]
   (link-to {:class "btn btn-primary"} "/keycloak-demo/protected" "Go to protected")

   ])
