(ns clojure-library.core
  (:require [integrant.core :as ig]
            [clojure-library.webserver :as webserver])
  (:gen-class))

(defn -main
  "Opens the great gate of knowledge"
  [& args]
  (println "Starting library app!")
  (ig/init webserver/config)
  )
