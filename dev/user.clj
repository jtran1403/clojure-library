(ns user
  (:require
    [integrant.repl :as ig-repl]
    [clojure-library.webserver :as webserver]))

(ig-repl/set-prep! (constantly webserver/default-config))

(def go ig-repl/go)
(def halt ig-repl/halt)
(def reset ig-repl/reset)

(comment
  (go)
  (reset)
  (halt))
