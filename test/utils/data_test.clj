(ns utils.data-test
  (:require [clojure.test :refer :all]
            [utils.data :refer [deep-merge]]))

(deftest deep-merge-test
  (testing "maps are merged recursively"
    (is (= (deep-merge {:a 1 :b {:c 2 :d 3} :c 3}
                       {:b {:c 5 :d 3} :c 3})
           {:a 1 :b {:c 5 :d 3} :c 3}
           )))
  )
