(ns clojure-library.book
  (:require [clojure.string :as str]
            [utils.file-reader :as reader]))

(def books (reader/load-edn "resources/books.edn"))

(defn search-books-by-language [books language]
  (filter (fn [book] (= (:language book) language)) books))

(defn- get-author [{:keys [author]}]
  author)

(comment
  (filter (fn [{:keys [language]}] (= language :fr)) books)
  (let [herge {:fullname "Georges Remi"
               :nickname "Hergé"
               :birth    {:date    1907
                          :country "Belgique"}}
        {:keys [author] :as _my-book} {:comic  "Les Aventures de Tintin"
                                       :title  "Le secret de la licorne"
                                       :author herge}]
    (-> author :birth :country str/upper-case)
    )
  )
