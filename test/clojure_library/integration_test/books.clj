(ns clojure-library.integration-test.books
  "Basic integration tests"
  (:require [clojure-library.integration-test.tools :refer :all]
            [clojure.test :refer :all]
            [clojure.edn :as edn]))

(def system {})

(deftest integration-test
  (testing "fetch knowledge"
    (with-server [system test-config]
                 (let [{:keys [status body]} ((:webserver/routes system) {:request-method :get, :uri "/books"})]
                   (is (= 200 status))
                   (is (= ["Romeo and Juliet" "Roméo et Juliette"
                           "Les Enquêtes d'Hercule Poirot" "Le Seigneur des anneaux : la communauté de l'anneau"]
                          (->> body
                               (edn/read-string)
                               (map :title))))
                   )))
  )


(deftest integration-test-with-async
  (testing "call from the outside"
    (with-server [system test-config]
                 (let [{:keys [status body]} (http-get (str app-url "/books"))]
                   (is (= 200 status)
                       (is (= ["Romeo and Juliet" "Roméo et Juliette"
                               "Les Enquêtes d'Hercule Poirot" "Le Seigneur des anneaux : la communauté de l'anneau"]
                              (->> body
                                   (edn/read-string)
                                   (map :title))))
                       )))
    ))

