(ns clojure-library.webserver-test
  "Utility functions for running unit tests"
  (:require [clojure-library.webserver :refer [init-routes]]
            [clojure.test :refer :all])
  )

(deftest ping-route-test
  (let [routes-handler (init-routes)
        ping-result (routes-handler {:request-method :get, :uri "/ping"})]
    (is (= 200 (:status ping-result)))
    (is (= "pong!" (:body ping-result)))
    ))


(deftest homepage-test
  (let [routes-handler (init-routes)
        ping-result (routes-handler {:request-method :get, :uri "/"})]
    (is (= 200 (:status ping-result)))
    (is (= "welcome to the library" (:body ping-result)))
    ))


(deftest not-handled-page-test
  (let [routes-handler (init-routes)
        ping-result (routes-handler {:request-method :get, :uri "/void"})]
    (is (= 404 (:status ping-result)))
    (is (= "Book of the void" (:body ping-result)))
    ))

