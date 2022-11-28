(ns clojure-library.webserver
  (:require
    [reitit.ring :as ring]
    [ring.adapter.jetty :as jetty]
    [integrant.core :as ig]
    [clojure-library.book :as books]))

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
  (println "stopped server")
  (.stop server))

(defn init-routes []
  (ring/ring-handler
    (ring/router [books/routes
                  ["/ping" {:get {:handler (fn [_] {:status 200 :body "pong!"})}}]
                  ["/" {:get {:handler (fn [_] {:status 200 :body "welcome to the library"})}}]])
    (constantly {:status 404, :body "Book of the void"})))

(defmethod ig/init-key :webserver/routes [_ _]
  (clojure.pprint/pprint "Started webserver")
  (init-routes))
