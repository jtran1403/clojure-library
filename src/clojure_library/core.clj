(ns clojure-library.core
  (:require [integrant.core :as ig]
            [clojure.java.io :refer [resource]]
            [clojure-library.webserver :refer [default-config]]
            [utils.data :refer [deep-merge]])
  (:gen-class))

(defn -main
  "Opens the great gate of knowledge"
  [& args]
  (println "Starting library app!")
  (let [config (ig/read-string (slurp (resource "config.edn")))]
    (ig/init (deep-merge default-config config))
    )
  )
