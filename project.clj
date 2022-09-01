(defproject clojure-library "0.1.1-SNAPSHOT"
  :description "Clojure basics"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [integrant "0.8.0"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [metosin/reitit "0.5.18"]]
  :main ^:skip-aot clojure-library.core
  :repl-options {:init-ns user}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[integrant/repl "0.3.1"]]
                   :source-paths ["dev"]}})
