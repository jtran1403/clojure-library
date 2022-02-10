(ns clojure-library.book-test
  (:require [clojure.test :refer :all]
            [clojure-library.book :refer [search-books-by-language]]))

(def books [{:id 1 :language :en}
            {:id 2 :language :fr}
            {:id 3}
            {:id 4 :language :fr}
            {:id 5 :language :es}])

(deftest search-books-by-language-test
  (is (= (search-books-by-language books :fr)
         [{:id 2 :language :fr}
          {:id 4 :language :fr}
          ]))
  (are [language] (= (search-books-by-language books language))
    "fr" []
    :es [{:id 5 :language :es}]
    nil [{:id 3}]
    )
  )
