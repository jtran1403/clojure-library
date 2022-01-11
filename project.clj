(defproject clojure-library "0.1.1-SNAPSHOT"
  :description "Clojure basics"
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot clojure-library.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
