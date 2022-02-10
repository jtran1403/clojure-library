(ns clojure-library.book
  (:require [clojure.string :as str]
            [utils.file-reader :as reader]))

(def books (reader/load-edn "resources/books.edn"))

(comment
  (for [i (range 10)]
    i)
  (for [book books]
    (clojure.pprint/pprint book))
  (filter (fn [book] (= (:language book) :fr)) books)
  (map :title books)
  (reduce (fn [current_value book] (+ current_value (:pages book)))
          0 books))


(defn search-books-by-language [books language]
  (filter (fn [book] (= (:language book) language)) books))


(defn- get-author [book]
  (:author book))

(comment
  (filter #(= (:language %) :fr) books)
  (let [herge {:fullname "Georges Remi"
               :nickname "Hergé"
               :birth    {:date    1907
                          :country "Belgique"}}
        very-detailed-book {:comic  "Les Aventures de Tintin"
                            :title  "Le secret de la licorne"
                            :author herge}]
    ;(:country (:birth (:author very-detailed-book)))
    ;first-thread
    (-> very-detailed-book :author :birth :country str/upper-case)

    (-> 1
        (+ 2)
        (+ 5))
    (+ (+ 1 2) 5)

    (-> "a"
        (str "b" "c"))

    ;last-thread
    (->> "a"
        (str "b" "c"))

    (->> books
         (filter #(.contains (:tags %) :tragedy))
         (map :title))
    )
  )
