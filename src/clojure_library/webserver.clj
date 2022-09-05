(ns clojure-library.webserver
  (:require
    [reitit.ring :as ring]
    [ring.adapter.jetty :as jetty]
    [integrant.core :as ig]))

(def default-config {:webserver/jetty  {:port    3000
                                        :join?   false
                                        :handler (ig/ref :webserver/routes)
                                        }
                     :webserver/routes {}
                     })

(defmethod ig/init-key :webserver/jetty [_ {:keys [port join? handler]}]
  (println "server running in port" port)
  (jetty/run-jetty handler {:port port :join? join?}))

(defmethod ig/halt-key! :webserver/jetty [_ server]
  (.stop server))

(defmethod ig/init-key :webserver/routes [_ _]
  (ring/ring-handler
    (ring/router
      ["/ping" {:get {:handler (fn [_] {:status 200 :body "pong!"})}}])))
